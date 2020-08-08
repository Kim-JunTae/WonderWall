package com.ict.wonderwall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    String password = "1234";

    Button exit, pw1, pw2, pw3, pw4,
           num1,num2,num3,num4,num5,
           num6,num7,num8,num9,num0,
           reset, delete;

    TextView login_check;

    StringBuffer pw = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_check = (TextView) findViewById(R.id.login_check);
        exit = (Button)findViewById(R.id.exit);
        pw1 = (Button)findViewById(R.id.pw1); pw2 = (Button)findViewById(R.id.pw2); pw3 = (Button)findViewById(R.id.pw3); pw4 = (Button)findViewById(R.id.pw4);
        num1 = (Button)findViewById(R.id.num1); num2 = (Button)findViewById(R.id.num2);
        num3 = (Button)findViewById(R.id.num3); num4 = (Button)findViewById(R.id.num4);
        num5 = (Button)findViewById(R.id.num5); num6 = (Button)findViewById(R.id.num6);
        num7 = (Button)findViewById(R.id.num7); num8 = (Button)findViewById(R.id.num8);
        num9 = (Button)findViewById(R.id.num9); num0 = (Button)findViewById(R.id.num0);
        reset = (Button)findViewById(R.id.reset); delete = (Button)findViewById(R.id.delete);
        exit.setOnClickListener(this);
        pw1.setOnClickListener(this); pw2.setOnClickListener(this);
        pw3.setOnClickListener(this); pw4.setOnClickListener(this);
        num1.setOnClickListener(this); num2.setOnClickListener(this);
        num3.setOnClickListener(this); num4.setOnClickListener(this);
        num5.setOnClickListener(this); num6.setOnClickListener(this);
        num7.setOnClickListener(this); num8.setOnClickListener(this);
        num9.setOnClickListener(this); num0.setOnClickListener(this);
        reset.setOnClickListener(this); delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.num0 :
                pw.append(num0.getText().toString());
                break;
            case R.id.num1 :
                pw.append(num1.getText().toString());
                break;
            case R.id.num2 :
                pw.append(num2.getText().toString());
                break;
            case R.id.num3 :
                pw.append(num3.getText().toString());
                break;
            case R.id.num4 :
                pw.append(num4.getText().toString());
                break;
            case R.id.num5 :
                pw.append(num5.getText().toString());
                break;
            case R.id.num6 :
                pw.append(num6.getText().toString());
                break;
            case R.id.num7 :
                pw.append(num7.getText().toString());
                break;
            case R.id.num8 :
                pw.append(num8.getText().toString());
                break;
            case R.id.num9 :
                pw.append(num9.getText().toString());
                break;
            case R.id.reset :
                pw = new StringBuffer();
                break;
            case R.id.delete :
                pw.deleteCharAt(pw.length()-1);
                break;
            case R.id.exit :
                finish();
                break;
        }
        pwLengthCheck();
        //입력된 패스워드 콘솔창에서 체크
        System.out.println(pw);
    }//end onClick()

    public void pwLengthCheck(){
        if(pw.length() <= 4) {
            switch (pw.length()) {
                case 0:
                    pw1.setSelected(false);
                    pw2.setSelected(false);
                    pw3.setSelected(false);
                    pw4.setSelected(false);
                    break;
                case 1:
                    pw1.setSelected(true);
                    pw2.setSelected(false);
                    break;
                case 2:
                    pw2.setSelected(true);
                    pw3.setSelected(false);
                    break;
                case 3:
                    pw3.setSelected(true);
                    pw4.setSelected(false);
                    break;
                case 4:
                    pw4.setSelected(true);
                    login();
                    break;
            }
        }else{
            pw.substring(0,4);
        }
    }//pwLengthCheck()

    public void login(){
        if(password.equals(pw.toString())){//패스워드 일치
            Intent intent = new Intent(this, MainActivity.class);
            //회원가입 구현 시 회원의 이름을 넣는다.putExtra()
            startActivity(intent);
            finish();
        }else{//패스워드 불일치
            login_check.setText("패스워드가 일치하지 않습니다.");
        }
    }//end login()
}