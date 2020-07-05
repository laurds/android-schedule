package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void changeScreenLogin(View view) {

        Intent nextActivity = new Intent(HomeActivity.this, SignUpActivity.class);
        startActivity(nextActivity);
    }

    public void changeScreenEvent(View view) {

        Intent nextActivity = new Intent(HomeActivity.this, EventActivity.class);
        startActivity(nextActivity);
    }
}
