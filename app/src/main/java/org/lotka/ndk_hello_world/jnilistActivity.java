package org.lotka.ndk_hello_world;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class jnilistActivity extends AppCompatActivity {

    ArrayList<Integer> list ;
    TextView tv1 , tv2  ;
    Button btn ;
    Button two ;

    static {
        System.loadLibrary("native-lib");
    }
    public native ArrayList flist( ArrayList list) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jnilist);
        garphic();
        findView();
        addItemToList();
        go();


    }

    private void garphic() {
        // here is what we do

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("jni list");

    }

    private void go() {
        tv1.setText(list.size()+"");
        btn.setOnClickListener(v -> {
            ArrayList newArray = new ArrayList();
            newArray=  flist(list);
            tv2.setText(newArray.toString()+"");
        });
    }

    private void addItemToList() {
        list.add(22);
        list.add(23);
        list.add(24);
    }

    private void findView() {
        list= new ArrayList<>();
        tv1=findViewById(R.id.listacttxt1);
        tv2= findViewById(R.id.listacttxt2);
        btn = findViewById(R.id.listactbtn);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(jnilistActivity.this , MainActivity.class));
        finish();
    }
}