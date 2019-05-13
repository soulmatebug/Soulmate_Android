package com.example.tripplanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_map.*
import net.daum.mf.map.api.MapView

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


        val mapView = MapView(this);

        mapView.setDaumMapApiKey("315376456c1dc98a1884db3c17e7d7ab")

        val mapViewContainer = map_view
        mapViewContainer.addView(mapView)
    }
}
