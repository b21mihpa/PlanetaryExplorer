package com.example.planetaryexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener, PlanetAdapter.OnPlanetClickListener {
    private final String API_ENDPOINT = "https://mobprog.webug.se/json-api?login=b21mihpa";

    private List<Planet> planets;
    private RecyclerView recyclerView;
    private PlanetAdapter planetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(API_ENDPOINT);

        final Button aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(view -> startActivity(new Intent(this, AboutActivity.class)));

        final Button filterButton = findViewById(R.id.filter_button);
        filterButton.setOnClickListener(view -> startActivity(new Intent(this, FilterActivity.class)));
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        planets = gson.fromJson(json, new TypeToken<List<Planet>>(){}.getType());

        recyclerView = findViewById(R.id.planets_list);
        planetAdapter = new PlanetAdapter(planets, this);
        recyclerView.setAdapter(planetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onPlanetClick(int position) {
        Log.d("planet_index", String.valueOf(position));
    }
}