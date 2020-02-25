package com.beauty.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.assist.AssistStructure;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    Bundle bundle=null;
    Button singUp;
    EditText edtUserName,

            edtMiddleNmae,edtLastName;
    private Notification.MessagingStyle.Message edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle=getIntent().getExtras();
        if (bundle!=null)
        {
            Toast.makeText(this, ""+bundle.getString("callFrom"), Toast.LENGTH_LONG).show();
        }
        SignUp=findViewById(R.id.txtSignUp);
        signUp=findViewById(R.id.signUp);
        edtFirstName=findViewById(R.id.edtFirstName);
        edtlastName=findViewById(R.id.edtLastName);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        edtConfirmPassword=findViewById(R.id.edtConfirmPassword);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkvalidations();
            }
        });
    }

    private void checkvalidations(){


        if (edtUserName.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter first name", Toast.LENGTH_SHORT).show();
        }
        else if (edtLastName.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter last name", Toast.LENGTH_SHORT).show();
        }
        else if (edtEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter email id", Toast.LENGTH_SHORT).show();
        }
        else if (edtpassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        }
        else if (edtPassword.getText().toString().length()<6){
            Toast.makeText(this, "Enter valid password", Toast.LENGTH_SHORT).show();
        }
        else if (edtConfirmPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter confirm password", Toast.LENGTH_SHORT).show();
        }
        else if (!edtConfirmPassword.getText().toString().equals(edtPassword.getText().toString())){
            Toast.makeText(this, "Enter not password match", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent=new Intent(RegistrationActivity.this,DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

    }
}
