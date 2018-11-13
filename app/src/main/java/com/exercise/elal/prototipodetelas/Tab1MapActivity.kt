package com.exercise.elal.prototipodetelas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_tab_map.*

class Tab1MapActivity : Fragment(), OnMapReadyCallback{

    lateinit var gMap: GoogleMap
    lateinit var mapV: MapView
    lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_tab_map,container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapV = mView.findViewById(R.id.mapView)
        if(mapV != null) {
            mapV.onCreate(null)
            mapV.onResume()
            mapV.getMapAsync(this)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {

        MapsInitializer.initialize(context)
        val ceagri = LatLng(-8.017724, -34.944367)

        gMap = googleMap
        gMap.addMarker(MarkerOptions().position(ceagri).title("CREAGRI II").snippet("João Vasconcelos Sobrinho"))

        val jvs : CameraPosition = CameraPosition.builder().target(ceagri).zoom(16F).bearing(0F).build()

        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(jvs))


    }


}