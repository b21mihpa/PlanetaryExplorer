package com.example.planetaryexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(view -> startActivity(new Intent(this, AboutActivity.class)));
    }
}