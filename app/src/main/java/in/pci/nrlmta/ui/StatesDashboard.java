package in.pci.nrlmta.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import in.pci.nrlmta.R;
import in.pci.nrlmta.db.AppsDatabase;
import in.pci.nrlmta.models.ChartModel;
import in.pci.nrlmta.models.ModelOne;
import me.ithebk.barchart.BarChart;

public class StatesDashboard extends Fragment {

    private CardView cardStateNodal, cardDistrictNodal, cardBlockNodal, cardDrp, cardBrp, cardOther;
    private BarChart StateChart, DistrictChart, BlockChart, DRPChart, BRPChart, OtherChart;
    private Spinner cbState, cbDistrict, cbBlock;

    private ArrayAdapter<String> stateAdapter, districtAdapter, blockAdapter;
    private ModelOne gtState, gtDistrict, gtBlock, gtDRP, gtBRP, gtOther;
    private AppsDatabase appsDatabase;

    private List<String> statesList = new ArrayList<>();
    private List<String> districtList = new ArrayList<>();
    private List<String> blockList = new ArrayList<>();

    private ChartModel chartModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dash_state, container, false);
        init(view);

        cbState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 1) {
                    new FetchStateData().execute(cbState.getSelectedItem().toString().replace(" ", "_"));
                } else if (position == 0) {
                    new FetchInitData().execute();
                }
                sceneOne();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        cbDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 1) {
                    sceneTwo();
                    new FetchDistrictData().execute(cbState.getSelectedItem().toString().replace(" ", "_")
                            + "/" + cbDistrict.getSelectedItem().toString().replace(" ", "_"));
                } else if (position == 0) {
                    sceneOne();
                    new FetchStateData().execute(cbState.getSelectedItem().toString().replace(" ", "_"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        cbBlock.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 1) {
                    sceneThree();
                    new FetchBlockData().execute(cbState.getSelectedItem().toString().replace(" ", "_")
                            + "/" + cbDistrict.getSelectedItem().toString().replace(" ", "_")
                            + "/" + cbBlock.getSelectedItem().toString().replace(" ", "_"));
                }
                if (position == 0) {
                    sceneTwo();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return view;
    }

    private void sceneOne() {
        cardStateNodal.setVisibility(View.VISIBLE);
        cardDistrictNodal.setVisibility(View.VISIBLE);
        cardDrp.setVisibility(View.VISIBLE);
        cardBlockNodal.setVisibility(View.VISIBLE);
        cardBrp.setVisibility(View.VISIBLE);
        cardOther.setVisibility(View.VISIBLE);
    }

    private void sceneTwo() {
//        cbBlock.setVisibility(View.VISIBLE);
        cardStateNodal.setVisibility(View.GONE);
        cardDistrictNodal.setVisibility(View.VISIBLE);
        cardDrp.setVisibility(View.VISIBLE);
        cardBlockNodal.setVisibility(View.VISIBLE);
        cardBrp.setVisibility(View.VISIBLE);
        cardOther.setVisibility(View.GONE);
    }

    private void sceneThree() {
        cardStateNodal.setVisibility(View.GONE);
        cardDistrictNodal.setVisibility(View.GONE);
        cardDrp.setVisibility(View.GONE);
        cardBlockNodal.setVisibility(View.VISIBLE);
        cardBrp.setVisibility(View.VISIBLE);
        cardOther.setVisibility(View.GONE);
    }

    private void showStateChart() {
        int expected = gtState.getExpected() == null ? 0 : gtState.getExpected().intValue();
        int participated = gtState.getParticipated() == null ? 0 : gtState.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        StateChart = chartModel.Charts(StateChart);
    }

    private void showDistrictChart() {
        int expected = gtDistrict.getExpected() == null ? 0 : gtDistrict.getExpected().intValue();
        int participated = gtDistrict.getParticipated() == null ? 0 : gtDistrict.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        DistrictChart = chartModel.Charts(DistrictChart);
    }

    private void showBlockChart() {
        int expected = gtBlock.getExpected() == null ? 0 : gtBlock.getExpected().intValue();
        int participated = gtBlock.getParticipated() == null ? 0 : gtBlock.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        BlockChart = chartModel.Charts(BlockChart);
    }

    private void showDRPChart() {
        int expected = gtDRP.getExpected() == null ? 0 : gtDRP.getExpected().intValue();
        int participated = gtDRP.getParticipated() == null ? 0 : gtDRP.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        DRPChart = chartModel.Charts(DRPChart);
    }

    private void showBRPChart() {
        int expected = gtBRP.getExpected() == null ? 0 : gtBRP.getExpected().intValue();
        int participated = gtBRP.getParticipated() == null ? 0 : gtBRP.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        BRPChart = chartModel.Charts(BRPChart);
    }

    private void showOtherChart() {
        int expected = gtOther.getExpected() == null ? 0 : gtOther.getExpected().intValue();
        int participated = gtOther.getParticipated() == null ? 0 : gtOther.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        OtherChart = chartModel.Charts(OtherChart);
    }

    private void init(View view) {
        cbState = view.findViewById(R.id.cb_state);
        statesList.add(0, "STATES");
        stateAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, statesList);
        stateAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        stateAdapter.setNotifyOnChange(true);
        cbState.setAdapter(stateAdapter);

        cbDistrict = view.findViewById(R.id.cb_district);
        districtList.add(0, "DISTRICTS");
        districtAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, districtList);
        districtAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        districtAdapter.setNotifyOnChange(true);
        cbDistrict.setAdapter(districtAdapter);

        cbBlock = view.findViewById(R.id.cb_block);
        blockList.add(0, "BLOCKS");
        blockAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, blockList);
        blockAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        blockAdapter.setNotifyOnChange(true);
        cbBlock.setAdapter(blockAdapter);

        StateChart = view.findViewById(R.id.bar_chart_state);
        DistrictChart = view.findViewById(R.id.bar_chart_district);
        BlockChart = view.findViewById(R.id.bar_chart_block);
        DRPChart = view.findViewById(R.id.bar_chart_drp);
        BRPChart = view.findViewById(R.id.bar_chart_brp);
        OtherChart = view.findViewById(R.id.bar_chart_others);

        cardStateNodal = view.findViewById(R.id.states_graph_one);
        cardDistrictNodal = view.findViewById(R.id.states_graph_two);
        cardBlockNodal = view.findViewById(R.id.states_graph_three);
        cardDrp = view.findViewById(R.id.states_graph_four);
        cardBrp = view.findViewById(R.id.states_graph_five);
        cardOther = view.findViewById(R.id.states_graph_six);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        appsDatabase = AppsDatabase.getInstance(getContext());
        gtState = new ModelOne();
        gtDistrict = new ModelOne();
        gtBlock = new ModelOne();
        gtDRP = new ModelOne();
        gtBRP = new ModelOne();
        gtOther = new ModelOne();
        new FetchInitData().execute();
    }

    private class FetchInitData extends AsyncTask<Void, Void, Void> {
        List<String> tempList = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... voids) {
            tempList = appsDatabase.mBaseDao().getState();
            gtBRP = appsDatabase.mStateDao().getQ4Q5Values("BLOCK");
            gtBlock = appsDatabase.mStateDao().getQ2Q3Values("BLOCK");
            gtState = appsDatabase.mStateDao().getQ2Q3Values("STATE");
            gtOther = appsDatabase.mStateDao().getQ4Q5Values("STATE");
            gtDRP = appsDatabase.mStateDao().getQ4Q5Values("DISTRICT");
            gtDistrict = appsDatabase.mStateDao().getQ2Q3Values("DISTRICT");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            int i = 0;
            if (statesList.size() > 0) {
                statesList.clear();
                statesList.add("STATES");
            }
            for (String names : tempList)
                statesList.add(names.replace("_", " "));
            showStateChart();
            showDistrictChart();
            showBlockChart();
            showDRPChart();
            showBRPChart();
            showOtherChart();
            cbDistrict.setVisibility(View.GONE);
            cbBlock.setVisibility(View.GONE);
        }
    }

    private class FetchStateData extends AsyncTask<String, Void, Void> {
        List<String> tempList = new ArrayList<>();

        @Override
        protected Void doInBackground(String... strings) {
            tempList = appsDatabase.mBaseDao().getDistrict(strings[0]);
            gtBRP = appsDatabase.mStateDao().getQ4Q5Values("BLOCK", strings[0]);
            gtBlock = appsDatabase.mStateDao().getQ2Q3Values("BLOCK", strings[0]);
            gtState = appsDatabase.mStateDao().getQ2Q3Values("STATE", strings[0]);
            gtOther = appsDatabase.mStateDao().getQ4Q5Values("STATE", strings[0]);
            gtDRP = appsDatabase.mStateDao().getQ4Q5Values("DISTRICT", strings[0]);
            gtDistrict = appsDatabase.mStateDao().getQ2Q3Values("DISTRICT", strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            int i = 0;
            if (districtList.size() > 0) {
                districtList.clear();
                districtList.add("DISTRICTS");
            }
            for (String names : tempList)
                districtList.add(names.replace("_", " "));
            cbDistrict.setSelection(0);
            showStateChart();
            showDistrictChart();
            showBlockChart();
            showDRPChart();
            showBRPChart();
            showOtherChart();
            cbDistrict.setVisibility(View.VISIBLE);
            cbBlock.setVisibility(View.GONE);
        }
    }

    private class FetchDistrictData extends AsyncTask<String, Void, Void> {
        List<String> tempList = new ArrayList<>();

        @Override
        protected Void doInBackground(String... strings) {
            String[] values = strings[0].split("/");
            tempList = appsDatabase.mBaseDao().getBlock(values[0], values[1]);
            gtBRP = appsDatabase.mStateDao().getQ4Q5Values("BLOCK", values[0], values[1]);
            gtBlock = appsDatabase.mStateDao().getQ2Q3Values("BLOCK", values[0], values[1]);
            gtDRP = appsDatabase.mStateDao().getQ4Q5Values("DISTRICT", values[0], values[1]);
            gtDistrict = appsDatabase.mStateDao().getQ2Q3Values("DISTRICT", values[0], values[1]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            int i = 0;
            if (blockList.size() > 0) {
                blockList.clear();
                blockList.add("BLOCKS");
            }
            for (String names : tempList)
                blockList.add(names.replace("_", " "));
            cbBlock.setSelection(0);
            showDistrictChart();
            showBlockChart();
            showDRPChart();
            showBRPChart();
            cbBlock.setVisibility(View.VISIBLE);
        }
    }

    private class FetchBlockData extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            String[] values = strings[0].split("/");
            gtBRP = appsDatabase.mStateDao().getQ4Q5Values("BLOCK", values[0], values[1], values[2]);
            gtBlock = appsDatabase.mStateDao().getQ2Q3Values("BLOCK", values[0], values[1], values[2]);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showBlockChart();
            showBRPChart();
        }
    }
}