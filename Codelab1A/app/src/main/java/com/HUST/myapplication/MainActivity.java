package com.HUST.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonToast, buttonCount;
    private TextView textViewCount;
    private int count = 0;

    SharedPreferences sharedPreferences;

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

        retrieveCount();
    }

    @Override
    protected void onPause() {
        saveCount();
        super.onPause();
    }

    public void saveCount() {
        sharedPreferences = getSharedPreferences("saveCount", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count", count);
        editor.commit();
    }

    @SuppressLint("SetTextI18n")
    public void retrieveCount() {
        sharedPreferences = getSharedPreferences("saveCount", Context.MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 0);
        textViewCount.setText("" + count);
    }
}