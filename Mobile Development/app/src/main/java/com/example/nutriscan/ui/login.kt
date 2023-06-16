package com.example.nutriscan.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.nutriscan.R
import com.example.nutriscan.activity.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPasswordButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        emailEditText = findViewById(R.id.etSinInEmail)
        passwordEditText = findViewById(R.id.etSinInPassword)
        loginButton = findViewById(R.id.btn_login)
        forgotPasswordButton = findViewById(R.id.tvForgotPassword)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            loginUser(email, password)
        }

        forgotPasswordButton.setOnClickListener {
            val email = emailEditText.text.toString()
            sendPasswordResetEmail(email)
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun sendPasswordResetEmail(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Email sent successfully
                    Toast.makeText(
                        baseContext,
                        "Password reset email sent to $email",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Failed to send email
                    Toast.makeText(
                        baseContext,
                        "Failed to send password reset email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
