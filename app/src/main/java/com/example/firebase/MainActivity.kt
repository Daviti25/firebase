package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firebase.R
import com.example.firebase.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class MainActivity : AppCompatActivity() {
    private lateinit var mailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var createButton: Button
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mailEditText = findViewById(R.id.editTextTextPersonName2)
        passwordEditText = findViewById(R.id.editTextTextPersonName3)
        createButton = findViewById(R.id.button)

        createButton.setOnClickListener {
            val mail = mailEditText.text.toString()
            val password = passwordEditText.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users:")
            val user = User(mail,password)
            database.child(mail).setValue(user).addOnSuccessListener {

                Toast.makeText(this, "წარმატებით შეიქმნა", Toast.LENGTH_SHORT).show()
            }



        }



    }
}