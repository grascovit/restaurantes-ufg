package br.ufg.inf.restaurantesufg.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import br.ufg.inf.restaurantesufg.R;
import br.ufg.inf.restaurantesufg.adapters.RestaurantAdapter;
import br.ufg.inf.restaurantesufg.models.Restaurant;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.restaurants_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadRestaurants();
    }

    private void loadRestaurants() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("restaurants");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ArrayList<Restaurant> restaurants = new ArrayList<>();

                for (DataSnapshot restaurantsSnapshot: snapshot.getChildren()) {
                    HashMap restaurant = (HashMap) restaurantsSnapshot.getValue();
                    restaurants.add(new Restaurant(
                        restaurant.get("name").toString(),
                        restaurant.get("latitude").toString(),
                        restaurant.get("longitude").toString(),
                        restaurant.get("image").toString()
                    ));
                }

                adapter = new RestaurantAdapter(restaurants, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("FIREBASE_ERROR", "Failed to read restaurants list", error.toException());
            }
        });
    }
}
