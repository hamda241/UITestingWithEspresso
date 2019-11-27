package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText userName;
    EditText password;
    TextView errorMessageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        userName=(EditText)findViewById(R.id.edtUsername);
        password=(EditText)findViewById(R.id.edtPassword);
        errorMessageView=findViewById(R.id.errorMessage);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1=password.getText().toString();
                if(password1.length() < 4)
                {
                      errorMessageView.setText("Try a longer Password");
                      errorMessageView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
