package com.example.nutriscan.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.nutriscan.activity.MainActivity
import com.example.nutriscan.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint


class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        nameEditText= findViewById(R.id.etSinInname)
        emailEditText= findViewById(R.id.etSinInEmail)
        passwordEditText= findViewById(R.id.etSinInPassword)
        registerButton= findViewById(R.id.btn_signup)

        registerButton.setOnClickListener{
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            registerUser(name, email, password)
        }
    }
    private fun registerUser(email: String, password: String, nama: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(nama) // Set nama to display name
                        .build()

                    user?.updateProfile(profileUpdates)
                        ?.addOnCompleteListener { updateProfileTask ->
                            if (updateProfileTask.isSuccessful) {
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(
                                    baseContext, "Failed to update user profile.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


}