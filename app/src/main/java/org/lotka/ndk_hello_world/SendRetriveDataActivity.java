package org.lotka.ndk_hello_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class SendRetriveDataActivity extends AppCompatActivity {

    TextView output ;
    com.google.android.material.textfield.TextInputEditText input ;
    private native String sendRetrivestring(String first);

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_retrive_data);
        findId();
        click();


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SendRetriveDataActivity.this , MainActivity.class));
        finish();
    }

    private void click() {
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                output.setText(sendRetrivestring(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void findId() {
        output = findViewById(R.id.sendretrivedataactivityoutput);
        input  = findViewById(R.id.sendretrivedataactivityinput);
    }


    }

