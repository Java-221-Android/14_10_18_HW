package com.sheygam.java_221_14_10_18_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int EMAIL_ACTIVITY = 0x01;
    private Button loginBtn;
    private TextView resultTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = findViewById(R.id.login_btn);
        resultTxt = findViewById(R.id.result_txt);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn){
            Intent intent = new Intent(this,EmailActivity.class);
            startActivityForResult(intent,EMAIL_ACTIVITY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == EMAIL_ACTIVITY && data!=null){
                resultTxt.setText(data.getStringExtra("EMAIL") + "\n" + data.getStringExtra("PASSWORD"));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
