package com.example.planetaryexplorer;

import android.annotation.SuppressLint;
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

    private OnPlanetClickListener onPlanetClickListener;

    public PlanetAdapter(List<Planet> planets, OnPlanetClickListener onPlanetClickListener) {
        this.planets = planets;
        this.onPlanetClickListener = onPlanetClickListener;
    }

    @NonNull
    @Override
    public PlanetAdapter.PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PlanetViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_list_item, parent, false), onPlanetClickListener);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.PlanetViewHolder holder, int position) {
        Glide.with(context).load(planets.get(position).imageUrl).into(holder.planetImage);
        holder.planetName.setText(planets.get(position).name);
        holder.planetAge.setText(String.format("Age: %d billion years", planets.get(position).age));
        holder.planetRadius.setText(String.format("Radius: %d kilometers", planets.get(position).radius));
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public class PlanetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView planetImage;
        private final TextView planetName;
        private final TextView planetAge;
        private final TextView planetRadius;

        private OnPlanetClickListener onPlanetClickListener;

        public PlanetViewHolder(@NonNull View itemView, OnPlanetClickListener onPlanetClickListener) {
            super(itemView);

            context = itemView.getContext();

            planetImage = itemView.findViewById(R.id.planet_image);
            planetName = itemView.findViewById(R.id.planet_name);
            planetAge = itemView.findViewById(R.id.planet_age);
            planetRadius = itemView.findViewById(R.id.planet_radius);

            this.onPlanetClickListener = onPlanetClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onPlanetClickListener.onPlanetClick(getAdapterPosition());
        }
    }

    public interface OnPlanetClickListener {
        void onPlanetClick(int position);
    }
}
