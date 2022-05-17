package com.example.planetaryexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class PlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        final ImageView planetImage = findViewById(R.id.planet_image);
        final TextView planetName = findViewById(R.id.planet_name);
        final TextView planetLocation = findViewById(R.id.planet_location);
        final TextView planetCategory = findViewById(R.id.planet_category);
        final TextView planetRadius = findViewById(R.id.planet_radius);
        final TextView planetAge = findViewById(R.id.planet_age);

        Glide.with(this).load(getIntent().getStringExtra("imageUrl")).into(planetImage);
        planetName.setText(getIntent().getStringExtra("name"));
        planetLocation.setText(String.format("%s is the %s.", getIntent().getStringExtra("name"), getIntent().getStringExtra("location")));
        planetCategory.setText(String.format("Category: %s Planet", capitalize(getIntent().getStringExtra("category"))));
        planetRadius.setText(String.format("Radius: %d kilometers", getIntent().getIntExtra("radius", 0)));
        planetAge.setText(String.format("Age: %d billion years", getIntent().getIntExtra("age", 0)));

        final Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }

    private String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
