package com.exercise.elal.prototipodetelas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import model.Evento
import model.Ingresso


class Tab0EventsActivity : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_tab_event,container, false)

    //getting recyclerview from xml
    val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.setHasFixedSize(true)

    //adding a layoutmanager
    recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)



    //crating an arraylist to store users using the data class user
    val eventos = ArrayList<Evento>()
    val ingresso = Ingresso(123456789)

    //adding some dummy data to the list
    eventos.add(Evento("Som de Doido",  "Candeias, Jaboatão dos Guararapes, 123", "Vai ser massa", "20/11-16h", 15, 200,"imageCodigo", ingresso))
    eventos.add(Evento("Som de Doido", "Candeias, Jaboatão dos Guararapes, 123", "Vai ser massa", "20/11-16h", 15, 200,"imageCodigo", ingresso))
    eventos.add(Evento("Som de Doido", "Candeias, Jaboatão dos Guararapes, 123", "Vai ser massa","20/11-16h", 15, 200,"imageCodigo", ingresso))
    eventos.add(Evento("Som de Doido", "Candeias, Jaboatão dos Guararapes, 123", "Vai ser massa", "20/11-16h", 15, 200,"imageCodigo", ingresso))
    eventos.add(Evento("Som de Doido", "Candeias, Jaboatão dos Guararapes, 123", "Vai ser massa" , "20/11-16h", 15, 200,"imageCodigo", ingresso))
    eventos.add(Evento("Som de Doido", "Candeias, Jaboatão dos Guararapes, 123", "Vai ser massa", "20/11-16h", 15, 200,"imageCodigo", ingresso))
    eventos.add(Evento("Som de Doido", "Candeias, Jaboatão dos Guararapes, 123", "Vai ser massa", "20/11-16h", 15, 200,"imageCodigo", ingresso))
    eventos.add(Evento("Som de Doido", "Candeias, Jaboatão dos Guararapes, 123", "Vai ser massa", "20/11-16h", 15, 200,"imageCodigo", ingresso))

    //creating our adapter
    val adapter = CustomAdapter(eventos)

    //now adding the adapter to recyclerview
    recyclerView.adapter = adapter
        return view
    }

}
