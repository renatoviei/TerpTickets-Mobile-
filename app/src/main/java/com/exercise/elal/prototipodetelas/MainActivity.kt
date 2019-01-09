package com.exercise.elal.prototipodetelas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/terptickets-3c6ca.appspot.com/o/terp_logo.png?alt=media&token=4adaf08f-30bc-4950-af7e-fa07341e933c").into(imageView)

        val background = object : Thread(){
            override fun run() {
                try {
                    Thread.sleep(3500)

                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                finally {
                    finish()
                }
            }
        }
        background.start()
    }

    fun goTelaLogin(v : View){
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()
    }

    fun goTelaMenu(v : View){
        val i = Intent(this, TabsHolderActivity::class.java)
        startActivity(i)
        finish()
    }
}
