package com.example.hw2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

// 시간표를 실행하기 전 description 화면

public class TimeTable0 extends Activity implements OnClickListener{

    Button run_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table0);// Time Table description 화면과 연결

        run_bt = (Button)findViewById(R.id.run_bt);// 버튼 연결
        run_bt.setOnClickListener(this);
    }

    public void onClick(View view) {

        if(view.getId() == run_bt.getId()) {// 버튼을 눌렀을 경우..
            Intent runTimeTable = new Intent(this, TimeTable1.class);// 시간표 activity를 Intent 변수에 담아준다
            startActivity(runTimeTable);// 시간표 activity를 화면에 띄워준다
        }
    }
}
