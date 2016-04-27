package com.example.hw2;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
// Time Table activity
public class TimeTable1 extends Activity implements OnClickListener{

    // variables to contain xml data
    Button button;// 변수 선언
    TextView mon;
    TextView tus;
    TextView wed;
    TextView thu;
    TextView fri;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table1);// connect java and xml

        // connect and input views into java variables
        mon = (TextView)findViewById(R.id.mon0);// 월요일 ~ 금요일까지의 xml을 자바에 연결시킨다
        tus = (TextView)findViewById(R.id.tus0);
        wed = (TextView)findViewById(R.id.wed0);
        thu = (TextView)findViewById(R.id.thu0);
        fri = (TextView)findViewById(R.id.fri0);
        button = (Button)findViewById(R.id.bt);//findViewBtId 로 버튼 xml과 자바를 연결해준다
        // 그럼 button 이라는 변수에 그 버튼에 대한 메소드를 정의해줄수있다

    }
    public void onResume()// onResume 콜백 메소드
    {// 다시 작하거나 화면을 돌려도 색칠된 요일이 없어지지 않게 함
        super.onResume();
        updateTime();
    }
    private void updateTime()
    {   // 앱을 켜면 자동으로 버튼이 눌려지고 날짜가 업데이트된다
        // 그럼 업데이트된 요일에따라 시간표상 오늘 요일의 칸이 붉은색으로 변하고 글씨는 흰색으로 바뀌게 된다.
        button.setText("Today  is  "+new Date().toString().substring(0,3));
        if(new Date().toString().substring(0,3).equals("Mon")) {
            mon.setBackgroundColor(Color.RED);
            mon.setTextColor(Color.WHITE);
        }
        if(new Date().toString().substring(0,3).equals("Tue")) {
            tus.setBackgroundColor(Color.RED);
            tus.setTextColor(Color.WHITE);
        }
        if(new Date().toString().substring(0,3).equals("Wed")) {
            wed.setBackgroundColor(Color.RED);
            wed.setTextColor(Color.WHITE);
        }
        if(new Date().toString().substring(0,3).equals("Thu")) {
            thu.setBackgroundColor(Color.RED);
            thu.setTextColor(Color.WHITE);
        }
        if(new Date().toString().substring(0,3).equals("Fri")) {
            fri.setBackgroundColor(Color.RED);
            fri.setTextColor(Color.WHITE);
        }
        Toast.makeText(getApplicationContext(),"Date is updated", Toast.LENGTH_SHORT).show();
        // 날짜가 업데이트된 사실을 토스트 메시지로 띄워준다
    }

    public void onClick(View view){
    }

}