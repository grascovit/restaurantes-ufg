package br.ufg.inf.restaurantesufg.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufg.inf.restaurantesufg.R;
import br.ufg.inf.restaurantesufg.activities.MainActivity;
import br.ufg.inf.restaurantesufg.activities.MapActivity;
import br.ufg.inf.restaurantesufg.models.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    private ArrayList<Restaurant> restaurants;
    private Context context;

    public RestaurantAdapter(ArrayList<Restaurant> restaurants, Context context) {
        this.restaurants = restaurants;
        this.context = context;
    }

    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_restaurant, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.ViewHolder viewHolder, final int i) {
        final String name = restaurants.get(i).name;
        final String latitude = restaurants.get(i).latitude;
        final String longitude = restaurants.get(i).longitude;

        viewHolder.textViewRestaurantName.setText(name);
        viewHolder.textViewRestaurantLatitude.setText(latitude);
        viewHolder.textViewRestaurantLongitude.setText(longitude);
        viewHolder.cardViewRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardViewRestaurant;
        private TextView textViewRestaurantName;
        private TextView textViewRestaurantLatitude;
        private TextView textViewRestaurantLongitude;

        public ViewHolder(View view) {
            super(view);
            cardViewRestaurant = view.findViewById(R.id.card_view_restaurant);
            textViewRestaurantName = view.findViewById(R.id.text_view_restaurant_name);
            textViewRestaurantLatitude = view.findViewById(R.id.text_view_restaurant_latitude);
            textViewRestaurantLongitude = view.findViewById(R.id.text_view_restaurant_longitude);
        }
    }
}