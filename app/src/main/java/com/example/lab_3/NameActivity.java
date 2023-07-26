package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Intent intent = getIntent();

        String userName = intent.getStringExtra("userName");
        TextView welcomeTextView = findViewById(R.id.welcomeText);
        welcomeTextView.setText("Welcome " + userName);

        Button btn_thankYou = findViewById(R.id.btn_thankyou);
        Button btn_change = findViewById(R.id.btn_change);

        btn_change.setOnClickListener(click -> {
            setResult(1);
            finish();
        });

        btn_thankYou.setOnClickListener(click-> {
            setResult(0);
            finish();
        });





    }
}