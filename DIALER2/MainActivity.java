package com.example.program8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    Button btnsave,btncall,btnclr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=findViewById(R.id.phone);
        btnsave=findViewById(R.id.btnsave);
        btnclr=findViewById(R.id.btnClr);
        btncall=findViewById(R.id.btncall);
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone.setText("");
            }
        });
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=phone.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+data));
                startActivity(intent);
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=phone.getText().toString();
                Intent intent=new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,data);
                startActivity(intent);
            }
        });
    }
    public void inputNumber(View v){
        Button btn=(Button) v;
        String digit=btn.getText().toString();
        String phoneNum=phone.getText().toString();
        phone.setText(phoneNum +digit);
    }
}
