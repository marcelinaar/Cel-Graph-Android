package marcelinaar.graphbeideal;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = (BarChart) findViewById(R.id.chart);
        ArrayList<String> xAxis = new ArrayList<>();
        ArrayList<IBarDataSet> dataSets = null;
        ArrayList<BarEntry> valueSet = new ArrayList<>();

        xAxis.add("D4/S1");
        xAxis.add("S2");
        xAxis.add("Kerja");
        xAxis.add("Nikah");


        valueSet.add(new BarEntry(20, 0));
        valueSet.add(new BarEntry(26, 1));
        valueSet.add(new BarEntry(37, 2));
        valueSet.add(new BarEntry(17, 3));

        BarDataSet barDataSet = new BarDataSet(valueSet, "Pilihan Mahasiswa POLINEMA Setelah Lulus Kuliah");
        barDataSet.setColors(new int[] {Color.RED,Color.GREEN,Color.MAGENTA,Color.BLUE});

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet);

        YAxis yAxisRight = chart.getAxisRight();
        yAxisRight.setEnabled(false);

        BarData data = new BarData(xAxis, dataSets);
        chart.setExtraOffsets(0, 0, 0, 20);
        chart.setData(data);
        chart.animateXY(2000, 2000);
        chart.invalidate();
    }
}
