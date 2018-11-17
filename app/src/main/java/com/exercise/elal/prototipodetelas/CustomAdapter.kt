package com.exercise.elal.prototipodetelas

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Belal on 6/19/2017.
 */

class CustomAdapter(val eventList: ArrayList<Evento>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lista_eventos, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(eventList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return eventList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(event: Evento) {
            val textViewName = itemView.findViewById(R.id.textView2) as TextView
            val textViewAddress  = itemView.findViewById(R.id.textView3) as TextView
            val imageView  = itemView.findViewById(R.id.imageView) as ImageView
            textViewName.text = event.name
            textViewAddress.text = event.address
        }
    }
}