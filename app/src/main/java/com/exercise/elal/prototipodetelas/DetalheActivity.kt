package com.exercise.elal.prototipodetelas

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

        val textViewName = findViewById<TextView>(R.id.eventTitle)
        val textViewAddress  = findViewById<TextView>(R.id.localizacao)
        val textViewDate  = findViewById<TextView>(R.id.data_hora)
        val textViewDescription  = findViewById<TextView>(R.id.eventDetail)
        val imageView = findViewById<ImageView>(R.id.eventImg)

        textViewName.text = nome
        textViewAddress.text = endereco
        textViewDate.text = data
        textViewDescription.text = descricao
        if(!imagem.isEmpty())
            Glide.with(this).load(imagem).into(imageView)

        val detalhes = findViewById<Button>(R.id.btnReservar)


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

        val image = findViewById<ImageView>(R.id.imageView3)

        image?.setOnClickListener {
            this.finish()
        }

    }
}
