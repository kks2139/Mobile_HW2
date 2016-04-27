package com.example.hw2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

// mini calculator 시작 전 description 화면

public class MiniCal0 extends Activity implements OnClickListener{

    Button mini_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_cal0);// mini calculator 의 description 화면과 연결

        mini_bt = (Button)findViewById(R.id.mini_bt);// xml의 버튼과 java를 연결해준다
        mini_bt.setOnClickListener(this);// 눌렀을경우 이벤트를 발생시킬 수 있게해준다
    }

    public void onClick(View view)
    {
        if(mini_bt.getId() == view.getId()) {// 버튼이 눌렸을 경우
            Intent runMiniCal = new Intent(this, MiniCal1.class);
            startActivityForResult(runMiniCal, 123);// 호출된 activity가 결과값을 되돌려줬을때 이를 구분해주기 위해서
                                                    // 키값 123 과함께 새로운 activity를 호출해준다
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {// 호출된 activity에서 결과 데이터를 setResult로 실어서 되돌려주면 이 메소드가 콜된다
        super.onActivityResult(requestCode, resultCode, data);
        try
        {
            if((requestCode == 123) && (resultCode == Activity.RESULT_OK));// 작업이 취소되지않고 키값이 123으로 왔다면..
            {
                Bundle myResults = data.getExtras();// 되돌려준 데이터를 받아준다
                String result = myResults.getString("result_cal");// 키값으로 구별하여 내가 얻어야할 데이터를 얻는다
                Toast.makeText(this, "Result: "+result,Toast.LENGTH_SHORT).show();// 얻은 결과 데이터를 토스트 메시지로 띄워준다
            }
        }
        catch (Exception e)
        {
            //Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }// onActivityResult
}
