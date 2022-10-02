package com.example.project05_classfundmanager.myActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project05_classfundmanager.R;
import com.example.project05_classfundmanager.mySharedPre.MySharedPre;

public class MainActivity extends AppCompatActivity {
    private EditText etPhone, etPass;
    private TextView tvSignIn, tvSignUp;
    private MySharedPre mySharedPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mappingAndInitializeVariable();
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = etPhone.getText().toString().trim();
                String pass = etPass.getText().toString().trim();
                if(phone.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else{
                    if(mySharedPre.getPass(phone).equals(pass)){
                        startActivity(new Intent(MainActivity.this, MainMenuActivity.class));
                    }else{
                        Toast.makeText(MainActivity.this, "Số điện thoại và mật khẩu không trùng khớp\nVui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void mappingAndInitializeVariable(){
        // mapping
        etPass = findViewById(R.id.etSignInPass);
        etPhone = findViewById(R.id.etSignInPhone);
        tvSignIn = findViewById(R.id.tvButtonSignIn);
        tvSignUp = findViewById(R.id.tvSignUp);

        // initialize variable
        mySharedPre = new MySharedPre(getApplicationContext());
    }
}