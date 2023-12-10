package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class GoogleMapActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_map)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {

        mMap = p0


        val location = LatLng(40.7128 ,-74.0060) // New York
        mMap.addMarker(MarkerOptions().position(location).title("Marker in New York City"))




        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12f))


    }


}
