package com.exercise.elal.prototipodetelas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import model.Favorito

class Tab2FavoritesActivity : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.favoritos_fragment, container, false)
        val recyclerView = view.findViewById(R.id.recycler) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

        val favoritos = ArrayList<Favorito>()
        favoritos.add(Favorito("Samba", "Evento de samba mt doido"))
        favoritos.add(Favorito("Pagode", "Pagodao da massa"))
        favoritos.add(Favorito("Funk", "Funk 150bpm"))

        recyclerView.adapter = ViewPagerAdapter(favoritos)
        return view
    }

}