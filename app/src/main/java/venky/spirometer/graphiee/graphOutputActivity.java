package venky.spirometer.graphiee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphOutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_output);

        Bundle bundle = getIntent().getExtras();
        String valueT = bundle.getString("Inputa");
        String valueA0 = bundle.getString("Inputa0");
        //String valueB = bundle.getString("Inputb");
        String valueB0 = bundle.getString("Inputb0");
        //String valueC = bundle.getString("Inputc");
        String valueC0 = bundle.getString("Inputc0");


        final double T = Double.parseDouble(valueT);
        final double A0 = Double.parseDouble(valueA0);
        //final double B = Double.parseDouble(valueB);
        final double B0 = Double.parseDouble(valueB0);
        //final double C = Double.parseDouble(valueC);
        final double C0 = Double.parseDouble(valueC0);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(A0,T),
                new DataPoint(B0,T),
                new DataPoint(C0,T)
        });
        graph.addSeries(series);
    }
}
