package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText mailUser;
    private EditText passwordUser;
    private Button btnCreateUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        mailUser = (EditText) findViewById(R.id.mailUser);
        passwordUser = (EditText) findViewById(R.id.passwordUser);
        btnCreateUser = (Button) findViewById(R.id.bntCreateUser);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(mailUser.getText().toString(), passwordUser.getText().toString());
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    //Método para voltar para tela de login(home)
    public void backScreen(View view) {
        Intent nextActivity = new Intent(SignUpActivity.this, HomeActivity.class);
        startActivity(nextActivity);
    }

    private void createUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();

                            Intent nextActivity = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(nextActivity);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Usuário já existente!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
