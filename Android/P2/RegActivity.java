package com.example.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
            TextView value = findViewById(R.id.tv_name);
            value.setText(pref.getString("name", ""));
            value = findViewById(R.id.tv_email);
            value.setText(pref.getString("email",""));
            value = findViewById(R.id.tv_phone);
            value.setText(pref.getString("ph", ""));
            value = findViewById(R.id.tv_dob);
            value.setText(pref.getString("dt",""));
            value = findViewById(R.id.tv_gender);
            value.setText(pref.getString("gen", ""));

            return insets;
        });
    }
}
