package com.example.planetaryexplorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    private List<Planet> planets;

    private Context context;

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
        Glide.with(context).load(planets.get(position).imageUrl).into(holder.planetImage);
        holder.planetName.setText(planets.get(position).name);
        holder.planetAge.setText("Age: " + planets.get(position).age + " billion years");
        holder.planetRadius.setText("Radius: " + planets.get(position).radius + " kilometers");
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public class PlanetViewHolder extends RecyclerView.ViewHolder {
        private final ImageView planetImage;
        private final TextView planetName;
        private final TextView planetAge;
        private final TextView planetRadius;

        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            planetImage = itemView.findViewById(R.id.planet_image);
            planetName = itemView.findViewById(R.id.planet_name);
            planetAge = itemView.findViewById(R.id.planet_age);
            planetRadius = itemView.findViewById(R.id.planet_radius);
        }
    }
}
