package com.exercise.elal.prototipodetelas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import model.Evento
import model.Favorito
import model.Ingresso
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


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

        if(event.eventos.isEmpty()) {
            // Write a message to the database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference()

            myRef.setValue("Hello, World!")
            //crating an arraylist to store users using the data class user

            val ingresso = Ingresso(123456789)

            //adding some dummy data to the list
            database.reference.child("eventos").child("somdedoido").setValue(Evento("Som de Doido 2",
                    "Dois Irmãos, \nRecife, \n123",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-16h",
                    15,
                    200,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/Art_by_Suqling.jpg?alt=media&token=a4c75f23-5bd9-439a-992f-9f91957f639b",
                    -8.017724,
                    -34.944367,
                    false,
                    ingresso.codigo))
            /*
            event.eventos.add(Evento("Som de Doido",
                    "Dois Irmãos, \nRecife, \n123",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-16h",
                    15,
                    200,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/Art_by_Suqling.jpg?alt=media&token=a4c75f23-5bd9-439a-992f-9f91957f639b",
                    -8.017724,
                    -34.944367,
                    false,
                    ingresso.codigo))
            */
            database.reference.child("eventos").child("colagrau").setValue(Evento("Cola Grau - A União",
                    "Salão Nobre UFRPE - Dois Irmãos, \nRecife, \n456",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-14h",
                    15,
                    200,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/Kendrick-Lamar-Wallpaper-HD-1024x726.jpg?alt=media&token=7672d860-4370-4e08-9ffa-62fca744fe5c",
                    -8.014445,
                    -34.950528,
                    false,
                    ingresso.codigo))
            /*
            event.eventos.add(Evento("Cola Grau - A União",
                    "Salão Nobre UFRPE - Dois Irmãos, \nRecife, \n456",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-14h",
                    15,
                    200,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/Kendrick-Lamar-Wallpaper-HD-1024x726.jpg?alt=media&token=7672d860-4370-4e08-9ffa-62fca744fe5c",
                    -8.014445,
                    -34.950528,
                    false,
                    ingresso.codigo))
            */
            database.reference.child("eventos").child("brejadiferenciada").setValue(Evento("Breja Diferenciada",
                    "Bar da Curva - Dois Irmãos, \nRecife, \n789",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-20h",
                    10,
                    350,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/rolling.jpg?alt=media&token=70af8b3f-4468-4c88-a62c-0018efdab044",
                    -8.016153,
                    -34.945425,
                    false,
                    ingresso.codigo))

            /*
            event.eventos.add(Evento("Breja Diferenciada",
                    "Bar da Curva - Dois Irmãos, \nRecife, \n789",
                    "Et faucibus leo. Cras varius purus at massa interdum, a imperdiet turpis porta. Vestibulum massa neque, hendrerit ut nisi vel, accumsan eleifend orci. Suspendisse pulvinar ullamcorper finibus. Nulla posuere ut dui at bibendum. Nulla eu diam pellentesque, interdum purus nec, tristique massa.",
                    "20/11-20h",
                    10,
                    350,
                    "https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/rolling.jpg?alt=media&token=70af8b3f-4468-4c88-a62c-0018efdab044",
                    -8.016153,
                    -34.945425,
                    false,
                    ingresso.codigo))

                    */
        }

        /*
        val name: String,
                  val address: String,
                  val description: String,
                  val dateHour: String,
                  val price: Int,
                  val numTickets: Int,
                  val image: String,
                  val cordLat: Double,
                  val cordLng: Double,
                  var favorite: Boolean,
                  val ticket: Long)

         */

        getDataFromFirebase()


    //creating our adapter
    val adapter = CustomAdapter(event.eventos)

        event.favoritos.clear()
        if(event.eventos.isNotEmpty()){
            event.eventos.filterTo(event.favoritos) { it.favorite == true }
        }




        //now adding the adapter to recyclerview
    recyclerView.adapter = adapter
        return view
    }

    fun getDataFromFirebase() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference()

        val newReference = database!!.getReference("eventos")

        newReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {

                //println(p0)
                //println("children: " + p0!!.children)
                //println("key:" + p0!!.key)
                //println("value:" + p0!!.value)

                //postAdapter!!.clear()
                //event.eventos.clear()

                for (snapshot in p0.children) {

                    val hashMap = snapshot.value as HashMap<String, *>

                    if (hashMap.size > 0) {

                    val evento = Evento(hashMap["name"].toString(), hashMap["address"].toString(), hashMap["description"].toString(), hashMap["dateHour"].toString(), hashMap["price"].toString().toInt(), hashMap["numTickets"].toString().toInt(),hashMap["image"].toString(),hashMap["cordLat"].toString().toDouble() ,hashMap["cordLng"].toString().toDouble(), false, hashMap["ticket"].toString().toLong() )
                        Tab0EventsActivity.event.eventos.add(evento)

                        //postAdapter!!.notifyDataSetChanged()
                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }

}

private fun <E> ArrayList<E>.add(element: Favorito) {

}



