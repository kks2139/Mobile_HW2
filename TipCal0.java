package com.example.hw2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

// 팁 계산기를 실행하기 전 description 화면

public class TipCal0 extends Activity implements OnClickListener {

    Button tip_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_cal0);// Tip calculator description 화면과 연결


        tip_bt = (Button)findViewById(R.id.tip_bt);// 버튼 연결
        tip_bt.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (view.getId() == tip_bt.getId())// 버튼을 눌렀을 경우..
        {
            Intent runTipCal = new Intent(this, TipCal1.class);// Intent 변수에 TipCal activity를 담아줌
            startActivity(runTipCal);// Tip Calculator activity를 띄워줌
        }
    }
}
