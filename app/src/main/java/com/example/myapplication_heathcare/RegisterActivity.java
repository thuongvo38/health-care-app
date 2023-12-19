package com.example.myapplication_heathcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername=findViewById(R.id.editTextRegUsername);
        edPassword=findViewById(R.id.editTextRegPassword);
        edConfirm=findViewById(R.id.editTextRegConfirmPassword);
        edEmail=findViewById(R.id.editTextRegEmail);
        btn=findViewById(R.id.buttonRegister);
        tv=findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,loginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email=edEmail.getText().toString();
                String password =edPassword.getText().toString();
                String confirm=edConfirm.getText().toString();
                if ( username.length()==0 ||email.length()==0 || password.length()==0 ||confirm.length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirm)==0){
                        if(isValid(password)){
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,loginActivity.class));

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 charaters,having letter,digit and special symbol", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm password doesn't match", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
    public static boolean isValid( String passwordhere)
    {
        if (passwordhere.length() < 8) {
            return false;
        }

        // Check if the password contains at least one letter
        if (!passwordhere.matches(".*[a-zA-Z]+.*")) {
            return false;
        }

        // Check if the password contains at least one digit
        if (!passwordhere.matches(".*\\d+.*")) {
            return false;
        }

        // Check if the password contains at least one special symbol
        if (!passwordhere.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*")) {
            return false;
        }

        // If all conditions are met, the password is valid
        return true;
    }

}

