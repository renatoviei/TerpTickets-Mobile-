package com.exercise.elal.prototipodetelas

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_tab_event.*
import model.Evento
import model.Ingresso




class Tab0EventsActivity : Fragment(){

    object Event {

        val eventos = ArrayList<Evento>()
        var favoritos = ArrayList<Evento>()

    }

    override fun onStart() {
        super.onStart()
        val ad = recyclerView?.adapter
        ad?.notifyDataSetChanged()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_tab_event,container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView //getting recyclerview from xml

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.layoutManager = GridLayoutManager(this@Tab0EventsActivity.context, 2)
        }
        else {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false) //adding a layoutmanager
        }

        if(Event.eventos.isEmpty()) {

            getDataFromFirebase()

            val database = FirebaseDatabase.getInstance()     // Write a message to the database
            val myRef = database.reference
            val ingresso = Ingresso(123456789)
            myRef.setValue("Hello, World!")

            val somdedoido = Evento("Som de Doido 2",
                    "Dois Irmãos, \nRecife, \n123",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-16h",
                    15,
                    200,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/Art_by_Suqling.jpg?alt=media&token=a4c75f23-5bd9-439a-992f-9f91957f639b",
                    -8.017724,
                    -34.944367,
                    false,
                    ingresso.codigo)
            val colagrau = Evento("Cola Grau - A União",
                    "Salão Nobre UFRPE - Dois Irmãos, \nRecife, \n456",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-14h",
                    15,
                    200,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/Kendrick-Lamar-Wallpaper-HD-1024x726.jpg?alt=media&token=7672d860-4370-4e08-9ffa-62fca744fe5c",
                    -8.014445,
                    -34.950528,
                    false,
                    ingresso.codigo)
            val brejadif = Evento("Breja Diferenciada",
                    "Bar da Curva - Dois Irmãos, \nRecife, \n789",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-20h",
                    10,
                    350,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/rolling.jpg?alt=media&token=70af8b3f-4468-4c88-a62c-0018efdab044",
                    -8.016153,
                    -34.945425,
                    false,
                    ingresso.codigo)

            database.reference.child("eventos").child("somdedoido").setValue(somdedoido)
            database.reference.child("eventos").child("colagrau").setValue(colagrau)
            database.reference.child("eventos").child("brejadiferenciada").setValue(brejadif)
        }
        val adapter = CustomAdapter(Event.eventos) //creating our adapter

        Event.favoritos.clear()
        if(Event.eventos.isNotEmpty()){
            Event.eventos.filterTo(Event.favoritos) { it.favorite == true }
        }
        recyclerView.adapter = adapter //now adding the adapter to recyclerview
        return view
    }



    fun getDataFromFirebase() {
        val database = FirebaseDatabase.getInstance()
        val newReference = database.getReference("eventos")

        newReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {

                for (snapshot in p0.children) {

                    val hashMap = snapshot.value as HashMap<*, *>

                    if (hashMap.size > 0) {

                        val evento = Evento(hashMap["name"].toString(), hashMap["address"].toString(), hashMap["description"].toString(), hashMap["dateHour"].toString(), hashMap["price"].toString().toInt(), hashMap["numTickets"].toString().toInt(),hashMap["image"].toString(),hashMap["cordLat"].toString().toDouble() ,hashMap["cordLng"].toString().toDouble(), false, hashMap["ticket"].toString().toLong() )

                        if(!Event.eventos.contains(evento)){
                            Tab0EventsActivity.Event.eventos.add(evento)}
                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }

}



