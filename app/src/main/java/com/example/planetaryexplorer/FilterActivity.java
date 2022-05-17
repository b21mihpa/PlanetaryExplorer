package com.example.planetaryexplorer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        final SharedPreferences sharedPreferences = getSharedPreferences("store", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final CheckBox checkboxTerrestrialPlanets = findViewById(R.id.checkbox_terrestrial_planets);
        checkboxTerrestrialPlanets.setChecked(sharedPreferences.getBoolean("show_terrestrial_planets", true));
        checkboxTerrestrialPlanets.setOnClickListener(view -> editor.putBoolean("show_terrestrial_planets", checkboxTerrestrialPlanets.isChecked()));

        final CheckBox checkBoxJovianPlanets = findViewById(R.id.checkbox_jovian_planets);
        checkBoxJovianPlanets.setChecked((sharedPreferences.getBoolean("show_jovian_planets", true)));
        checkBoxJovianPlanets.setOnClickListener(view -> editor.putBoolean("show_jovian_planets", checkBoxJovianPlanets.isChecked()));

        final Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            editor.apply();
        });
    }
}