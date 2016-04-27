package com.example.hw2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TipCal1 extends Activity implements OnClickListener {

    // 변수 선언
    Button cal;
    RadioButton b1,b2,b3;
    EditText t1,t2;
    TextView v1,v2;
    String str1,str2;
    float num1,num2;
    float tip,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_cal1);

        // xml view들과 java를 연결 시켜준다
        cal = (Button)findViewById(R.id.cal);
        b1 = (RadioButton)findViewById(R.id.bt1);
        b2 = (RadioButton)findViewById(R.id.bt2);
        b3 = (RadioButton)findViewById(R.id.bt3);
        t1 = (EditText)findViewById(R.id.text);
        t2 = (EditText)findViewById(R.id.text2);
        v1 = (TextView)findViewById(R.id.tv1);
        v2 = (TextView)findViewById(R.id.tv2);

    }
    @Override// 화면 돌려도 전에 입력된 데이터들이 사라지지않게 해준다
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    public void onResume(){
        super.onResume();
    }


    public void result(View view)// 버튼을 눌렀을때 이 메소드가 불린다
    {
        if(b1.isChecked())// 15% 라디오 버튼이 체크되있을 경우
        {
            str1 = t1.getText().toString();
            num1 = Float.parseFloat(str1);// 쓰여진 숫자를 받아서 연산 해준다
            tip = num1*15/100;
            total = num1 + tip;

            // 텍스트뷰로 계산의 결과를 setText로 보여준다
            v2.setText("tip : " + Float.toString(tip));
            v1.setText("total amout : " + Float.toString(total));
        }
        if(b2.isChecked())// 20% 라디오 버튼이 체크되있는 경우
        {
            str1 = t1.getText().toString();
            num1 = Float.parseFloat(str1);// 연산과정
            tip = num1/5;
            total = num1 + tip;

            v2.setText("tip : "+Float.toString(tip));// 결과 보여줌
            v1.setText("total amout : "+Float.toString(total));
        }
        if(b3.isChecked())// other 버튼에 체크가 되있을 경우
        {
            String oth = t2.getText().toString();
            float othnum = Float.parseFloat(oth);// 임의로 입력된 숫자를 긁어와서 숫자로 변환해 저장해준다

            str1 = t1.getText().toString();// 계산 과정
            num1 = Float.parseFloat(str1);
            tip = num1*othnum/100;
            total = num1 + tip;

            v2.setText("tip : "+Float.toString(tip));// 결과
            v1.setText("total amout : "+Float.toString(total));
        }

    }

    public void onClick(View view) {// 화면 돌려도 내용을 유지해주기 위해서 써줌
    }
    protected void onSavedInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }
}
