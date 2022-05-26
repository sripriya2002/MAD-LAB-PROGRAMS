package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnZero;
    Button btnAdd,btnSub,btnMul,btnDiv;
    Button btnEqual,btnDot,btnClear;
    EditText txtResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne=(Button)findViewById(R.id.btnOne);
        btnOne.setOnClickListener(this);
        btnTwo=(Button)findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(this);
        btnThree=(Button)findViewById(R.id.btnThree);
        btnThree.setOnClickListener(this);
        btnFour=(Button)findViewById(R.id.btnFour);
        btnFour.setOnClickListener(this);
        btnFive=(Button)findViewById(R.id.btnFive);
        btnFive.setOnClickListener(this);
        btnSix=(Button)findViewById(R.id.btnSix);
        btnSix.setOnClickListener(this);
        btnSeven=(Button)findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(this);
        btnEight=(Button)findViewById(R.id.btnEight);
        btnEight.setOnClickListener(this);
        btnNine=(Button)findViewById(R.id.btnNine);
        btnNine.setOnClickListener(this);
        btnZero=(Button)findViewById(R.id.btnZero);
        btnZero.setOnClickListener(this);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        btnDot=(Button)findViewById(R.id.btnDot);
        btnDot.setOnClickListener(this);
        btnClear=(Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnEqual=(Button)findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(this);
        txtResults =(EditText)findViewById(R.id.txtResults);
        txtResults.setText("");
    }


    @Override
    public void onClick(View view) {
        if(view.equals(btnOne))
            txtResults.append("1");
        if(view.equals(btnTwo))
            txtResults.append("2");
        if(view.equals(btnThree))
            txtResults.append("3");
        if(view.equals(btnFour))
            txtResults.append("4");
        if(view.equals(btnFive))
            txtResults.append("5");
        if(view.equals(btnSix))
            txtResults.append("6");
        if(view.equals(btnSeven))
            txtResults.append("7");
        if(view.equals(btnEight))
            txtResults.append("8");
        if(view.equals(btnNine))
            txtResults.append("9");
        if(view.equals(btnZero))
            txtResults.append("0");
        if(view.equals(btnAdd))
            txtResults.append("+");
        if(view.equals(btnSub))
            txtResults.append("-");
        if(view.equals(btnMul))
            txtResults.append("*");
        if(view.equals(btnDiv))
            txtResults.append("/");
        if(view.equals(btnDot))
            txtResults.append(".");
        if(view.equals(btnClear))
            txtResults.setText("");
        if(view.equals(btnEqual)) {
            try {
                String data = txtResults.getText().toString();
                if (data.contains("/")) {
                    divide(data);
                } else if (data.contains("*")) {
                    multiplication(data);
                } else if (data.contains("+")) {
                    add(data);
                } else if (data.contains("-")) {
                    subtract(data);
                }

            } catch (Exception e) {
                displayInvalidMessage("Invalid Input");
            }
        }
        //  String data=txtResults.getText().toString();


    }

    private void displayInvalidMessage(String mes) {
        Toast.makeText(getBaseContext(),mes,Toast.LENGTH_LONG).show();
    }

    private void subtract(String data) {
        String[] operand=data.split(Pattern.quote("-"));
        if(operand.length==2)
        {
            double operand1=Double.parseDouble(operand[0]);
            double operand2=Double.parseDouble(operand[1]);
            double Result=operand1-operand2;
            txtResults.setText(String.valueOf(Result));

        }
        else
        {
            displayInvalidMessage("Invalid Input");
        }
    }

    private void add(String data) {
        String[] operand=data.split(Pattern.quote("+"));
        if(operand.length==2)
        {
            double operand1=Double.parseDouble(operand[0]);
            double operand2=Double.parseDouble(operand[1]);
            double Result=operand1+operand2;
            txtResults.setText(String.valueOf(Result));

        }
        else
        {
            displayInvalidMessage("Invalid Input");
        }
    }

    private void multiplication(String data) {
        String[] operand=data.split(Pattern.quote("*"));
        if(operand.length==2)
        {
            double operand1=Double.parseDouble(operand[0]);
            double operand2=Double.parseDouble(operand[1]);
            double Result=operand1*operand2;
            txtResults.setText(String.valueOf(Result));

        }
        else
        {
            displayInvalidMessage("Invalid Input");
        }
    }

    private void divide(String data) {
        String[] operand=data.split(Pattern.quote("/"));
        if(operand.length==2)
        {
            double operand1=Double.parseDouble(operand[0]);
            double operand2=Double.parseDouble(operand[1]);
            double Result=operand1/operand2;
            txtResults.setText(String.valueOf(Result));

        }
        else
        {
            displayInvalidMessage("Invalid Input");
        }
    }
}



