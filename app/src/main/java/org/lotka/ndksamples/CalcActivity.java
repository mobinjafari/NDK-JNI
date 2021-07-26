package org.lotka.ndksamples;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CalcActivity extends AppCompatActivity {

    Button multiple , minus , sum , devide ;
    com.google.android.material.textfield.TextInputEditText in1 , in2 ;
    TextView out ;
    static {
        System.loadLibrary("native-lib");

    }
    public native int  calcfun( int first  , int second , int type);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        ActionBar actionBar = getSupportActionBar() ;
        actionBar.setTitle("NDk Calcualtor");
        findView();
        onclick();
    }

    private void onclick() {


        sum.setOnClickListener(v -> {

            if(in1.getText().toString().trim().isEmpty() || in2.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "its empty", Toast.LENGTH_SHORT).show();
                return;
            }

            int fir = Integer.parseInt(in1.getText().toString().trim());
            int sec = Integer.parseInt(in2.getText().toString().trim());

            out.setText(calcfun(fir , sec , 1)+"");

        });
        minus.setOnClickListener(v -> {

            if(in1.getText().toString().trim().isEmpty() || in2.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "its empty", Toast.LENGTH_SHORT).show();
                return;
            }

            int fir = Integer.parseInt(in1.getText().toString().trim());
            int sec = Integer.parseInt(in2.getText().toString().trim());

            out.setText(calcfun(fir , sec , 2)+"");

        });
        devide.setOnClickListener(v -> {

            if(in1.getText().toString().trim().isEmpty() || in2.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "its empty", Toast.LENGTH_SHORT).show();
                return;
            }

            int fir = Integer.parseInt(in1.getText().toString().trim());
            int sec = Integer.parseInt(in2.getText().toString().trim());

            out.setText(calcfun(fir , sec , 4)+"");

        });
        multiple.setOnClickListener(v -> {
            if(in1.getText().toString().trim().isEmpty() || in2.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "its empty", Toast.LENGTH_SHORT).show();
                return;
            }

            int fir = Integer.parseInt(in1.getText().toString().trim());
            int sec = Integer.parseInt(in2.getText().toString().trim());

            out.setText(calcfun(fir , sec , 3)+"");

        });

    }

    private void findView() {
        multiple=findViewById(R.id.calcbutmultiply);
        devide = findViewById(R.id.calcbutdevide);
        sum= findViewById(R.id.calcbutsum);
        minus = findViewById(R.id.calcbutminsuse);
        in1=findViewById(R.id.num1calcinpt);
        in2=findViewById(R.id.num2calcinpt);
        out=findViewById(R.id.clacoutput);
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(CalcActivity.this , MainActivity.class));
        finish();
    }
}