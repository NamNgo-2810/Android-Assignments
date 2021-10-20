package com.HUST.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonToast, buttonCount;
    private TextView textViewCount;
    private int count = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonToast = findViewById(R.id.buttonToast);
        buttonCount = findViewById(R.id.buttonCount);
        textViewCount = findViewById(R.id.textViewCount);

        buttonToast.setOnClickListener(v -> Toast.makeText(MainActivity.this, "You tapped the toast button", Toast.LENGTH_LONG).show());
        buttonCount.setOnClickListener(v -> {
            count++;
            textViewCount.setText("" + count);
        });
    }
}