package com.example.hw2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

/* 로그인 후 팁 계산기, 계산기, 시간표, 비밀번호 변경 이 4가지 항목들을 리스트뷰로 보여준다 */

public class ListScreen extends ListActivity implements OnClickListener{
// ListView를 쓸것이기때문에 ListActivity를 상속받음

    // 리스트에 띄워줄 String을 만들어준다
    String[] item = new String[]{"Time Table","Tip Calculator","Mini Calculator","PW change"};
    ListView myListView;// ListView 변수

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //setContentView(R.layout.activity_list_screen);

        MyAdapter adapter = new MyAdapter(this, item);// 내가 임의로 만든 어댑터 클래스를 불러온다
                                                       // 생성자의 매개변수로는 위에서 만들어놓은 리스트 목록으로 설정해준다
        setListAdapter(adapter);// 어댑터 클래스에서 만든 리스트를 화면에 뿌려준다

        myListView = getListView();// 만들어놓은 리스트뷰를 변수에 담는다

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {// 이벤트 리스너 설정 --> 어떤 리스트가 선택되었는지 알아내고 그 이벤트를 처리해준다
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {// 선택된것이 어떤것인지 알게 해준다
                if(position == 0)// 리스트의 첫번째가 선택되었을 경우
                {
                    Intent time = new Intent(ListScreen.this,TimeTable0.class);
                    startActivity(time);// 새 activity를 띄워준다
                }
                if(position == 1)// 리스트의 두번째가 선택되었을 경우
                {
                    Intent tip = new Intent(ListScreen.this,TipCal0.class);
                    startActivity(tip);// 새 activity를 띄워준다
                }
                if(position == 2)// 리스트의 세번째가 선택되었을 경우
                {
                    Intent mini = new Intent(ListScreen.this,MiniCal0.class);
                    startActivity(mini);// 새 activity를 띄워준다
                }
                if(position == 3)// 리스트의 네번째가 선택되었을 경우
                {
                    Intent pwch = new Intent(ListScreen.this,PwChange.class);
                    startActivity(pwch);// 새 activity를 띄워준다
                }
            }
        });
    }

    public void onClick(View v)
    {
        //Toast.makeText(this,"pw Change~~",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)// 로그인 화면과 마찬가지로 종료 전, 종료확인 메시지창을 띄워준다
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
            }).setNegativeButton("No", null).show();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}

