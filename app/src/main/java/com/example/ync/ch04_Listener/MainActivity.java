package com.example.ync.ch04_MemberClassListener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txvPointResult;
    Button btnSelect1, btnSelect2;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvPointResult = (TextView) findViewById(R.id.pointResult);
        txvPointResult.setOnLongClickListener(myLongListener);
        btnSelect1 = (Button) findViewById(R.id.select1);
        btnSelect1.setOnClickListener(myListener); //設定監聽物件 set Listener
        btnSelect1.setOnLongClickListener(myLongListener);
        btnSelect2 = (Button) findViewById(R.id.select2);
        btnSelect2.setOnClickListener(myListener); //設定監聽物件 set Listener

        /* 內部匿名類別 Anonymous Inner Listener
          * btnSelect1.setOnClickListener(new OnClickListener() {
          * public void onClick(View v){
          * System.out.println("Anonymous Inner Listener"); }
          * })
        */
    }

    //自訂內部監聽類別, 不用全部都塞在主活動類別, 造成不易維護
    //Member Class Listener
    class MyOnClickListener implements View.OnClickListener, View.OnLongClickListener{

        @Override  //按一下 Click
        public void onClick(View v) {
            if(v.getId()==R.id.select1){
                txvPointResult.setText(String.valueOf(++counter));
            }else {
                if (v.getId() == R.id.select2) {
                    txvPointResult.setText(String.valueOf(--counter));
                }
            }
        }

        @Override //長按 Long Click
        public boolean onLongClick(View v) {
            if(v.getId()==R.id.pointResult){
                counter =0;
                txvPointResult.setText(String.valueOf(counter));
            } else{
                counter +=2;
                txvPointResult.setText(String.valueOf(counter));
            }
            return true;
        }
    }
    //建立監聽物件 build Listener Object
    View.OnClickListener myListener = new MyOnClickListener();
    View.OnLongClickListener myLongListener = new MyOnClickListener();

}
