package org.lotka.ndk_hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWorldActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }



    protected native String helloFromJni ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        TextView txx1 = findViewById(R.id.HelloWorldActivityText1);
        txx1.setText(helloFromJni());

        //logic

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HelloWorldActivity.this ,MainActivity.class));
        finish();
    }
}