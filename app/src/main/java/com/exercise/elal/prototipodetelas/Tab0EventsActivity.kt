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

    object event {

        val eventos = ArrayList<Evento>()
        var favoritos = ArrayList<Evento>()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_tab_event,container, false)

    //getting recyclerview from xml
    val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.setHasFixedSize(true)

    //adding a layoutmanager
    recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)



    //crating an arraylist to store users using the data class user

        val ingresso = Ingresso(123456789)

    //adding some dummy data to the list
    event.eventos.add(Evento("Som de Doido",
            "Dois Irmãos, \nRecife, \n123",
            "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
            "20/11-16h",
            15,
            200,
            "imageCodigo",
            -8.017724,
            -34.944367,
            false,
            ingresso))
    event.eventos.add(Evento("Cola Grau - A União",
            "Salão Nobre UFRPE - Dois Irmãos, \nRecife, \n456",
            "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
            "20/11-14h",
            15,
            200,
            "imageCodigo",
            -8.014445,
            -34.950528,
            false,
            ingresso))
    event.eventos.add(Evento("Breja Diferenciada",
            "Bar da Curva - Dois Irmãos, \nRecife, \n789",
            "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
            "20/11-20h",
            10,
            350,
            "imageCodigo",
            -8.016153,
            -34.945425,
            true,
            ingresso))

    //creating our adapter
    val adapter = CustomAdapter(event.eventos)

    event.eventos.filterTo(event.favoritos) {it.favorite == true}

    //now adding the adapter to recyclerview
    recyclerView.adapter = adapter
        return view
    }

}
