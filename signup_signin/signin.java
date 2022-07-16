package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {

    EditText Username,Password;
    Button Signinbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        Username=findViewById(R.id.Username);
        Password=findViewById(R.id.Password);
        Signinbtn= findViewById(R.id.Signinbtn);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String uname=bundle.getString("username");
        String pwd=bundle.getString("password");

        Signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=Username.getText().toString();
                String pass=Password.getText().toString();
                if(user.equals(uname)&&pass.equals(pwd))
                {
                    Toast.makeText(signin.this,"Success",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(signin.this,"Failure",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
