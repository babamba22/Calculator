package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button plus, minus, multi, division, clear, plusminus, divideby100, dot, equal;

    String tempNumber;
    int operator;int PLUS = 0;int MINUS = 1;int MULTI = 2;int DIVISION = 3;

    int pmcount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        {
            editText = findViewById(R.id.edit);
            tempNumber = "";

            plus = findViewById(R.id.plus);
            minus = findViewById(R.id.minus);
            multi = findViewById(R.id.multi);
            division = findViewById(R.id.division);

            clear = findViewById(R.id.clear);
            plusminus = findViewById(R.id.plusminus);
            divideby100 = findViewById(R.id.divideby100);
            dot = findViewById(R.id.dot);
            equal = findViewById(R.id.equal);
        } //findViewById.Buttons


        {
            plus.setOnClickListener(mClickListener);
            minus.setOnClickListener(mClickListener);
            multi.setOnClickListener(mClickListener);
            division.setOnClickListener(mClickListener);
            equal.setOnClickListener(mClickListener);
            plusminus.setOnClickListener(mClickListener);
            divideby100.setOnClickListener(mClickListener);
            dot.setOnClickListener(mClickListener);
        } //setOnClickListener

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempNumber = "";
                editText.setText("0");
            }
        });

    }


    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.plus:
                    tempNumber = editText.getText().toString();
                    editText.setText("");
                    operator = PLUS;
                    break;
                case R.id.minus:
                    tempNumber = editText.getText().toString();
                    editText.setText("");
                    operator = MINUS;
                    break;
                case R.id.multi:
                    tempNumber = editText.getText().toString();
                    editText.setText("");
                    operator = MULTI;
                    break;
                case R.id.division:
                    tempNumber = editText.getText().toString();
                    editText.setText("");
                    operator = DIVISION;
                    break;
                case R.id.dot:
                    tempNumber = editText.getText().toString();
                    editText.setText("" + Double.parseDouble(tempNumber) + ".");
                    break;
                case R.id.plusminus:
                    tempNumber = editText.getText().toString();
                    if (pmcount % 2 == 0) {
                        editText.setText("" + Double.parseDouble(tempNumber));
                        pmcount++;
                    } else {
                        editText.setText("-" + Double.parseDouble(tempNumber));
                        pmcount++;
                    }
                    break;
                case R.id.divideby100:
                    tempNumber = editText.getText().toString();
                    editText.setText("" + Double.parseDouble(tempNumber)*0.01);
                    break;
                case R.id.equal:
                    if (operator == PLUS) {
                        editText.setText("" + (Double.parseDouble(tempNumber) + Double.parseDouble(editText.getText().toString())));
                    } else if (operator == MINUS) {
                        editText.setText("" + (Double.parseDouble(tempNumber) - Double.parseDouble(editText.getText().toString())));
                    } else if (operator == MULTI) {
                        editText.setText("" + (Double.parseDouble(tempNumber) * Double.parseDouble(editText.getText().toString())));
                    } else if (operator == DIVISION) {
                        editText.setText("" + (Double.parseDouble(tempNumber) / Double.parseDouble(editText.getText().toString())));
                    }
                    tempNumber = editText.getText().toString();
                    break;
            }
        }
    };


    public void num(View view) {
        switch (view.getId()) {
            case R.id.one:
                editText.setText(editText.getText().toString() + "1");
                break;
            case R.id.two:
                editText.setText(editText.getText().toString() + "2");
                break;
            case R.id.three:
                editText.setText(editText.getText().toString() + "3");
                break;
            case R.id.four:
                editText.setText(editText.getText().toString() + "4");
                break;
            case R.id.five:
                editText.setText(editText.getText().toString() + "5");
                break;
            case R.id.six:
                editText.setText(editText.getText().toString() + "6");
                break;
            case R.id.seven:
                editText.setText(editText.getText().toString() + "7");
                break;
            case R.id.eight:
                editText.setText(editText.getText().toString() + "8");
                break;
            case R.id.nine:
                editText.setText(editText.getText().toString() + "9");
                break;
            case R.id.zero:
                editText.setText(editText.getText().toString() + "0");
                break;
        }
    }
}
