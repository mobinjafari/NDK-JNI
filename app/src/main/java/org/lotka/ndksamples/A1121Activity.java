package org.lotka.ndksamples;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class A1121Activity extends AppCompatActivity {

    TextView txt;
    Button defclassbtn;

    static {
        System.loadLibrary("native-lib");
    }


    public native int getversion33();

    public native int getversion34();

    private native int fromreflected();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1121);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("1121 project");
        findView();
        func();


    }

    private void func() {
        txt.setText("version is  " + getversion33() + "nextversion is : " + getversion34());
        defclassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromreflected();
            }
        });
    }

    private void findView() {
        txt=findViewById(R.id.tv1121a);
        defclassbtn=findViewById(R.id.getJVM);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(A1121Activity.this , MainActivity.class));
        finish();
    }
}