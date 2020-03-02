package com.beauty.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration2Activity extends AppCompatActivity {
    Bundle bundle=null;
    Button signUp;
    EditText edtFirstName,edtlastName,edtEmail,edtPassword,edtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        bundle=getIntent().getExtras();
        if (bundle!=null)
        {
            Toast.makeText(this, ""+bundle.getString("callFrom"), Toast.LENGTH_LONG).show();
        }

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

        if (edtFirstName.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter first name", Toast.LENGTH_SHORT).show();
        }
        else if (edtlastName.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter last name", Toast.LENGTH_SHORT).show();
        }
        else if (edtEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter email id", Toast.LENGTH_SHORT).show();
        }
        else if (edtPassword.getText().toString().isEmpty()){
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
            Intent intent=new Intent(Registration2Activity.this,DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

    }

}

