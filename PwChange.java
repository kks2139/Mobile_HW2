package com.example.hw2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// 비밀번호를 바꿔주는 화면

public class PwChange extends Activity implements OnClickListener {


    String s,num1,num2,num3,num4;// password 네자리를 각각 저장할 변수
    Button pw_ok,pw_cancel;// 버튼 변수
    EditText pw_box;// 입력창 변수

    SharedPreferences prefer;// preference 변수
    SharedPreferences.Editor edt;// editor 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_change);// layout 연결

        pw_box = (EditText)findViewById(R.id.pw_box);// layout view들을 자바와 연결
        pw_ok = (Button)findViewById(R.id.pw_ok);
        pw_cancel = (Button)findViewById(R.id.pw_cancel);


        pw_box.setOnClickListener(this);// 리스너 연결
        pw_ok.setOnClickListener(this);
        pw_cancel.setOnClickListener(this);
    }


    public void onClick(View v){

        if(v.getId() == pw_ok.getId())// OK 버튼을 눌렀을 경우..
        {
            if(pw_box.getText().toString().length() == 4)// 비밀번호 4자리를 입력했을 경우..
            {
                s = pw_box.getText().toString();// 입력된 새 비밀번호 네자리를 입력창에서 긁어온다
                num1 = s.substring(0, 1).toString();// 숫자를 한개 한개 잘라서 따로 변수에 담아준다
                num2 = s.substring(1,2).toString();
                num3 = s.substring(2,3).toString();
                num4 = s.substring(3,4).toString();

                prefer = getSharedPreferences("Changed PW", MODE_PRIVATE);// Change PW라는 이름의 preference를 쓰겠다고 알려줌
                edt = prefer.edit();// preference와 editor를 연결해줌
                                     // editor가 중간에서 대신 데이터를 저장해준다
                edt.putString("num1",num1);// editor가 각 자리 숫자들을 실질적으로 저장해줌
                edt.putString("num2",num2);
                edt.putString("num3",num3);
                edt.putString("num4",num4);
                edt.commit();// commit을 통해 최종적으로 저장완료
                Toast.makeText(this,"Password has changed !",Toast.LENGTH_SHORT).show();// 완료 메세지
            }
            else// 숫자4자리를 입력하지 않았을 경우..
                Toast.makeText(this,"PW number should be four",Toast.LENGTH_SHORT).show();// 주의 메세지
        }
        if(v.getId() == pw_cancel.getId()) {// 그냥 Cancel 버튼 눌렀을 경우..
            this.finish();// 그냥 이 activity 종료
        }
    }
}
