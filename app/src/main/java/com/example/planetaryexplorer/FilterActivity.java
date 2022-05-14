package com.example.planetaryexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        final Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }
}