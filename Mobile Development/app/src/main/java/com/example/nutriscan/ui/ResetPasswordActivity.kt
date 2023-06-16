package com.example.nutriscan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nutriscan.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var resetButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        auth = Firebase.auth

        emailEditText = findViewById(R.id.etForgotPasswordEmail)
        resetButton = findViewById(R.id.btn_reset)

        resetButton.setOnClickListener {
            val email = emailEditText.text.toString()
            resetPassword(email)
        }
    }

    private fun resetPassword(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Password reset email sent successfully
                    Toast.makeText(
                        baseContext,
                        "Password reset email sent to $email",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Failed to send password reset email
                    Toast.makeText(
                        baseContext,
                        "Failed to send password reset email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
