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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button loginButton;
    TextInputEditText loginEmail;
    TextInputEditText loginPassword;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginEmail = (TextInputEditText) findViewById(R.id.loginEmail);
        loginPassword = (TextInputEditText) findViewById(R.id.loginPassword);
        firebaseAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String email = Login_Activity.this.loginEmail.getText().toString();
                String password = Login_Activity.this.loginPassword.getText().toString();
                String str = "Required";
                if (TextUtils.isEmpty(email)) {
                    Login_Activity.this.loginEmail.setError(str);
                } else if (TextUtils.isEmpty(password)) {
                    Login_Activity.this.loginPassword.setError(str);
                } else if (password.length() < 6) {
                    Toast.makeText(Login_Activity.this, "Password is not less 6 character ...!", Toast.LENGTH_SHORT).show();
                } else {
                    Login_Activity.this.loginUser(email, password);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void loginUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener((Activity) this,  new OnSuccessListener<AuthResult>() {
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Login_Activity.this, "Login Succesfully", Toast.LENGTH_SHORT).show();
                Login_Activity.this.startActivity(new Intent(Login_Activity.this, Home_Activity.class));
                Login_Activity.this.finish();
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
