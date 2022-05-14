package com.example.planetaryexplorer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    private List<Planet> planets;

    public PlanetAdapter(List<Planet> planets) {
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetAdapter.PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlanetViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.PlanetViewHolder holder, int position) {
        holder.planetName.setText(planets.get(position).name);
        holder.planetAge.setText("Age: " + planets.get(position).age + " billion years");
        holder.planetRadius.setText("Radius: " + planets.get(position).radius + " kilometers");
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public class PlanetViewHolder extends RecyclerView.ViewHolder {
        private TextView planetName;
        private TextView planetAge;
        private TextView planetRadius;

        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);

            planetName = itemView.findViewById(R.id.planet_name);
            planetAge = itemView.findViewById(R.id.planet_age);
            planetRadius = itemView.findViewById(R.id.planet_radius);
        }
    }
}
