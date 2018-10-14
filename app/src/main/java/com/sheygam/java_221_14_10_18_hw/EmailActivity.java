package com.sheygam.java_221_14_10_18_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PASSWORD_ACTIVITY = 0x01;
    private Button backBtn, nextBtn;
    private EditText inputEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        backBtn = findViewById(R.id.back_btn);
        nextBtn = findViewById(R.id.next_btn);
        inputEmail = findViewById(R.id.input_email);
        backBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_btn:
                finish();
                break;
            case R.id.next_btn:
                Intent intent = new Intent(this, PasswordActivity.class);
                intent.putExtra("EMAIL",inputEmail.getText().toString());
                startActivityForResult(intent,PASSWORD_ACTIVITY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == PASSWORD_ACTIVITY){
                setResult(RESULT_OK,data);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
