package com.example.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Urdaneta = new LatLng(15.97528056576335, 120.56212122007881);
        mMap.addMarker(new MarkerOptions().position(Urdaneta).title("Marker in WAJE House"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Urdaneta));


        LatLng UCU = new LatLng(15.980128976239397, 120.560499808554);
        mMap.addMarker(new MarkerOptions().position(UCU).title("Marker in UCU"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UCU));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);


        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(15.975280825906731, 120.56212397954381),
                        new LatLng(15.975357346503351, 120.5621192975135),
                        new LatLng(15.975582406916283, 120.5637345978942),
                        new LatLng(15.976716642338962, 120.56364823102592),
                        new LatLng(15.97999602922764, 120.56343157529392),
                        new LatLng(15.981790806068572, 120.56014025224546),
                        new LatLng( 15.981445146602603, 120.56020478799392),
                        new LatLng(15.980128976239397, 120.560499808554))

                .width(10)
                .color(Color.BLUE));
//Waje location
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.97528056576335, 120.56212122007881))
                .radius(10)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

        //UCU location
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.9796885700614, 120.5607071226075))
                .radius(100)
                .strokeWidth(10)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));
    }
}