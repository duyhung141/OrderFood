package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText,passwordEditText ;
    private TextView textViewSignUp,textViewMK;
    private Button loginButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        textViewSignUp = findViewById(R.id.textViewSignUp);
        loginButton = findViewById(R.id.btnSignIn);
        dbHelper = new DatabaseHelper(this);
        textViewMK = findViewById(R.id.textViewMK);

        textViewMK.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Đổi màu chữ khi chạm vào
                        textViewMK.setTextColor(getResources().getColor(R.color.hover_text_color, null));
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Đổi màu chữ về màu mặc định khi không chạm vào
                        textViewMK.setTextColor(getResources().getColor(R.color.default_text_color, null));
                        break;
                }
                return false;
            }
        });
        textViewMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi người dùng nhấp vào textViewSignUp
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
//                Toast.makeText(LoginActivity.this,email,Toast.LENGTH_SHORT).show();
                if(!isValidEmail(email)){
                    Toast.makeText(LoginActivity.this,"Email khong phu hop",Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean loginSuccess = dbHelper.checkLogin(email, password);
                    if (loginSuccess) {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Sai email hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        return Pattern.matches(emailPattern, email);
    }

}
