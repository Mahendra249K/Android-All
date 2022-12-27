package com.all;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button registerButton;
    TextInputEditText registerEmail;
    TextInputEditText registerPassword;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        registerEmail = (TextInputEditText) findViewById(R.id.registerEmail);
        registerPassword = (TextInputEditText) findViewById(R.id.registerPassword);
        registerButton = (Button) findViewById(R.id.registerButton);
        firebaseAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String email = Register_Activity.this.registerEmail.getText().toString();
                String password = Register_Activity.this.registerPassword.getText().toString();
                String str = "Required";
                if (TextUtils.isEmpty(email)) {
                    Register_Activity.this.registerEmail.setError(str);
                } else if (TextUtils.isEmpty(password)) {
                    Register_Activity.this.registerPassword.setError(str);
                } else if (password.length() < 6) {
                    Toast.makeText(Register_Activity.this, "Password too short...!", Toast.LENGTH_SHORT).show();
                } else {
                    Register_Activity.this.registerUser(email, password);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void registerUser(String email, String password) {
        this.firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this,  new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Register_Activity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                    Register_Activity.this.startActivity(new Intent(Register_Activity.this, Login_Activity.class));
                    Register_Activity.this.finish();
                    return;
                }
                Toast.makeText(Register_Activity.this, "Registration Failed.....!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
