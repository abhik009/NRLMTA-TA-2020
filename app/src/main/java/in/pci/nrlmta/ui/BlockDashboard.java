package in.pci.nrlmta.ui;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import in.pci.nrlmta.R;
import in.pci.nrlmta.db.AppsDatabase;
import in.pci.nrlmta.models.ChartModel;
import in.pci.nrlmta.models.ListItem;
import in.pci.nrlmta.models.ModelOne;
import me.ithebk.barchart.BarChart;
import me.ithebk.barchart.BarChartModel;

public class BlockDashboard extends Fragment {
    private Spinner cbDistrict, cbBlock;
    private BarChart chartVillages, chartShg, chartShgMember, chartCRP, chartCC, chartGRS, chartOthers;
    private ModelOne modelVillage, modelShg, modelShgMember, modelCRP, modelCC, modelGRS, modelOthers;
    private ArrayAdapter<String> districtAdapter, blockAdapter;
    private ChartModel chartModel;
    private ListItem listItem;
    private AppsDatabase appsDatabase;
    private List<String> districtList = new ArrayList<>();
    private List<String> blockList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dash_block, container, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        initView(view);

        cbDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    new InitTask().execute(listItem.getState());
                else if (position >= 1) {
                    new DisrtictTask().execute(listItem.getState() + "/" + cbDistrict.getSelectedItem().toString().replace(" ", "_"));
                    cbBlock.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        cbBlock.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    new DisrtictTask().execute(listItem.getState()
                            + "/" + cbDistrict.getSelectedItem().toString().replace(" ", "_"));
                else if (position >= 1)
                    new BlockTask().execute(listItem.getState() + "/" + cbDistrict.getSelectedItem().toString().replace(" ", "_")
                            + "/" + cbBlock.getSelectedItem().toString().replace(" ", "_"));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        return view;
    }

    private void showVillageChart() {
        int expected = modelVillage.getExpected() == null ? 0 : modelVillage.getExpected().intValue();
        int participated = modelVillage.getParticipated() == null ? 0 : modelVillage.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        chartVillages = chartModel.BlockCharts(chartVillages);
    }

    private void showShgChart() {
        int expected = modelShg.getExpected() == null ? 0 : modelShg.getExpected().intValue();
        int participated = modelShg.getParticipated() == null ? 0 : modelShg.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        chartShg = chartModel.BlockCharts(chartShg);
    }

    private void showShgMemChart() {
        int expected = modelShgMember.getExpected() == null ? 0 : modelShgMember.getExpected().intValue();
        int participated = modelShgMember.getParticipated() == null ? 0 : modelShgMember.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        chartShgMember = chartModel.BlockCharts(chartShgMember);
    }

    private void showCRPChart() {
        int expected = modelCRP.getExpected() == null ? 0 : modelCRP.getExpected().intValue();
        int participated = modelCRP.getParticipated() == null ? 0 : modelCRP.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        chartCRP = chartModel.BlockCharts(chartCRP);
    }

    private void showCCChart() {
        int expected = modelCC.getExpected() == null ? 0 : modelCC.getExpected().intValue();
        int participated = modelCC.getParticipated() == null ? 0 : modelCC.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        chartCC = chartModel.BlockCharts(chartCC);
    }

    private void showGRSChart() {
        int expected = modelGRS.getExpected() == null ? 0 : modelGRS.getExpected().intValue();
        int participated = modelGRS.getParticipated() == null ? 0 : modelGRS.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        chartGRS = chartModel.BlockCharts(chartGRS);
    }

    private void showOtherChart() {
        int expected = modelOthers.getExpected() == null ? 0 : modelOthers.getExpected().intValue();
        int participated = modelOthers.getParticipated() == null ? 0 : modelOthers.getParticipated().intValue();
        chartModel = new ChartModel(expected,participated);
        chartOthers = chartModel.BlockCharts(chartOthers);
    }

    private void initView(View view) {
        cbDistrict = view.findViewById(R.id.cb_two_district);
        districtList.add(0, "DISTRICT");
        districtAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, districtList);
        districtAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        districtAdapter.setNotifyOnChange(true);
        cbDistrict.setAdapter(districtAdapter);

        cbBlock = view.findViewById(R.id.cb_two_block);
        blockList.add(0, "BLOCK");
        blockAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, blockList);
        blockAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        blockAdapter.setNotifyOnChange(true);
        cbBlock.setAdapter(blockAdapter);

        chartVillages = view.findViewById(R.id.bc_one);
        chartShg = view.findViewById(R.id.bc_two);
        chartShgMember = view.findViewById(R.id.bc_three);
        chartCRP = view.findViewById(R.id.bc_four);
        chartCC = view.findViewById(R.id.bc_five);
        chartGRS = view.findViewById(R.id.bc_six);
        chartOthers = view.findViewById(R.id.bc_seven);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listItem = (ListItem) getArguments().getSerializable("ListItem");
        appsDatabase = AppsDatabase.getInstance(getContext());
        modelVillage = new ModelOne();
        modelShg = new ModelOne();
        modelShgMember = new ModelOne();
        modelCRP = new ModelOne();
        modelCC = new ModelOne();
        modelGRS = new ModelOne();
        modelOthers = new ModelOne();
        new InitTask().execute(listItem.getState());
    }

    class InitTask extends AsyncTask<String, Void, Void> {
        List<String> templist = new ArrayList<>();

        @Override
        protected Void doInBackground(String... strings) {
            templist = appsDatabase.mBaseDao().getDistrict(strings[0]);
            modelVillage.setExpected(appsDatabase.mBaseDao().getVillageData(strings[0]));
            modelVillage.setParticipated(appsDatabase.mBlockOneDao().getVillageData(strings[0]));
            modelShg.setExpected(appsDatabase.mBaseDao().getShgData(strings[0]));
            modelShg.setParticipated(appsDatabase.mBlockOneDao().getShgData(strings[0]));
            modelShgMember.setExpected(appsDatabase.mBaseDao().getShgMemData(strings[0]));
            modelShgMember.setParticipated(appsDatabase.mBlockTwoDao().getShgMemData(strings[0]));
            modelCRP = appsDatabase.mBlockTwoDao().getCrpData(strings[0]);
            modelCC = appsDatabase.mBlockTwoDao().getCCData(strings[0]);
            modelGRS = appsDatabase.mBlockTwoDao().getGRSData(strings[0]);
            modelOthers = appsDatabase.mBlockTwoDao().getOthersData(strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (districtList.size() > 0) {
                districtList.clear();
                districtList.add("DISTRICTS");
            }
            for (String names : templist)
                districtList.add(names.replace("_", " "));
            cbBlock.setVisibility(View.GONE);
            showVillageChart();
            showShgChart();
            showShgMemChart();
            showCRPChart();
            showCCChart();
            showGRSChart();
            showOtherChart();
        }
    }

    class DisrtictTask extends AsyncTask<String, Void, Void> {
        List<String> templist = new ArrayList<>();

        @Override
        protected Void doInBackground(String... strings) {
            String[] values = strings[0].split("/");
            templist = appsDatabase.mBaseDao().getBlock(values[0], values[1]);
            modelVillage.setExpected(appsDatabase.mBaseDao().getVillageData(values[0], values[1]));
            modelVillage.setParticipated(appsDatabase.mBlockOneDao().getVillageData(values[0], values[1]));
            modelShg.setExpected(appsDatabase.mBaseDao().getShgData(values[0], values[1]));
            modelShg.setParticipated(appsDatabase.mBlockOneDao().getShgData(values[0], values[1]));
            modelShgMember.setExpected(appsDatabase.mBaseDao().getShgMemData(values[0], values[1]));
            modelShgMember.setParticipated(appsDatabase.mBlockTwoDao().getShgMemData(values[0], values[1]));
            modelCRP = appsDatabase.mBlockTwoDao().getCrpData(values[0], values[1]);
            modelCC = appsDatabase.mBlockTwoDao().getCCData(values[0], values[1]);
            modelGRS = appsDatabase.mBlockTwoDao().getGRSData(values[0], values[1]);
            modelOthers = appsDatabase.mBlockTwoDao().getOthersData(values[0], values[1]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (blockList.size() > 0) {
                blockList.clear();
                blockList.add("BLOCKS");
            }
            for (String names : templist)
                blockList.add(names.replace("_", " "));
            cbBlock.setVisibility(View.VISIBLE);
            showVillageChart();
            showShgChart();
            showShgMemChart();
            showCRPChart();
            showCCChart();
            showGRSChart();
            showOtherChart();
        }
    }

    class BlockTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            String[] values = strings[0].split("/");
            modelVillage.setExpected(appsDatabase.mBaseDao().getVillageData(values[0], values[1], values[2]));
            modelVillage.setParticipated(appsDatabase.mBlockOneDao().getVillageData(values[0], values[1], values[2]));
            modelShg.setExpected(appsDatabase.mBaseDao().getShgData(values[0], values[1], values[2]));
            modelShg.setParticipated(appsDatabase.mBlockOneDao().getShgData(values[0], values[1], values[2]));
            modelShgMember.setExpected(appsDatabase.mBaseDao().getShgMemData(values[0], values[1], values[2]));
            modelShgMember.setParticipated(appsDatabase.mBlockTwoDao().getShgMemData(values[0], values[1], values[2]));
            modelCRP = appsDatabase.mBlockTwoDao().getCrpData(values[0], values[1], values[2]);
            modelCC = appsDatabase.mBlockTwoDao().getCCData(values[0], values[1], values[2]);
            modelGRS = appsDatabase.mBlockTwoDao().getGRSData(values[0], values[1], values[2]);
            modelOthers = appsDatabase.mBlockTwoDao().getOthersData(values[0], values[1], values[2]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            showVillageChart();
            showShgChart();
            showShgMemChart();
            showCRPChart();
            showCCChart();
            showGRSChart();
            showOtherChart();
        }
    }
}
