package com.example.planetaryexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    private List<Planet> planets;
    private final String API_ENDPOINT = "https://mobprog.webug.se/json-api?login=b21mihpa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(API_ENDPOINT);

        final Button aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(view -> startActivity(new Intent(this, AboutActivity.class)));
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        planets = gson.fromJson(json, new TypeToken<List<Planet>>(){}.getType());
    }
}