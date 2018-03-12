package com.frankdaza.tictactoereloaded

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var myAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.myAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        loadMain()
    }

    fun listenerLogin(view: View) {
        if (etEmail.text.toString().trim() == "" || etPassword.text.toString().trim() == "") {
            if (etEmail.text.toString().trim() == "")
                etEmail.error = getString(R.string.lbl_field_empty)

            if (etEmail.text.toString().trim() == "")
                etPassword.error = getString(R.string.lbl_field_empty)
        } else {
            loginToFirebase(etEmail.text.toString().trim(), etPassword.text.toString().trim())
        }
    }

    fun loginToFirebase(email: String, password: String) {
        this.myAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, getString(R.string.lbl_success_login), Toast.LENGTH_LONG).show()
                        loadMain()
                    } else {
                        Toast.makeText(this, getString(R.string.lbl_failed_login), Toast.LENGTH_LONG).show()
                    }
                }
    }

    fun loadMain() {
        var currentUser = this.myAuth!!.currentUser
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("email", currentUser!!.email)
        intent.putExtra("uid", currentUser!!.uid)
        startActivity(intent)
    }

}
