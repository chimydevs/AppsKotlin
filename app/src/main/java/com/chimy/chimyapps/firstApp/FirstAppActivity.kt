package com.chimy.chimyapps.firstApp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.chimy.chimyapps.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val editTextName = findViewById<AppCompatEditText>(R.id.etName)

        btnStart.setOnClickListener {
            val name = editTextName.text.toString()

            if (name.isNotEmpty()){
                val intent = Intent (this, resolveActivity::class.java)
                intent.putExtra("extraname", name)
                startActivity(intent)
            }
        }
        //al arrancar la pantalla
    }
}