package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.*;



public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnMinus, btnDivision, btnMultiply, btnPercent, btnEqual;
    Button btnClear, btnDelete, btnDot, btnPower, btnBracketOpen, brnBracketClose;
    TextView textView1, textView2;

    boolean checkEqual = false;

    String process, finalresult = "";

    public void checkEquals(boolean checkEquals) {
        if( checkEquals ) {
            textView1.setText("");
            textView2.setText("");
            checkEqual = false;
            finalresult = "";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnDelete = findViewById(R.id.btnDelete);
        btnPower = findViewById(R.id.btnPower);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);

        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnPercent = findViewById(R.id.btnPercent);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        //clear button
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("");
                textView2.setText("");
                checkEqual = false;
                finalresult = "";
            }
        });

        //delete button
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textView2.getText().toString();

                if( process.length() > 0 ) {
                    process = process.substring(0,process.length()-1);
                    textView2.setText(process);
                }
                else {
                    textView1.setText("");
                }
            }
        });
        //equal button
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEqual = true;
                process = textView2.getText().toString();

                for (int i = 0; i < process.length(); i++) {
                    if (process.charAt(i) == '%') {
                        double d = process.charAt(i-3)/100;
                        process = process.replaceAll("%","/100");
                    }
                }
                process = process.replaceAll("×","*");
                process = process.replaceAll("÷","/");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                finalresult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalresult = rhino.evaluateString(scriptable, process,"JavaScript",1,null).toString();
                }
                catch(Exception e) {
                    finalresult = "Err";
                }
                textView1.setText(finalresult);
            }
        });

        //bracket button


        //number buttons
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + "9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEquals(checkEqual);
                process = textView2.getText().toString();
                textView2.setText(process + ".");
            }
        });

        //mathematical operations
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEqual = false;
                if (finalresult == "") {
                    process = textView2.getText().toString();
                    textView2.setText(process + "+");
                } else {
                    textView2.setText(finalresult);
                    process = textView2.getText().toString();
                    textView2.setText(process + "+");
                    finalresult = "";
                }
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEqual = false;
                if ( finalresult == "") {
                    process = textView2.getText().toString();
                    textView2.setText(process + "-");
                }
                else {
                    textView2.setText(finalresult);
                    process = textView2.getText().toString();
                    textView2.setText(process + "-");
                    finalresult = "";
                }
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEqual = false;
                if ( finalresult == "") {
                    process = textView2.getText().toString();
                    textView2.setText(process + "×");
                }
                else {
                    textView2.setText(finalresult);
                    process = textView2.getText().toString();
                    textView2.setText(process + "×");
                    finalresult = "";
                }
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEqual = false;
                if ( finalresult == "") {
                    process = textView2.getText().toString();
                    textView2.setText(process + "÷");
                }
                else {
                    textView2.setText(finalresult);
                    process = textView2.getText().toString();
                    textView2.setText(process + "÷");
                    finalresult = "";
                }
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEqual = false;
                process = textView2.getText().toString();
                textView2.setText(process + "%");
            }
        });
        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEqual = false;
                if ( finalresult == "") {
                    process = textView2.getText().toString();
                    textView2.setText(process + "^");
                }
                else {
                    textView2.setText(finalresult);
                    process = textView2.getText().toString();
                    textView2.setText(process + "^");
                    finalresult = "";
                }
            }
        });
    }
}