package com.hust.externalstoragescan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReadFile extends AppCompatActivity {

    TextView content, filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        filename = findViewById(R.id.filename);
        content = findViewById(R.id.content);

        filename.setText(getIntent().getStringExtra("filename"));
        content.setText(getIntent().getStringExtra("content"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}