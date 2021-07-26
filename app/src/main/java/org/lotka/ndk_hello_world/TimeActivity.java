package org.lotka.ndk_hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class TimeActivity extends AppCompatActivity {
    TextView out ;

    static {
        System.loadLibrary("native-lib");
    }

    public native long clock ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        out = findViewById(R.id.clockoutput);
        new CountDownTimer(100000 , 100){

            @Override
            public void onTick(long millisUntilFinished) {
                out.setText(clock()+"");
            }

            @Override
            public void onFinish() {

            }
        }.start();
        out.setText(clock()+"");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TimeActivity.this , MainActivity.class));
        finish();
    }
}