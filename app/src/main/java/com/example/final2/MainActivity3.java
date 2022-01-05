package com.example.final2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity3 extends AppCompatActivity implements OnMapReadyCallback {
    private final static int REQUEST_PERMISSIONS = 1;
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_PERMISSIONS:
                for (int result : grantResults) {
                    if (result != PackageManager.PERMISSION_GRANTED) {
                        finish();
                    } else {
                        SupportMapFragment map = (SupportMapFragment)
                                getSupportFragmentManager().findFragmentById(R.id.map);
                        map.getMapAsync(this);
                    }
                }
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new
                            String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_PERMISSIONS);
        else {
            SupportMapFragment map = (SupportMapFragment)
                    getSupportFragmentManager().findFragmentById(R.id.map);
            map.getMapAsync(this);

        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (ActivityCompat.checkSelfPermission(MainActivity3.this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(MainActivity3.this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED)
            return;
        Intent intent = this.getIntent();
        int restaurant = intent.getIntExtra("restaurant",0);
        switch (restaurant){
            case 0:{
                map.setMyLocationEnabled(true);
                MarkerOptions m1 = new MarkerOptions();
                m1.position(new LatLng(25.032212277260648,   121.55237764553577));
                m1.title("老朋友小酌熱炒");
                m1.draggable(true);
                map.addMarker(m1);
                MarkerOptions m2 = new MarkerOptions();
                m2.position(new LatLng(25.04079175230618, 121.5536609651548));
                m2.title("平價快炒");
                m2.draggable(true);
                map.addMarker(m2);
                break;
            }
            case 1:{
                map.setMyLocationEnabled(true);
                MarkerOptions m3 = new MarkerOptions();
                m3.position(new LatLng(25.032848742397324, 121.55964928250009));
                m3.title("聯合國食驗室 U.N. Cuisine Lab | 異國料理私廚");
                m3.draggable(true);
                map.addMarker(m3);
                MarkerOptions m4 = new MarkerOptions();
                m4.position(new LatLng(25.029052680313534, 121.55681805292863));
                m4.title("塔吉摩洛哥料理");
                m4.draggable(true);
                map.addMarker(m4);
                break;
            }
            case 2:{
                map.setMyLocationEnabled(true);
                MarkerOptions m5 = new MarkerOptions();
                m5.position(new LatLng(25.01765681751727, 121.53263725719961));
                m5.title("俄羅斯城堡");
                m5.draggable(true);
                map.addMarker(m5);
            }
        }


        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(25.034, 121.545),13));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

