package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page2 extends AppCompatActivity {
    TextView tv_un;
    TextView tv_pa;
    //EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            //tv = (TextView) findViewById(R.id.p2_lb1);
            /*et = (EditText) findViewById(R.id.et1);
            tv.setText("Welcome " + et.getText().toString());

             */
            //tv.setText("Welcome");

            Bundle bdle = getIntent().getExtras();
            String un = bdle.getString("uname");
            String pa = bdle.getString("pswd");

            tv_un = (TextView) findViewById(R.id.p2_tv_un);
            tv_pa = (TextView) findViewById(R.id.p2_tv_pa);

            tv_un.setText(un);
            tv_pa.setText(pa);

            return insets;





        });
    }

    public void logout(View view) {
        //Intent it = getIntent();
        //it.FLAG_ACTIVITY_CLEAR_TASK;
        Intent lgout = new Intent(Page2.this, MainActivity.class);
        startActivity(lgout);
        finish();
    }
}
