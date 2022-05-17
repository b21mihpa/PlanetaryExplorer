package com.example.planetaryexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener, PlanetAdapter.OnPlanetClickListener {

    private List<Planet> planets;
    private PlanetAdapter planetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.planets_list);
        planets = new ArrayList<>();
        planetAdapter = new PlanetAdapter(planets, this);
        recyclerView.setAdapter(planetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new JsonTask(this).execute("https://mobprog.webug.se/json-api?login=b21mihpa");

        final Button aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(view -> startActivity(new Intent(this, AboutActivity.class)));

        final Button filterButton = findViewById(R.id.filter_button);
        filterButton.setOnClickListener(view -> startActivity(new Intent(this, FilterActivity.class)));
    }

    private void applyFilter() {
        final SharedPreferences sharedPreferences = getSharedPreferences("store", MODE_PRIVATE);

        if (!sharedPreferences.getBoolean("show_terrestrial_planets", true)) {
            planets.removeIf(planet -> planet.category.equals("terrestrial"));
        }

        if (!sharedPreferences.getBoolean("show_jovian_planets", true)) {
            planets.removeIf(planet -> planet.category.equals("jovian"));
        }

        planetAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        this.planets.addAll(gson.fromJson(json, new TypeToken<List<Planet>>(){}.getType()));
        planetAdapter.notifyDataSetChanged();
        applyFilter();
    }

    @Override
    public void onPlanetClick(int position) {
        final Intent intent = new Intent(this, PlanetActivity.class);
        intent.putExtra("imageUrl", planets.get(position).imageUrl);
        intent.putExtra("name", planets.get(position).name);
        startActivity(intent);
    }
}