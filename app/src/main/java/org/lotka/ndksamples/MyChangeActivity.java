package org.lotka.ndksamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyChangeActivity extends AppCompatActivity {

    //define variables
    public int a = 20 ;
    public String b = "a";
    public boolean c = false ;

    //define widgets
    Button show, change;
    TextView outString , outInt , outBoolean , outChar ;

    //declare ndk
    static {
        System.loadLibrary("native-lib");
    }
    public static native void myfunction4int (MyChangeActivity mclass);
    public static native void myfunction4string (MyChangeActivity mclass);
    public static native void myfunction4boolean (MyChangeActivity mclass);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_change);
        findViewsById();
        click();
        mOnCreate();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MyChangeActivity.this , MainActivity.class));
        finish();
    }

    private void mOnCreate() {
        outString.setText("String is : "+ b);
        outInt.setText("int is =  "+a );
        outBoolean.setText("boolean is : " + c);
    }


    private void findViewsById() {
        show =findViewById(R.id.showndk);
        change=findViewById(R.id.dondk);
        outInt=findViewById(R.id.outint);
        outString =findViewById(R.id.outstring);
        outBoolean= findViewById(R.id.outboolean);
    }

    private void click() {
        show.setOnClickListener(v -> {
            outString.setText("String is : "+ b);
            outInt.setText("int is =  "+a );
            outBoolean.setText("boolean is : " + c);
        });

        change.setOnClickListener(v -> {
            myfunction4int(this);
            myfunction4string(this);
            myfunction4boolean(this);
        });
    }
    
}