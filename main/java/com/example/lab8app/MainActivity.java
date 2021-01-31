package com.example.lab8app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private Button login, reset;
    private String uname = "abc";
    private String pass = "123abc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.eTUname);
        password = findViewById(R.id.eTPass);

        login = findViewById(R.id.login);
        reset = findViewById(R.id.reset);

       login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();

                if(inputUsername.equals(uname) && inputPassword.equals(pass)){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, secondActivity.class);
                    MainActivity.this.startActivity(intent);
                } else{
                    Toast.makeText(MainActivity.this, "Login Unsuccessful!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
                username.requestFocus();
                Toast.makeText(MainActivity.this, "Field reset Done..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}