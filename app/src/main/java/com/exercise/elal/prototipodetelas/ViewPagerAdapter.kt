package com.exercise.elal.prototipodetelas

import android.content.Intent
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import model.Favorito

class ViewPagerAdapter (val favoritos: ArrayList<Favorito>): RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.favorito, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return favoritos.size
    }

    override fun onBindViewHolder(p0: ViewPagerAdapter.ViewHolder, p1: Int) {
        p0.bindItems(favoritos[p1])
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindItems(fav : Favorito) {
            val nomeEvento = itemView.findViewById<TextView>(R.id.nomeEvento)
            val descEvento = itemView.findViewById<TextView>(R.id.descEvento)

            //val imageView  = itemView.findViewById(R.id.imageView) as ImageView

            nomeEvento?.text = fav.title
            descEvento?.text = fav.endereco
            val floatingActionButton2 = itemView.findViewById(R.id.floatingActionButton2) as FloatingActionButton

           floatingActionButton2.setOnClickListener{
                val i = Intent(itemView.context, DetalheActivity::class.java)
                i.putExtra("NAME", fav.title)
                i.putExtra("ADRESS", fav.endereco)
                i.putExtra("DATE", fav.dateHour)
                i.putExtra("DESCRIPTION", fav.description)
                i.putExtra("IMAGE", fav.image)
                itemView.context.startActivity(i)
            }
        }
    }

}