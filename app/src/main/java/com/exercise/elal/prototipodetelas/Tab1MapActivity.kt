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

        //controles de mapa
        googleMap.uiSettings.setCompassEnabled(true)
        googleMap.uiSettings.setZoomControlsEnabled(true)
        googleMap.uiSettings.setMyLocationButtonEnabled(true)

        val stPt = LatLng(-8.047460, -34.917462)

        val ceagri = LatLng(-8.017724, -34.944367)
        val bdc = LatLng(-8.016153, -34.945425)
        val sl_nb = LatLng(-8.014445, -34.950528)
        val cs_marc = LatLng(-8.020633, -34.956783)


        gMap = googleMap
        gMap.addMarker(MarkerOptions().position(ceagri).title("CREAGRI II").snippet("Eventos aqui: Amansa Calouro, Som de Doido"))
        gMap.addMarker(MarkerOptions().position(bdc).title("Bar da Curva").snippet("Eventos aqui: Caloujava, Bregosidade"))
        gMap.addMarker(MarkerOptions().position(sl_nb).title("Salão Nobre - UFRPE").snippet("Eventos aqui: Aula Magna"))
        gMap.addMarker(MarkerOptions().position(cs_marc).title("Casa de Pai Marcos").snippet("Eventos aqui: Bate Terreiro, Fumaça Não É Água"))

        val start_point : CameraPosition = CameraPosition.builder().target(stPt).zoom(12F).bearing(4F).build()

        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(start_point))


    }

    /*private void hideNavBar(){
        this.getWindow().getDecorView().setSystemVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                                                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                                            View.SYSTEM_UI_IMMERSIVE_STICKY |
                                                            View.SYSTEM_UI_FLAG_LAYOUT_FULLCSREEN |
                                                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }*/


}