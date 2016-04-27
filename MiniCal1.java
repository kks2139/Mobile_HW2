package com.example.hw2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MiniCal1 extends Activity implements OnClickListener{

    int i1,i2,i3,i4;
    Float num1=null,num2=null;
    String str = "",op="",temp=null;
    Button one,two,three,four,five,six,seven,eight,nine,zero;// 숫자버튼 변수 선언
    Button plus,minus,div,times,is,c;// 연산자 버튼 변수 선언
    EditText show;// 숫자가 쓰여지는 곳

    Intent myLocalIntent = new Intent(this, MiniCal0.class);// Intent 변수 선언
    Bundle myBundle = new Bundle();

    //Bundle myBundle = myLocalIntent.getExtras();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_cal1);

        //자바와 xml view들 연결
        show = (EditText)findViewById(R.id.show);
        show.setText("");// 첨엔 빈칸으로 설정

        one = (Button)findViewById(R.id.one);two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);zero = (Button)findViewById(R.id.zero);
        plus = (Button)findViewById(R.id.plus);div = (Button)findViewById(R.id.div);
        minus = (Button)findViewById(R.id.minus);times = (Button)findViewById(R.id.times);
        c = (Button)findViewById(R.id.clear);is = (Button)findViewById(R.id.is);

        one.setOnClickListener(this);two.setOnClickListener(this);three.setOnClickListener(this);
        four.setOnClickListener(this);five.setOnClickListener(this);six.setOnClickListener(this);
        seven.setOnClickListener(this);eight.setOnClickListener(this);nine.setOnClickListener(this);
        zero.setOnClickListener(this);plus.setOnClickListener(this);minus.setOnClickListener(this);
        div.setOnClickListener(this);times.setOnClickListener(this);c.setOnClickListener(this);
        is.setOnClickListener(this);

    }

    @Override// 화면 회전시 저장된 데이터들이 없어지지않게 해준다
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    @Override// 데이터값 저장
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putFloat("n1",num1);
        outState.putFloat("n2",num2);
        outState.putCharSequence("oper",op);
    }
    public void onClick(View v) {// 여기서 모든 버튼들의 이벤트듣을 처리해준다

        // 기본적으로 '숫자 연산자 숫자' 의 계산만 가능하도록 만들었다
        // 숫자버튼을 연속해서 누르면 한칸씩 밀리면서 숫자가 글상자에 쌓인다
        // 그러다가 연산자 버튼을 누르면 글상자에 입력된 숫자들이 모두 없어지고 num1에 저장된다
        // 이어서 다시 계산할 수를 입력하고 = 버튼을 누를시 '= 결과' 이런식으로 결과를 보여준다
        // 만약 아무입력도 안한상태에서 연산자를 누르거나 올지않은 순서로 입력했을 경우
        // Wrong input 이라는 토스트 메시지가 나온다
        // C 버튼을 누르면 모든값이 초기화된다
        // 0으로 나눴을 경우 결과로 infinity가 나오도록 했다
        if(v.getId()==one.getId())// 1눌렀을때
        {
            show.setText("");
            str += "1";
            show.setText(str);
        }
        if(v.getId()==two.getId())// 2눌렀을때
        {
            show.setText("");
            str += "2";
            show.setText(str);
        }
        if(v.getId()==three.getId())// 3눌렀을때
        {
            show.setText("");
            str += "3";
            show.setText(str);
        }
        if(v.getId()==four.getId())// 4눌렀을때
        {
            show.setText("");
            str += "4";
            show.setText(str);
        }
        if(v.getId()==five.getId())// 5눌렀을때
        {
            show.setText("");
            str += "5";
            show.setText(str);
        }
        if(v.getId()==six.getId())// 6눌렀을때
        {
            show.setText("");
            str += "6";
            show.setText(str);
        }
        if(v.getId()==seven.getId())// 7눌렀을때
        {
            show.setText("");
            str += "7";
            show.setText(str);
        }
        if(v.getId()==eight.getId())// 8눌렀을때
        {
            show.setText("");
            str += "8";
            show.setText(str);
        }
        if(v.getId()==nine.getId())// 9눌렀을때
        {
            show.setText("");
            str += "9";
            show.setText(str);
        }
        if(v.getId()==zero.getId())// 0눌렀을때
        {
            show.setText("");
            str += "0";
            show.setText(str);
        }
        if (v.getId() == plus.getId()) {// + 눌렀을때
            op = "+";// + 를 저장해줌
            if(show.getText().toString().equals("")||show.getText().toString().substring(0,1).equals("="))// 잘못된 입력일 경우 예외처리
                Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_SHORT).show();
            else {// 입력된 숫자를 저장해주고 텍스트창 내용을 다 지운다
                num1 = Float.parseFloat(show.getText().toString());
                str = "";
                show.setText("");
            }
        }
        if (v.getId() == minus.getId()) {// - 눌렀을때
            op = "-";
            if(show.getText().toString().equals("")||show.getText().toString().substring(0,1).equals("="))
                Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_SHORT).show();
            else {
                num1 = Float.parseFloat(show.getText().toString());
                str = "";
                show.setText("");
            }
        }
        if (v.getId() == div.getId()) {// / 눌렀을때
            op = "/";
            if(show.getText().toString().equals("")||show.getText().toString().substring(0,1).equals("="))
                Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_SHORT).show();
            else {
                num1 = Float.parseFloat(show.getText().toString());
                str = "";
                show.setText("");
            }
        }
        if (v.getId() == times.getId()) {// * 눌렀을 때
            op = "*";
            if(show.getText().toString().equals("")||show.getText().toString().substring(0,1).equals("="))
                Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_SHORT).show();
            else {
                num1 = Float.parseFloat(show.getText().toString());
                str = "";
                show.setText("");
            }
        }
        if (v.getId() == c.getId()) {// C 눌렀을때 저장된 모든 값들을 없애준다
            str = "";
            op = "";
            show.setText("");
        }
        if(v.getId()==is.getId())// = 을 눌렀을때
        {
            if (show.getText().toString().equals("")) {// 빈 화면에서 그냥 = 눌렀을 경우 오류 메세지 띄움
                str = "";
                op = "";
                Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_SHORT).show();
            }
            else if(num1 == null)// 잘못된 순서로 = 눌렀을 경우 오류 메시지 띄움
                Toast.makeText(getApplicationContext(),"Wrong input",Toast.LENGTH_SHORT).show();
            else {// 정상적이 경우 입력된 숫자를 num2에 저장하고 앞서 저장된 num1과 계산을 한 후 이전 activity로 결과를 되돌려주고 이activity는 종료한다
                num2 = Float.parseFloat(show.getText().toString());
                if (op.equals("+")) {// 입력된 연산이 + 일경우
                    float ff =num1+num2;
                    String rr =ff+"";// 결과값을

                    myLocalIntent.putExtra("result_cal", rr);// 돌려줄 인텐트 변수에 결과값을 실어준다
                    setResult(Activity.RESULT_OK, myLocalIntent);// 결과값 되돌려 보냄
                    this.finish();// 그리고 이 activity는 종료
                }
                if (op.equals("-")) {// 입력된 연산이 - 일경우
                    float ff =num1-num2;
                    String rr =ff+"";// 결과값을

                    myLocalIntent.putExtra("result_cal", rr);// 돌려줄 인텐트 변수에 결과값을 실어준다
                    setResult(Activity.RESULT_OK, myLocalIntent);// 결과값 되돌려 보냄
                    this.finish();
                }
                if (op.equals("/")) {// 입력된 연산이 / 일경우
                    float ff =num1/num2;
                    String rr =ff+"";// 결과값을

                    myLocalIntent.putExtra("result_cal", rr);// 돌려줄 인텐트 변수에 결과값을 실어준다
                    setResult(Activity.RESULT_OK, myLocalIntent);// 결과값 되돌려 보냄
                    this.finish();// 그리고 이 activity는 종료
                }
                if (op.equals("*")) {// 입력된 연산이 * 일경우
                    //str = "";
                    //op = "";
                    //show.setText("= " + Float.toString(num1 * num2));
                    //num1 = null;

                    float ff =num1*num2;
                    String rr =ff+"";// 결과값을

                    myLocalIntent.putExtra("result_cal", rr);// 돌려줄 인텐트 변수에 결과값을 실어준다
                    setResult(Activity.RESULT_OK, myLocalIntent);// 결과값 되돌려 보냄
                    this.finish();// 그리고 이 엑티비티는 종료
                }
            }
        }
    }
}
