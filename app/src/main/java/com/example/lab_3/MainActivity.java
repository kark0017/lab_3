package com.example.lab_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String storedName = sharedPreferences.getString("userName", "");

        EditText editText = findViewById(R.id.pt_name);
        editText.setText(storedName);

        Intent nextPage = new Intent(this, NameActivity.class);

        Button nextBtn = findViewById(R.id.btn_next);
        nextBtn.setOnClickListener( click -> {

            String name = editText.getText().toString();
            nextPage.putExtra("userName", name);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("userName", name);
            editor.apply();

            startActivityForResult(nextPage, 0);

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 0){
            finish();
        }


    }
}