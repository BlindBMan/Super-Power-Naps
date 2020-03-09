package com.example.super_power_naps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText name, email, password;
    Button submitBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name_reg);
        email = findViewById(R.id.email_reg);
        password = findViewById(R.id.password_reg);
        submitBtn = findViewById(R.id.submit_btn);
        fAuth = FirebaseAuth.getInstance();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_txt = email.getText().toString().trim();
                String pass_txt = password.getText().toString().trim();

                if (TextUtils.isEmpty(email_txt)) {
                    email.setError("Email required");
                    return;
                }

                if (TextUtils.isEmpty(pass_txt)) {
                    password.setError("Password required");
                    return;
                }

                if (pass_txt.length() < 8) {
                    password.setError("Password length must be greater than 8");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email_txt, pass_txt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "User created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
    }
}
