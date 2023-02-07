package com.example.instagramuilogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, pwd;
    Button loginButton;

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });

        username = (EditText) findViewById(R.id.usernameTxt);
        pwd = (EditText) findViewById(R.id.pwd);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String stUserName = username.getText().toString();
                String stPwd = pwd.getText().toString();

                if (stUserName.equalsIgnoreCase("nonameteam") && stPwd.equals("123456")) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("USERNAME",stUserName);
                    intent.putExtra("PASSWORD", stPwd);
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }else if (stUserName.equals("") || stPwd.equals("")) {
                    Toast.makeText(getBaseContext(), "Enter Username and Password", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getBaseContext(), "Wrong Username and Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

}