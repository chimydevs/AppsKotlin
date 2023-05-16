package com.chimy.chimyapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.chimy.chimyapps.firstApp.FirstAppActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludapp = findViewById<Button>(R.id.btnSaludapp)
        btnSaludapp.setOnClickListener{navigateToSaludapp()}
    }

    fun navigateToSaludapp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

}