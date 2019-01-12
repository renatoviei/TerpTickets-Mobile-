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

        //carrega favoritos da lista de eventos
        val favoriteList = Tab0EventsActivity.event.favoritos
        for (i in favoriteList){
            favoritos.add(Favorito(i.name, i.address, i.description, i.dateHour))

        }

        
        recyclerView.adapter = ViewPagerAdapter(favoritos)
        return view
    }

}