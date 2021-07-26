package org.lotka.ndksamples;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class ChangeVarActivity extends AppCompatActivity {
    private static final String TAG = "jtag";
    public static int a = 80 ;

    //declare

    TextView output ;
    Button changevalbtn , showvalbtn ;

    //ndk
    static {
        System.loadLibrary("native-lib");
    }

    public static  native void changeValue2(int a);
    //ndk - done


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_var);
        ActionBar actionBar =getSupportActionBar() ;
        actionBar.setTitle("Change Var Val");
        define();
        click();
    }

    private void click() {

        changevalbtn.setOnClickListener(v -> {
            changeValue2(a);
        });

        showvalbtn.setOnClickListener(v -> {
            output.setText("value was " + a);
        });

        }


    private void define() {
        changevalbtn=findViewById(R.id.changevaluebut);
        showvalbtn=findViewById(R.id.showoutpute);
        output = findViewById(R.id.latestoutput);
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(ChangeVarActivity.this , MainActivity.class));
        finish();
    }

    public static void inc3(IntWrapper val) {
        val.setInt(val.getInt()+1);
        a= val.getInt();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}