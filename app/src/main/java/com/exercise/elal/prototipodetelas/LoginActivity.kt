@file:Suppress("DEPRECATION")

package com.exercise.elal.prototipodetelas

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import model.Evento
import model.Usuario
import java.util.*


class LoginActivity : AppCompatActivity(){

    private var mAuth: FirebaseAuth? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")

        val btnLogin = findViewById<Button>(R.id.email_sign_in_button)
        btnLogin.setOnClickListener {view ->
            signIn(view,findViewById<TextView>(R.id.email).text.toString(), findViewById<TextView>(R.id.password).text.toString())
        }

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {view ->
            signUp(view,findViewById<TextView>(R.id.email).text.toString(), findViewById<TextView>(R.id.password).text.toString())
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.login_toolbar_menu, menu)
        return true //super.onCreateOptionsMenu(menu)
    }

    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            val i = Intent(this, TabsHolderActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    fun ClosedRange<Char>.randomString(lenght: Int) =
            (1..lenght)
                    .map { (Random().nextInt(endInclusive.toInt() - start.toInt()) + start.toInt()).toChar() }
                    .joinToString("")

    fun signUp(view: View, email: String, password: String){

        mAuth?.createUserWithEmailAndPassword(email, password)?.addOnCompleteListener { task: Task<AuthResult> ->
            if (task.isSuccessful) {
                val firebaseUser = mAuth?.currentUser!!
                showMessage(view, getString(R.string.textSampleSucess))

                val currentUserDb = mDatabaseReference!!.child(('a'..'z').randomString(10))
                    currentUserDb.child("userID").setValue(email)


                val ingressos: LongArray? = null
                val favoritos: Array<Evento>? = null
                val newUser = Usuario(email, ingressos, favoritos)

                 currentUserDb.setValue(newUser)

            } else {
                showMessage(view, "ERROR 0!")
            }
        }
    }

    fun signIn(view: View, email: String, password: String){
        showMessage(view, getString(R.string.textSampleAuthent))
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mAuth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, TabsHolderActivity::class.java)
                    intent.putExtra("id", mAuth?.currentUser?.email)
                    startActivity(intent)
                } else {
                    showMessage(view, "Error: ${task.exception?.message}")
                }
            }
        }
        else{
            showMessage(view, getString(R.string.textSampleFillFields))
        }
    }


    fun showMessage(view:View, message: String){
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show()
    }

    fun goTelaMenu(v: View) {
        val i = Intent(this, TabsHolderActivity::class.java)
        startActivity(i)
        finish()
    }
}
