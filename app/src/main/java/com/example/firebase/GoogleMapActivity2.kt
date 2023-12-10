package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class GoogleMapActivity2 : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap
    private var clickedMarker: Marker? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_map2)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        val location = LatLng(40.7128 ,-74.0060) // New York
        mMap.addMarker(MarkerOptions().position(location).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.newyork)))

        val Location1 = LatLng(39.66273 ,-101.68737) //  United State
        mMap.addMarker(MarkerOptions().position(Location1).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.unitedstate)))

        val Location2 = LatLng(59.530832 ,-110.990173) // Canada
        mMap.addMarker(MarkerOptions().position(Location2).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.canada)))

        val Location3 = LatLng(-25.945513 ,134.573891) // Australia
        mMap.addMarker(MarkerOptions().position(Location3).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.australia)))

        val Location4 = LatLng(-9.016260 ,-53.177386) // Brazil
        mMap.addMarker(MarkerOptions().position(Location4).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.brazil)))

        val Location5 = LatLng(22.47700 ,79.46420) // India
        mMap.addMarker(MarkerOptions().position(Location5).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.india)))


        val Location6 = LatLng(22.47700 ,79.46420) // Chin
        mMap.addMarker(MarkerOptions().position(Location6).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.china)))

        val Location7 = LatLng(51.50682 ,-0.10577) // UnitedKingdom
        mMap.addMarker(MarkerOptions().position(Location7).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.london)))

        val Location8 = LatLng(51.99284 ,5.70975) // Netherlands
        mMap.addMarker(MarkerOptions().position(Location8).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.netherlands)))

        val Location9 = LatLng(36.22587 ,139.25274) // Japan
        mMap.addMarker(MarkerOptions().position(Location9).title("Marker in New York City")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.japan)))



        mMap.setOnMapClickListener { latLng ->
            // Remove the previously clicked marker, if any
            clickedMarker?.remove()

            // Add a new marker at the clicked location
            clickedMarker = mMap.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title("New Marker")
            )

            // Move the camera to the clicked location and set zoom level
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12f))
        }
    }

}