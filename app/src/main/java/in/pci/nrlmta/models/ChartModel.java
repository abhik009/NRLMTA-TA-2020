package in.pci.nrlmta.models;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import me.ithebk.barchart.BarChart;
import me.ithebk.barchart.BarChartModel;

public class ChartModel {
    private BarChartModel barOne, barTwo;
    private List<BarChartModel> barChartList = new ArrayList<>();
    private int expected, participated;

    public ChartModel(int expected, int participated) {
        this.expected = expected;
        this.participated = participated;
        barOne = new BarChartModel();
        barTwo = new BarChartModel();
    }

    public BarChart Charts(BarChart chart) {
        barOne.setBarColor(Color.parseColor("#9C27B0"));
        barTwo.setBarColor(Color.parseColor("#512da8"));
        barOne.setBarValue(expected);
        barTwo.setBarValue(participated);
        barOne.setBarText(String.valueOf(expected));
        barTwo.setBarText(String.valueOf(participated));
        barChartList.clear();
        barChartList.add(barOne);
        barChartList.add(barTwo);
        chart.setBarMaxValue(expected + 150);
        chart.addBar(barChartList);
        return chart;
    }

    public BarChart BlockCharts(BarChart chart) {
        barOne.setBarColor(Color.parseColor("#9C27B0"));
        barTwo.setBarColor(Color.parseColor("#512da8"));
        barOne.setBarValue(expected);
        barTwo.setBarValue(participated);
        barOne.setBarText(String.valueOf(expected));
        barTwo.setBarText(String.valueOf(participated));
        barChartList.clear();
        barChartList.add(barOne);
        barChartList.add(barTwo);
        chart.setBarMaxValue(expected > participated ? expected + 1000 : participated + 1000);
        chart.addBar(barChartList);
        return chart;
    }
}
