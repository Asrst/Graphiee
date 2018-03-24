package venky.spirometer.graphiee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button mButton;
    public EditText mEditA, mEditB, mEditC;
    public TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.button1);

        // Done button functionality and Calling the Intent

        mButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                mEditA   = (EditText)findViewById(R.id.inputA);
                mEditB   = (EditText)findViewById(R.id.inputB);
                mEditC   = (EditText)findViewById(R.id.inputC);

                //create new Intent
                Intent outputIntent = new Intent(MainActivity.this, dataOutputActivity.class);
                outputIntent.putExtra("InputA",mEditA.getText().toString());
                outputIntent.putExtra("InputB",mEditB.getText().toString());
                outputIntent.putExtra("InputC",mEditC.getText().toString());
                startActivity(outputIntent);

            }
        });

    }
}
