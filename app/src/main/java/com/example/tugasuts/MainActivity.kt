package com.example.tugasuts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usernameField = findViewById<EditText>(R.id.editEmail)
        val emailField = findViewById<EditText>(R.id.editPhone)
        val firstNameField = findViewById<EditText>(R.id.editFirstName)
        val lastNameField = findViewById<EditText>(R.id.editLastName)
        val passwordField = findViewById<EditText>(R.id.editPassword)
        val confirmPasswordField = findViewById<EditText>(R.id.editConfirmPassword)
        val submitButton = findViewById<Button>(R.id.btnSubmit)

        submitButton.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val firstName = firstNameField.text.toString().trim()
            val lastName = lastNameField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val confirmPassword = confirmPasswordField.text.toString().trim()

            val fields = listOf(username, email, firstName, lastName, password, confirmPassword)

            if (fields.any { it.isBlank() }) {
                Toast.makeText(this, "Semua field input wajib di isi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "User $firstName $lastName telah berhasil di daftarkan",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}