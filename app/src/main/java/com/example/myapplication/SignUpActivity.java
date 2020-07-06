package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    //Método para voltar para tela de login(home)
    public void backScreen(View view) {
        Intent nextActivity = new Intent(SignUpActivity.this, HomeActivity.class);
        startActivity(nextActivity);
    }

}
