package org.lotka.ndksamples;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SendAndChangeStringActivity extends AppCompatActivity {

    TextView output  ;
    com.google.android.material.textfield.TextInputEditText input ;
    Button doit;
    static {
        System.loadLibrary("native-lib");
    }
    public native String sendretrivechangeddata(String first ) ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Send and Change");
        setContentView(R.layout.activity_send_and_change_string);
        findView();
        click();
    }

    private void click() {
        doit.setOnClickListener(v -> {
            output.setText(sendretrivechangeddata(input.getText().toString().trim()));
        });
    }

    private void findView (){
        input = findViewById(R.id.SendAndChangeStringActivityinput);
        output =  findViewById(R.id.SendAndChangeStringActivityoutput);
        doit=findViewById(R.id.xmlsendchangeretrivebtn);
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(SendAndChangeStringActivity.this , MainActivity.class));
        finish();
    }
}