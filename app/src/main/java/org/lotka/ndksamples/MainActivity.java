package org.lotka.ndksamples;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button btn1, btn2 , btn3 , btn4 , btn5 , btn6 , btn7  , btn8 , b1121 , b1122 , b1123  , b1124;
    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("NDK Exmaples");
        findID();
        click();
    }
    private void click() {
        btn1.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, HelloWorldActivity.class));
            finish();
        });
        btn2.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SendRetriveDataActivity.class));
            finish();
        });
        btn3.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this , SendAndChangeStringActivity.class));
            finish();
        });
        btn4.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , CalcActivity.class));
            finish();
        });
        btn5.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , TimeActivity.class));
            finish();
        });
        btn6.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , ChangeVarActivity.class));
            finish();
        });
        btn7.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , MyChangeActivity.class));
            finish();
        });
        btn8.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , jnilistActivity.class));
            finish();
        });
        b1121.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this , A1121Activity.class));
            finish();
        });



    }

    private void findID() {
        btn1 = findViewById(R.id.xmlbutton1);
        btn2 = findViewById(R.id.xmlbutton2);
        btn3=findViewById(R.id.xmlbutton3);
        btn4= findViewById(R.id.xmlbutton4);
        btn5= findViewById(R.id.xmlbutton5);
        btn6= findViewById(R.id.xmlbutton6);
        btn7=findViewById(R.id.xmlbutton7);
        btn8= findViewById(R.id.xmlbutton8);
        b1121=findViewById(R.id.xmlbutton1121);
    }


}