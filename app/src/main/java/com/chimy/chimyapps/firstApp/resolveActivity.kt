package com.chimy.chimyapps.firstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.chimy.chimyapps.R

class resolveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolve)
        val textViewResolve = findViewById<TextView>(R.id.textViewResolve)
        val name: String = intent.extras?.getString("extraname").orEmpty()
        textViewResolve.text = "Hola $name"

    }
}