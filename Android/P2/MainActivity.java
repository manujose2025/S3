package com.example.sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {

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
    }

    public void Register(View view) {

        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        EditText value = findViewById(R.id.et_fname);
        if (value.toString().isEmpty())
            value.setError("This field is empty!");

        String fname = value.getText().toString();
        int flag = 0;

        String regx = "[a-zA-Z]+";

        Pattern pt = Pattern.compile(regx);
        Matcher mt = pt.matcher(fname);

        if (mt.matches())
            flag++;
        else
            value.setError("Enter correct first name.");

        value = findViewById(R.id.et_lname);
        if (value.toString().isEmpty())
            value.setError("This field is empty!");

        String lname = value.getText().toString();

        mt = pt.matcher(lname);

        if (mt.matches())
            flag++;
        else
            value.setError("Enter correct last name.");

        if (flag == 2)
            editor.putString("name", fname + " " + lname);

        value = findViewById(R.id.et_email);
        if (value.toString().isEmpty())
            value.setError("This field is empty!");

        String email = value.getText().toString();

        regx = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        pt = Pattern.compile(regx);
        mt = pt.matcher(email);

        if(mt.matches())
        {
            editor.putString("email", email);
            flag++;
        }
        else
            value.setError("Enter a valid email!");

        value = findViewById(R.id.et_pswd);
        if(value.toString().isEmpty())
            value.setError("This field is empty!");

        String pswd = value.getText().toString();

        regx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\S)(?=.*[@!#$%^&*]).{8,}$";
        pt = Pattern.compile(regx);
        mt = pt.matcher(pswd);

        if(mt.matches())
            flag++;
        else
            value.setError("Enter a valid password!");


        value = findViewById(R.id.et_phone);
        if(value.toString().isEmpty())
            value.setError("This field is empty!");

        String phone = value.getText().toString();

        regx = "[0-9]{10}";
        pt = Pattern.compile(regx);
        mt = pt.matcher(phone);

        if(mt.matches())
        {
            editor.putString("ph", phone);
            flag++;
        }
        else
            value.setError("Enter a valid phone number!");

        value = findViewById(R.id.et_dob);
        if(value.toString().isEmpty())
            value.setError("This field is empty!");

        String dob = value.getText().toString();

        regx = "^\\d{2}-\\d{2}-\\d{4}";
        pt = Pattern.compile(regx);
        mt = pt.matcher(dob);

        if(mt.matches())
        {
            String chkDate[] = dob.split("-");
            int dd = Integer.parseInt(chkDate[0]);
            int mm = Integer.parseInt(chkDate[1]);
            int yy = Integer.parseInt(chkDate[2]);
            int chkFlag = 0;

            if((yy > 0) && (yy <2025))
            {
                if(mm == 2)
                    if((dd > 0) && (dd < 29))
                        chkFlag = 1;
                else if((mm > 0) && ((mm == 1) || (mm == 3) || (mm == 5) || (mm == 7) || (mm == 8) || (mm == 10) || (mm == 12)))
                    if((dd > 0) && (dd < 32));
                        chkFlag = 1;
                else if((mm > 0) && ((mm == 4) || (mm == 6) || (mm == 9) || (mm == 11)))
                    if((dd > 0) && (dd < 31));
                        chkFlag = 1;

            }

            if (chkFlag == 2)
            {
                editor.putString("dt", dob);
                flag++;
            }
        }
        else
            value.setError("Enter a valid DoB!");

        RadioGroup rg = findViewById(R.id.rg_gender);
        int opt = rg.getCheckedRadioButtonId();
        RadioButton rb = findViewById(opt);
        String gender = rb.getText().toString();

        editor.putString("gen", gender);

        /*
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", fname+" "+lname);
        editor.putString("email", email);
        editor.putString("ph", phone);
        editor.putString("dt", dob);
        editor.putString("gen", gender);
        editor.apply();
        */



        if(flag == 6)
        {
            editor.apply();

            Intent pass = new Intent(this, RegActivity.class);
            startActivity(pass);
        }
        else
            Toast.makeText(this, "Failed",Toast.LENGTH_SHORT);
    }
}
