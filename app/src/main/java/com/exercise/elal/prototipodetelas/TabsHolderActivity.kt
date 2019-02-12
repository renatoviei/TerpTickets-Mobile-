package com.exercise.elal.prototipodetelas

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_tab.*

class TabsHolderActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        mAuth = FirebaseAuth.getInstance()
        val btnLogout = findViewById<Button>(R.id.logout)
        btnLogout.setOnClickListener {signOut()
        }

        val Newbutton = findViewById<Button>(R.id.Newbutton)
        Newbutton.setOnClickListener {goTelaAdd()
        }



        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter // Set up the ViewPager with the sections adapter.

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {

            return when(position){

                0 -> {
                    Tab0EventsActivity()
                }
                1 -> {
                    Tab1MapActivity()
                }
                2 -> {
                    Tab2FavoritesActivity()
                }
                else -> null
            }

        }

        override fun getPageTitle(position: Int): CharSequence? {
            when(position){

                0 -> {
                    return R.string.title_events_frag.toString()
                }
                1 -> {
                    return R.string.title_map_frag.toString()
                }
                2 -> {
                    return R.string.title_favorites_frag.toString()
                }
            }
            return null
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }


    fun signOut(){
        mAuth?.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun goTelaAdd() {
        val i = Intent(this, NewEventActivity::class.java)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_tab, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}
