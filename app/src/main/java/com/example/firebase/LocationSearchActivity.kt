package com.example.firebase

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

class LocationSearchActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    lateinit var searchView: SearchView


    var addedMarker: Marker? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_search)
        initView()

    }

    private fun initView() {

        searchView = findViewById(R.id.idSearchView)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        searchView.setOnQueryTextListener(/* listener = */ object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                val location = searchView.query.toString()

                var addressList: List<Address>? = null


                if (location != null || location == "") {

                    val geocoder = Geocoder(this@LocationSearchActivity)
                    try {

                        addressList = geocoder.getFromLocationName(location, 1)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                    val address = addressList!![0]

                    val latLng = LatLng(address.latitude, address.longitude)

                    Log.e(
                        "TAG",
                        "latitude:-  " + address.latitude + " " + "longitude:- " + address.longitude
                    )


                    // on below line we are adding marker to that position.
                    addedMarker = mMap.addMarker(MarkerOptions().position(latLng).title(location))!!

                    // below line is to animate camera to that position.
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f))


                }

                return false

            }


            override fun onQueryTextChange(newText: String): Boolean {
                addedMarker?.remove()
                return false

            }

        })

        // at last we calling our map fragment to update.
        mapFragment!!.getMapAsync(this)


    }

   override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }


}