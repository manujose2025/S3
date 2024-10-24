package com.example.databaseconnection;

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
    EditText ln, fn, mk;
    MyDatabase dbase = new MyDatabase(this);
    TextView rt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            fn = findViewById(R.id.et_fname);
            ln = findViewById(R.id.et_lname);
            mk = findViewById(R.id.et_marks);
            rt = findViewById(R.id.tv_rslt);
            return insets;
        });
    }

    public void onInsert(View view) {
        boolean rst = dbase.insert(fn.getText().toString(), ln.getText().toString(), Double.parseDouble(mk.getText().toString()));
        if (rst == true)
            Toast.makeText(this, "Insert Successful", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
    }
}
