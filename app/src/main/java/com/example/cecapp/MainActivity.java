package com.example.cecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFirst, etSecond;
    Button btnAdd,  btnSub, btnMul, btnDiv, btnClear;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirst = findViewById(R.id.et_first);
        etSecond = findViewById(R.id.et_second);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
        btnDiv = findViewById(R.id.btn_div);
        btnClear = findViewById(R.id.btn_clear);

        tvResult = findViewById(R.id.tv_result);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new AddTask().execute();
                    /*int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = add(a,b);
                    tvResult.setText(String.valueOf(c));*/
                }
                catch (Exception e) {
                    showErrorToast();
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = a - b;
                    tvResult.setText(String.valueOf(c));
                }
                catch (Exception e) {
                    showErrorToast();
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = a * b;
                    tvResult.setText(String.valueOf(c));
                }
                catch (Exception e) {
                    showErrorToast();
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    if (b==0) {
                        zeroDivisionError();
                    }
                    float c = (float)a / (float)b;
                    tvResult.setText(String.valueOf(c));
                }
                catch (Exception e) {
                    showErrorToast();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("");
            }
        });

    }
    public void showErrorToast() {
        Toast.makeText(this,"Enter 2 valid values", Toast.LENGTH_SHORT).show();
    }
    public void zeroDivisionError() {
        Toast.makeText(this,"Cannot divide by zero", Toast.LENGTH_SHORT).show();
    }
    public int add(int a,int b) {
        return a+b;
    }
    class AddTask extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvResult.setText("Loading");
        }

        @SuppressLint("WrongThread")
        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                Thread.sleep(1000);
                tvResult.setText("Loading.");
                Thread.sleep(1000);
                tvResult.setText("Loading..");
                Thread.sleep(1000);
                tvResult.setText("Loading...");
                Thread.sleep(1000);
            }
            catch (Exception e) {

            }
            String epoch = String.valueOf(System.currentTimeMillis());
            return epoch;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tvResult.setText((String) o);
        }
    }
}
