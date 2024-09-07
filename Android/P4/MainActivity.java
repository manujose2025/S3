package com.example.myapplication;

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText Ed;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // User defined functionalities.
        //Ed = (EditText) findViewById(R.id.t1);

        tv = (TextView) findViewById(R.id.dsp);
    }

    public void add1(View view) {
        tv.setText(tv.getText() + "1");
    }

    public void add2(View view) {
        tv.setText(tv.getText() + "2");
    }

    public void add3(View view) {
        tv.setText(tv.getText() + "3");
    }

    public void add4(View view) {
        tv.setText(tv.getText() + "4");
    }

    public void add5(View view) {
        tv.setText(tv.getText() + "5");
    }

    public void add6(View view) {
        tv.setText(tv.getText() + "6");
    }

    public void add7(View view) {
        tv.setText(tv.getText() + "7");
    }

    public void add8(View view) {
        tv.setText(tv.getText() + "8");
    }

    public void add9(View view) {
        tv.setText(tv.getText() + "9");
    }

    public void add0(View view) {
        tv.setText(tv.getText() + "0");
    }

    public void clr(View view) {
        tv.setText("");
    }

    public void add(View view) {
        tv.setText(tv.getText() + " + ");
    }

    public void min(View view) {
        tv.setText(tv.getText() + " - ");
    }

    public void mul(View view) {
        tv.setText(tv.getText() + " * ");
    }

    public void div(View view) {
        tv.setText(tv.getText() + " / ");
    }

    public void equ(View view) {
        if (tv.getText().toString().isEmpty()) {
            tv.setText("Total: 0");
        } else {
            String[] st = tv.getText().toString().split(" ");
            int len = st.length;
            double tot = Double.parseDouble(st[0]);

            for (int i = 1; i < len; i = i + 2) {
                if (st[i].equals("+")) {
                    tot = tot + Double.parseDouble(st[i+1]);
                }
                if (st[i].equals("-")) {
                    tot = tot - Double.parseDouble(st[i+1]);
                }
                if (st[i].equals("*")) {
                    tot = tot * Double.parseDouble(st[i+1]);
                }
                if (st[i].equals("/")) {
                    tot = tot / Double.parseDouble(st[i+1]);
                }
            }

            tv.setText("Total: " + tot);
        }
    }
/*
    public void handleClick(View view) {

        Ed.setText("Hello " + Ed.getText());

    }
*/

}
