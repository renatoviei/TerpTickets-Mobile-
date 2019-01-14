package com.exercise.elal.prototipodetelas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.Toast
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class DetalheActivity : AppCompatActivity() {
    private var alerta: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)
        val nome:String = intent.getStringExtra("NAME")
        val descricao:String = intent.getStringExtra("DESCRIPTION")
        val data:String = intent.getStringExtra("DATE")
        val endereco:String = intent.getStringExtra("ADRESS")
        val imagem:String = intent.getStringExtra("IMAGE")

        val textViewName = findViewById(R.id.eventTitle) as TextView
        val textViewAddress  = findViewById(R.id.localizacao) as TextView
        val textViewDate  = findViewById(R.id.data_hora) as TextView
        val textViewDescription  = findViewById(R.id.eventDetail) as TextView
        val imageView = findViewById(R.id.eventImg) as ImageView

        textViewName.text = nome
        textViewAddress.text = endereco
        textViewDate.text = data
        textViewDescription.text = descricao
        Glide.with(this).load(imagem).into(imageView)

        val detalhes = findViewById(R.id.btnReservar) as Button?


        detalhes?.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            //define o titulo
            builder.setTitle("Confirmar Reserva")
            //define a mensagem
            builder.setMessage("Deseja confirmar a reserva para esse evento?")
            //define um botão como positivo
            builder.setPositiveButton("Sim") { arg0, arg1 -> Toast.makeText(this, "Reserva Efetuada", Toast.LENGTH_SHORT).show()
            this.finish()
            }
            //define um botão como negativo.
            builder.setNegativeButton("Não") {
                arg0, arg1 -> Toast.makeText(this, "Reserva Cancelada", Toast.LENGTH_SHORT).show()

               //this.finish()
            }
            //cria o AlertDialog
            alerta = builder.create()
            //Exibe
            alerta?.show()
        }

        val image = findViewById(R.id.imageView3) as ImageView?

        image?.setOnClickListener {
            this.finish()
        }

    }
}
