package com.exercise.elal.prototipodetelas

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import model.Evento

/**
 * Created by Belal on 6/19/2017.
 */

class CustomAdapter(val eventList: ArrayList<Evento>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lista_eventos, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(eventList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return eventList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(event: Evento) {
            val textViewName = itemView.findViewById(R.id.eventName) as TextView
            val textViewAddress  = itemView.findViewById(R.id.locationName) as TextView
            val imageView  = itemView.findViewById(R.id.eventImage) as ImageView
            textViewName.text = event.name
            textViewAddress.text = event.address
            val detalhes = itemView.findViewById(R.id.detalhes) as Button?


            detalhes?.setOnClickListener{
                val i = Intent(itemView.context, DetalheActivity::class.java)
                itemView.context.startActivity(i)
            }
        }


    }

}