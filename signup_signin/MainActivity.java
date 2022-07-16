package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button Signupbtn;
    String regex="^(?=.*[0-9])"
                  +"(?=.*[a-z])(?=.*[A-Z])"
                   +"(?=.*[@#$%&])"
                   +"(?=\\S+$).{8,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        Signupbtn=findViewById(R.id.Signupbtn);
        Signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Uname=username.getText().toString();
                String pwd=password.getText().toString();

                Pattern pattern=Pattern.compile(regex);
                Matcher matcher=pattern.matcher(pwd);

                if(matcher.matches()){
                    Intent intent=new Intent(MainActivity.this,signin.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("username",Uname);
                    bundle.putString("password",pwd);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Invalid Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
