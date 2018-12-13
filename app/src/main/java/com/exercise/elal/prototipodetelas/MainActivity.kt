package com.exercise.elal.prototipodetelas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
