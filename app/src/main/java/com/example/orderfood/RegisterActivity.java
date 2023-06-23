package com.example.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextEmail,editTextPassword,editTextconfirmPassword;
    private TextView textViewSignUp;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextconfirmPassword = findViewById(R.id.editTextconfirmPassword);
        textViewSignUp = findViewById(R.id.textViewSignUp);

        btnSignUp = findViewById(R.id.buttonRegister);
        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String passwordConfirm = editTextconfirmPassword.getText().toString();
                if(!isValidEmail(email)){
                    Toast.makeText(RegisterActivity.this,"Email không phù hợp",Toast.LENGTH_SHORT).show();
                }
                else if(!isCheck(email,password,passwordConfirm)){
                    Toast.makeText(RegisterActivity.this,"Dữ liệu phải nhập đầy đủ!",Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseHelper databaseHelper = new DatabaseHelper(RegisterActivity.this);
                    if (databaseHelper.insertUser(email, password)) {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
//                         Tiến hành chuyển đến màn hình đăng nhập hoặc màn hình chính
                         Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                         startActivity(intent);
                         finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thất bại!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        return Pattern.matches(emailPattern, email);
    }
    public boolean isCheck(String email,String password,String confirmPassword){
        if(email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            return false;
        }
        else if(!password.equals(confirmPassword)){
            return false;
        }
        return true;
    }

}

