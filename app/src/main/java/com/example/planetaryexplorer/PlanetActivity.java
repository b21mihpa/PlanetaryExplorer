package com.example.planetaryexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class PlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        final ImageView planetImage = findViewById(R.id.planet_image);
        Glide.with(this).load(getIntent().getStringExtra("imageUrl")).into(planetImage);

        final Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }
}
