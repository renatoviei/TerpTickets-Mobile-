package com.exercise.elal.prototipodetelas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_tab_event.*
import model.Favorito

class Tab2FavoritesActivity : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.favoritos_fragment, container, false)
        val recyclerView = view.findViewById(R.id.recycler) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)


        val favList = ArrayList<Favorito>()
        val favoriteList = Tab0EventsActivity.Event.favoritos

        Tab0EventsActivity.Event.favoritos.clear()
        if(Tab0EventsActivity.Event.eventos.isNotEmpty()){
            Tab0EventsActivity.Event.eventos.filterTo(Tab0EventsActivity.Event.favoritos) { it.favorite == true }
        }
        for (i in favoriteList){
            favList.add(Favorito(i.name, i.address, i.description, i.numTickets, i.dateHour, i.image))
        }

        recyclerView.adapter = ViewPagerAdapter(favList)
        return view

    }
    override fun onStart() {
        super.onStart()
        val ad = recyclerView?.adapter
        ad?.notifyDataSetChanged()
    }

}