package com.exercise.elal.prototipodetelas

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import com.exercise.elal.prototipodetelas.Tab0EventsActivity.event.eventos


class Tab1MapActivity : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener{

    private val LOCATION_REQUEST_CODE = 101
    private val permissionList = arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION)
    lateinit var gMap: GoogleMap
    lateinit var mapV: MapView
    lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermissions(permissionList, LOCATION_REQUEST_CODE)
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

    override fun onMarkerClick(p0: Marker?) = false

    override fun onMapReady(googleMap: GoogleMap) {

        MapsInitializer.initialize(context)

        //controles de mapa
        googleMap.uiSettings.setCompassEnabled(true)
        googleMap.uiSettings.setZoomControlsEnabled(true)
        googleMap.uiSettings.isMyLocationButtonEnabled = true
        googleMap.setOnMarkerClickListener(this)

        if(ContextCompat.checkSelfPermission(this.context as Context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            googleMap.isMyLocationEnabled = true
        }

        //algumas cordenadas
        val stPt = LatLng(-8.047460, -34.917462) //ponto inicial do zoom do mapa

        gMap = googleMap

        //ajustes para criação do ícone no mapa
        val height = 86
        val width = 86
        val myDrawable = resources.getDrawable(R.drawable.thefreeforty_location)
        val bitImage = (myDrawable as BitmapDrawable).bitmap
        val smallMarker = Bitmap.createScaledBitmap(bitImage, width, height, false)
        val markerFin = BitmapDescriptorFactory.fromBitmap(smallMarker)

        // criação dos pontos no mapa
        val eventList = Tab0EventsActivity.event.eventos
        for (i in eventList){
            gMap.addMarker(MarkerOptions().position(LatLng(i.cordLat, i.cordLng))
                                          .title(i.address)
                                          .snippet(R.string.eventhr.toString() + i.name.toString())
                                          .icon(markerFin))
        }

        val start_point : CameraPosition = CameraPosition.builder().target(stPt).zoom(13F).bearing(4F).build()

        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(start_point))


    }

}
