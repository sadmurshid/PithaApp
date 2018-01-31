package com.pitha.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
  //  private TextView textViewSignup;
    private EditText editName;
    private EditText editPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        buttonRegister = findViewById(R.id.buttonRegister);

        editTextEmail =  findViewById(R.id.editTextEmail);
        editName =  findViewById(R.id.editName);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        editTextPassword = findViewById(R.id.editTextPassword);

        //textViewSignup = findViewById(R.id.textViewSignup);

        buttonRegister.setOnClickListener(this);
        //textViewSignup.setOnClickListener(this);




    }


    private void registerUser(){
        String name = editName.getText().toString().trim();
        String phone_number = editPhoneNumber.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;
        }

        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;

        }

        if (TextUtils.isEmpty(name)){
            //name is empty
            Toast.makeText(this,"Please enter name",Toast.LENGTH_SHORT).show();

        }

        if (TextUtils.isEmpty(phone_number)){
            //phone_number is empty
            Toast.makeText(this,"Please enter phone number",Toast.LENGTH_SHORT).show();

        }

        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                           //user is successfully registered and logged in
                            // profile activity here

                            Toast.makeText(Registration.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }
                        else{
                            Toast.makeText(Registration.this, "Could not register try again", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();

                    }
                });

    }

    @Override
    public void onClick(View view) {

        if(view==buttonRegister){
          registerUser();
        }

    }
}
