package br.ufg.inf.restaurantesufg.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufg.inf.restaurantesufg.R;
import br.ufg.inf.restaurantesufg.models.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    private ArrayList<Restaurant> restaurants;

    public RestaurantAdapter(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_restaurant, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.ViewHolder viewHolder, int i) {
        viewHolder.textViewRestaurantName.setText(restaurants.get(i).name);
        viewHolder.textViewRestaurantLatitude.setText(restaurants.get(i).latitude);
        viewHolder.textViewRestaurantLongitude.setText(restaurants.get(i).longitude);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewRestaurantName;
        private TextView textViewRestaurantLatitude;
        private TextView textViewRestaurantLongitude;

        public ViewHolder(View view) {
            super(view);
            textViewRestaurantName = view.findViewById(R.id.text_view_restaurant_name);
            textViewRestaurantLatitude = view.findViewById(R.id.text_view_restaurant_latitude);
            textViewRestaurantLongitude = view.findViewById(R.id.text_view_restaurant_longitude);
        }
    }
}