package com.example.phone_dialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtPhoneNo;
    TextView lblinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhoneNo = (EditText) findViewById(R.id.edtPhoneNumber);
        lblinfo = (TextView) findViewById(R.id.lblinfo);
    }

    public void buttonClickEvent(View v) {
        String phoneNo = edtPhoneNo.getText().toString();
        try {

            switch (v.getId()) {
                case R.id.btnAterisk:
                    lblinfo.setText("");
                    phoneNo += "*";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnHash:
                    lblinfo.setText("");
                    phoneNo += "#";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnZero:
                    lblinfo.setText("");
                    phoneNo += "0";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnOne:
                    lblinfo.setText("");
                    phoneNo += "1";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnTwo:
                    lblinfo.setText("");
                    phoneNo += "2";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnThree:
                    lblinfo.setText("");
                    phoneNo += "3";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnFour:
                    lblinfo.setText("");
                    phoneNo += "4";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnFive:
                    lblinfo.setText("");
                    phoneNo += "5";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnSix:
                    lblinfo.setText("");
                    phoneNo += "6";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnSeven:
                    lblinfo.setText("");
                    phoneNo += "7";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnEight:
                    lblinfo.setText("");
                    phoneNo += "8";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnNine:
                    lblinfo.setText("");
                    phoneNo += "9";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btndel:
                    lblinfo.setText("");
                    if (phoneNo != null && phoneNo.length() > 0) {
                        phoneNo = phoneNo.substring(0, phoneNo.length() - 1);
                    }

                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnSave:
                    if(phoneNo.isEmpty() == false) {
                        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNo);
                        startActivity(intent);
                    }
                    break;
                case R.id.btnCall:
                    if (phoneNo.trim().equals("")) {
                        lblinfo.setText("Please enter a number to call on!");
                    } else {
//                        Boolean isHash = false;
//                        if (phoneNo.subSequence(phoneNo.length() - 1, phoneNo.length()).equals("#")) {
//                            phoneNo = phoneNo.substring(0, phoneNo.length() - 1);
//                            String callInfo = "tel:" + phoneNo + Uri.encode("#");
//                            Intent callIntent = new Intent(Intent.ACTION_CALL);
//                            callIntent.setData(Uri.parse(callInfo));
//                            startActivity(callIntent);
//                        } else {
//                            String callInfo = "tel:" + phoneNo;
//                            Intent callIntent = new Intent(Intent.ACTION_CALL);
//                            callIntent.setData(Uri.parse(callInfo));
//                            startActivity(callIntent);
//                        }
                        Uri u = Uri.parse("tel:" + phoneNo);

                        // Create the intent and set the data for the
                        // intent as the phone number.
                        Intent i = new Intent(Intent.ACTION_DIAL, u);

                        try
                        {
                            // Launch the Phone app's dialer with a phone
                            // number to dial a call.
                            startActivity(i);
                        }
                        catch (SecurityException s)
                        {
                            // show() method display the toast with
                            // exception message.
                            Toast.makeText(this, "An error occurred", Toast.LENGTH_LONG)
                                    .show();
                        }

                    }
                    break;
            }

        } catch (Exception ex) {

        }
    }

}
