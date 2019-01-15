package com.exercise.elal.prototipodetelas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import model.Evento

class newEventActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var editTextAddress: EditText
    lateinit var editTextDescription: EditText
    lateinit var editTextDateHour: EditText
    lateinit var editTextPrice: EditText
    lateinit var editTextNumTickets: EditText
    lateinit var editTextImage: EditText
    lateinit var buttonSave: Button
    lateinit var buttonCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_event)

        editTextName = findViewById(R.id.editText_evtNm)
        editTextAddress = findViewById(R.id.editText_evtAdr)
        editTextDescription = findViewById(R.id.editText_evtDesc)
        editTextDateHour = findViewById(R.id.editText_evtDt)
        editTextPrice = findViewById(R.id.editText_evtPrc)
        editTextNumTickets = findViewById(R.id.editText_evtTick)
        editTextImage = findViewById(R.id.editText_evtImg)
        buttonSave = findViewById(R.id.btn_save)
        buttonCancel = findViewById(R.id.btn_cancel)

        buttonSave.setOnClickListener{
            saveEvent()
        }

        buttonCancel.setOnClickListener{
            finish()
        }
    }

    private fun saveEvent(){

        val name = editTextName.text.toString()
        if(name.isEmpty()){
            editTextName.error = "Please enter a name"
            return
        }
        val addres = editTextAddress.text.toString()
        if(addres.isEmpty()){
            editTextAddress.error = "Please enter a address"
            return
        }
        val description = editTextDescription.text.toString()
        if(description.isEmpty()){
            editTextDescription.error = "Please enter a description"
            return
        }
        val dateHour = editTextDateHour.text.toString()
        if(dateHour.isEmpty()){
            editTextDateHour.error = "Please enter a date"
            return
        }
        val price = editTextPrice.text.toString().toInt()
        if(price < 0){
            editTextPrice.error = "Please enter a valid price"
            return
        }
        val numTick = editTextNumTickets.text.toString().toInt()
        if(numTick < 0){
            editTextPrice.error = "Please enter a valid ammount"
            return
        }
        val image = editTextImage.text.toString()
        if(image.isEmpty()){
            editTextImage.error = "Please enter a url"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("Eventos")
        val eventID = ref.push().key.toString()
        val event = Evento(name, addres, description, dateHour, price, numTick, image, -8.017750, -34.944350, false, 123456789)

        ref.child(eventID).setValue(event).addOnCompleteListener {
            Toast.makeText(applicationContext, "Event Saved", Toast.LENGTH_SHORT).show()
        }
    }
}
