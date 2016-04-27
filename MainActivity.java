package com.example.hw2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

/* 첫화면(로그인 화면), 처음 비밀번호는 0000 이다.
* 이후 password change 창에서 비밀번호를 변경했을 경우
* preference를 이용해 변경된 비밀번호를 불러온다*/

public class MainActivity extends Activity implements OnClickListener{

    String p1,p2,p3,p4;// 비빌번호 의 각 자리를 저장
    EditText et1,et2,et3,et4;// 각 비밀번호 EditText 변수
    SharedPreferences getpw;// preference 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et_pw1);// xml의 EditText 를 자바와 연결해준다
        et2 = (EditText)findViewById(R.id.et_pw2);
        et3 = (EditText)findViewById(R.id.et_pw3);
        et4 = (EditText)findViewById(R.id.et_pw4);

        getPW();// 화면 켜지면 제일먼저 비밀번호를 받아온다
        password();// 입력된 비밀번호를 확인해준다. 또, 숫자입력시 커서가 점프한다
    }

    public void getPW(){// preference 에 저장되있는 비밀 번호를 불러온다
        getpw = getSharedPreferences("Changed PW",MODE_PRIVATE);// preference 파일을 불러온다

        p1 = getpw.getString("num1","0");// preference로 부터 키값에 해당하는 데이터를 바로 가져온다
        p2 = getpw.getString("num2","0");
        p3 = getpw.getString("num3","0");
        p4 = getpw.getString("num4","0");
        //Toast.makeText(this,p1+p2+p3+p4+" pw test!!!",Toast.LENGTH_SHORT).show();
    }

    public void password(){//각 EditText 에 입력된 숫자들을 긁어와서 preference로부터 얻어온 비밀 번호와 비교해주고 일치하면 다음 activity로 넘어간다
                            //또한 숫자를 입력할 때마다 커서가 다음 칸으로 점프한다
        et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");// 처음에 빈칸으로 설정

        et1.requestFocus();// 처음엔 첫번째칸에 커서가 깜빡이도록 설정한다

        et1.addTextChangedListener(new TextWatcher() {// 글자가 써졌는지 확인해주는 이벤트 핸들러
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {// 글자가 써졌을 경우

                if(et1.length() == 1) {// 하나의 숫자가 입력되면..
                    et1.setInputType(InputType.TYPE_CLASS_NUMBER |InputType.TYPE_NUMBER_VARIATION_PASSWORD);//입력된 숫자를 보이지않게 가려준다
                    et2.requestFocus();// 다음 칸으로 커서가 점프해서 깜빡이도록 해준다
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        et2.addTextChangedListener(new TextWatcher() {// 위와 같은 기능
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et2.length() == 1) {
                    et2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                    et3.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        et3.addTextChangedListener(new TextWatcher() {// 위와 같은 기능
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et3.length() == 1) {
                    et3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                    et4.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        et4.addTextChangedListener(new TextWatcher() {// 4번째칸까지 숫자 입력이 끝났을 경우 각 칸에 입력된 숫자들을 긁어와서 비밀번호와 맞는지
                                                       // 비교하여 일치하면 다음 activity를 불러오고 이 activity는 종료시킨다
                                                       // 만약 일치하지 않을 경우 토스트 메시지가 뜨면서 커서가 다시 첫번째 칸으로 간다
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et4.length() == 1) {

                    // 비밀번가 일치한다면..
                    if (et1.getText().toString().equals(p1) && et2.getText().toString().equals(p2) &&
                            et3.getText().toString().equals(p3) && et4.getText().toString().equals(p4)) {
                        Intent listscreen = new Intent(MainActivity.this, ListScreen.class);// Intent를 통해 불러올 activity의 정보를 변수에 담아준다
                        startActivity(listscreen);// 새로운 activity를 띄워준다
                        MainActivity.this.finish();// 이 activity는 종료
                    }
                    else {// 일치하지 않는다면 ..
                        Toast.makeText(MainActivity.this, "Wrong password!", Toast.LENGTH_LONG).show();
                        password();// 다시 입력을 받음
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    public void onClick(View v){
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)// back 버튼으로 종료할시, 바로 끄지않고 종료확인 메시지를 한번 더 띄워준다다
    {
       if( keyCode == KeyEvent.KEYCODE_BACK )
        {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Quit?").setMessage("Are you sure?").setPositiveButton("Yes", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick( DialogInterface dialog, int which )
                {
                    finish();
                }
            }).setNegativeButton( "No", null ).show();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}

