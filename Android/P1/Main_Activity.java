package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
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

    /*public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }*/

    public void Login(View view) {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.pt1);
        //String str1 = et1.getText().toString();
        //String str2 = et2.getText().toString();

        if(et1.getText().toString().isEmpty())
        {
            et1.setError("Please enter email.");
        }
        if(et2.getText().toString().isEmpty())
        {
            et2.setError("Please enter password.");
        }
        if (et1.getText().toString().equals("admin") && et2.getText().toString().equals("admin"))
        {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            //TextView tv = (TextView) findViewById(R.id.p2_tv1);
            //tv.setText("Welcome " + et1.getText().toString());
            //Intent it = new Intent(MainActivity.this, Page2.class);
            //startActivity(it);

            Intent lg_wc = new Intent(MainActivity.this, Page2.class);

            Bundle bun = new Bundle();
            bun.putString("uname", et1.getText().toString());
            bun.putString("pswd", et2.getText().toString());

            lg_wc.putExtras(bun);

            startActivity(lg_wc);
            finish();
        }
        else
        {
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    public void Cancel(View view) {
        //setActivityBackgroundColor(0xfff00000);
        getWindow().getDecorView().setBackgroundColor(0xfff00000);
    }

    public void facebookButton(View view) {
        Toast.makeText(this, "Moving to facebook", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, facebook_login.class));
        //Intent  = new Intent(MainActivity.this, facebook_login.class);
        //Intent it_fb = new Intent(Intent.ACTION_VIEW);
        //it_fb.setData(Uri.parse("https://www.facebook.com"));
    }
}
