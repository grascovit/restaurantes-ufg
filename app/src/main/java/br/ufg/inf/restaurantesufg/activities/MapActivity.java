package br.ufg.inf.restaurantesufg.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.ufg.inf.restaurantesufg.R;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        final String restaurantName = getIntent().getStringExtra("name");
        final String restaurantLatitude = getIntent().getStringExtra("latitude");
        final String restaurantLongitude = getIntent().getStringExtra("longitude");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_restaurant);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng restaurantCoordinates = new LatLng(Double.parseDouble(restaurantLatitude), Double.parseDouble(restaurantLongitude));
                MarkerOptions markerOptions = new MarkerOptions().position(restaurantCoordinates).title(restaurantName);
                googleMap.addMarker(markerOptions).showInfoWindow();
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(restaurantCoordinates));
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
            }
        });
    }
}
