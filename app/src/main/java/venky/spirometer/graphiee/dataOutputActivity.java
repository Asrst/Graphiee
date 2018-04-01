package venky.spirometer.graphiee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dataOutputActivity extends AppCompatActivity {

    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_output);

        Bundle bundle = getIntent().getExtras();
        String messageA = bundle.getString("InputA");
        String messageB = bundle.getString("InputB");
        String messageC = bundle.getString("InputC");

       final double dA = Double.parseDouble(messageA);
       final double dB = Double.parseDouble(messageB);
       final double dC = Double.parseDouble(messageC);

        TextView showInputA = (TextView) findViewById(R.id.showInput_A);
        showInputA.setText("Input A: " + messageA);

        TextView showInputB = (TextView) findViewById(R.id.showInput_B);
        showInputB.setText("Input B: " + messageB);

        TextView showInputC = (TextView) findViewById(R.id.showInput_C);
        showInputC.setText("Input C: " + messageC);

        final double dT = dA+dB+dC;
        final double dA0 = (dA/dT)*100;
        final double dB0 = (dB/dT)*100;
        final double dC0 = (dC/dT)*100;

        TextView getInputA0 = (TextView) findViewById(R.id.getOutput_A0);
        getInputA0.setText("Input A0: " + String.valueOf(dA0));

        TextView getInputB0 = (TextView) findViewById(R.id.getOutput_B0);
        getInputB0.setText("Input B0: " + String.valueOf(dB0));

        TextView getInputC0 = (TextView) findViewById(R.id.getOutput_C0);
        getInputC0.setText("Input C0: " + String.valueOf(dC0));

        final TextView getBd = (TextView) findViewById(R.id.get_Bd);

        if (dA0 >= 80 || dB0 >= 80 || dC0 >= 80) {
            getBd.setText("Patient has Aasthma!");
        } else if ((dA0 < 80 || dB0 < 80 || dC0 < 80) && (dA0 > 60 || dB0 > 60 || dC0 > 60)) {
            getBd.setText("Patient has Bronchitis!");
        }


        // Done button functionality and Calling the Intent

        mButton = (Button)findViewById(R.id.button2);

        mButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                //create new Intent
                Intent outputIntent = new Intent(dataOutputActivity.this, graphOutputActivity.class);
                outputIntent.putExtra("Inputa",String.valueOf(dT));
                outputIntent.putExtra("Inputa0",String.valueOf(dA0));
                //outputIntent.putExtra("Inputb",String.valueOf(dB));
                outputIntent.putExtra("Inputb0",String.valueOf(dB0));
                // outputIntent.putExtra("Inputc",String.valueOf(dC));
                outputIntent.putExtra("Inputc0",String.valueOf(dC0));
                startActivity(outputIntent);

            }
        });



    }
}
