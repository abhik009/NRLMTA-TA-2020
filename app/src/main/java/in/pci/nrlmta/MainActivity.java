package in.pci.nrlmta;

import android.app.ProgressDialog;
import android.content.*;
import android.net.ConnectivityManager;
import android.os.*;
import android.util.Log;
import android.view.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.gson.Gson;

import java.util.List;

import es.dmoral.toasty.Toasty;
import in.pci.nrlmta.api.ApiClient;
import in.pci.nrlmta.api.ApiInterface;
import in.pci.nrlmta.db.AppsDatabase;
import in.pci.nrlmta.models.BaseDataModel;
import in.pci.nrlmta.models.BlockDataModel;
import in.pci.nrlmta.models.BlockOneModel;
import in.pci.nrlmta.models.BlockTwoModel;
import in.pci.nrlmta.models.DataState;
import in.pci.nrlmta.models.StateDataModel;
import in.pci.nrlmta.services.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home, R.id.nav_dash_state, R.id.nav_recyclerList, R.id.nav_dash_block).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        if (isOnline()) {
            getStateLevelData();
            getBlockLevelData();
            checkLoginStatus(SessionManager.getInstance(getApplicationContext()).isLoggedIn());
        } else {
            Toasty.error(getApplicationContext(), "Get Connected to internet to view latest MIS Report", Toasty.LENGTH_LONG).show();
        }
    }

    public void checkLoginStatus(boolean isLogin) {
        if (!isLogin)
            getBaseLevelData();
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                if (isOnline()) {
                    new RefreshData().execute();
                    Toasty.success(this, "Refreshed your Database", Toasty.LENGTH_LONG).show();
                } else {
                    Toasty.error(getApplicationContext(), "Can't Refresh: Not connected with internet").show();
                }
                break;
        }
        return true;
    }

    class RefreshData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            AppsDatabase.getInstance(getApplicationContext()).mStateDao().deleteAll();
            AppsDatabase.getInstance(getApplicationContext()).mBlockTwoDao().deleteAll();
            AppsDatabase.getInstance(getApplicationContext()).mBlockOneDao().deleteAll();
            AppsDatabase.getInstance(getApplicationContext()).mBlockTwoDao().deleteAll();
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // to always start activity as a new task
            startActivity(intent);
            return null;
        }
    }

    private void getBaseLevelData() {
        final ProgressDialog progressBarDialog = new ProgressDialog(this);
        progressBarDialog.setIcon(R.drawable.ic_icon);
        progressBarDialog.setMessage("Please wait, Fetching data...");
        progressBarDialog.setTitle("COVID-19 MIS");
        progressBarDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<BaseDataModel>> call = apiService.getBaseData();
        call.enqueue(new Callback<List<BaseDataModel>>() {
            @Override
            public void onResponse(Call<List<BaseDataModel>> call, Response<List<BaseDataModel>> response) {
                if (response.isSuccessful()) {
//                    Log.i("MIS Data", new Gson().toJson(response.body()));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO: Code to feed MIS Data into Database
                            if (AppsDatabase.getInstance(getApplicationContext()).mBaseDao().getAll().size() < 5184) {
                                AppsDatabase.getInstance(getApplicationContext()).mBaseDao().deleteAll();
                                for (BaseDataModel baseDataModel : response.body()) {
                                    AppsDatabase.getInstance(getApplicationContext()).mBaseDao().insert(baseDataModel);
                                }
                                progressBarDialog.dismiss();
                            } else {
                                SessionManager.getInstance(getApplicationContext()).createSession();
                                Log.i("Session Status", "Created Session");
                                checkLoginStatus(SessionManager.getInstance(getApplicationContext()).isLoggedIn());
                                progressBarDialog.dismiss();
                            }
                        }
                    }).start();
                    progressBarDialog.show();
                }
            }

            @Override
            public void onFailure(Call<List<BaseDataModel>> call, Throwable t) {
                Log.i("ErrorBase", t.toString());
                Toasty.error(getApplicationContext(), "Failed to load Base Data: " + t.toString()).show();
            }
        });
    }

    private void getStateLevelData() {
        final ProgressDialog progressBarDialog = new ProgressDialog(this);
        progressBarDialog.setIcon(R.drawable.ic_icon);
        progressBarDialog.setMessage("Fetching data, please wait...");
        progressBarDialog.setTitle("COVID-19 MIS");
        progressBarDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBarDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Toasty.info(getBaseContext(), "Fetching Data \n Please Wait!", Toasty.LENGTH_SHORT).show();
            }
        });

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<StateDataModel>> call = apiService.getStateData();
        call.enqueue(new Callback<List<StateDataModel>>() {
            @Override
            public void onResponse(Call<List<StateDataModel>> call, Response<List<StateDataModel>> response) {
//                Log.i("StateData", new Gson().toJson(response.body()));
                if (response.isSuccessful()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO: Code to feed State Level Data into Database
                            int i = 1;
                            for (StateDataModel stateDataModel : response.body()) {
                                try {
                                    for (DataState dataState : stateDataModel.getDataStates()) {
                                        dataState.setId(i); //generating id upto 10899299 rows;
                                        AppsDatabase.getInstance(getApplicationContext()).mStateDao().insert(dataState);
                                        i++;
                                    }
                                    progressBarDialog.dismiss();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                    progressBarDialog.show();
                } else
                    Toasty.error(getApplicationContext(), "State Success API Error").show();
            }

            @Override
            public void onFailure(Call<List<StateDataModel>> call, Throwable t) {
                Toasty.error(getApplicationContext(), "State Fail API Error: " + t.toString()).show();
                Log.e("ErrorState", t.toString());
            }
        });
    }

    private void getBlockLevelData() {
        final ProgressDialog progressBarDialog = new ProgressDialog(this);
        progressBarDialog.setIcon(R.drawable.ic_icon);
        progressBarDialog.setMessage("Please Wait Data is getting fetched...");
        progressBarDialog.setTitle("COVID-19 MIS");
        progressBarDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<BlockDataModel>> call = apiService.getBlockData();
        call.enqueue(new Callback<List<BlockDataModel>>() {
            @Override
            public void onResponse(Call<List<BlockDataModel>> call, Response<List<BlockDataModel>> response) {
                if (response.isSuccessful()) {
//                    Log.i("BlockData", new Gson().toJson(response.body()));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO: Code to feed Block Level Data into Database
                            int i = 1;
                            for (BlockDataModel blockDataModel : response.body()) {
                                BlockOneModel blockOneModel = new BlockOneModel(
                                        blockDataModel.getId(), blockDataModel.getToday(), blockDataModel.getG1S1(), blockDataModel.getG1D1(),
                                        blockDataModel.getG1B1(), blockDataModel.getG1LT(), blockDataModel.getG2V1(), blockDataModel.getG2SH1(),
                                        Integer.parseInt(blockDataModel.getVersion()), blockDataModel.getSubmissionTime());
                                AppsDatabase.getInstance(getApplicationContext()).mBlockOneDao().insert(blockOneModel);
                                try {
                                    for (BlockTwoModel dataBlock : blockDataModel.getDataBlock()) {
                                        dataBlock.setId(i); //generating id upto 10899299 rows;
                                        AppsDatabase.getInstance(getApplicationContext()).mBlockTwoDao().insert(dataBlock);
                                        i++;
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            progressBarDialog.dismiss();
                        }
                    }).start();
                    progressBarDialog.dismiss();
                } else Toasty.error(getApplicationContext(), "Block Success API Error").show();
            }

            @Override
            public void onFailure(Call<List<BlockDataModel>> call, Throwable t) {
                Log.e("ErrorBlock", t.toString());
                Toasty.error(getApplicationContext(), "Block Fail API Error" + t.toString()).show();
            }
        });
    }
}

//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//            }
//        });