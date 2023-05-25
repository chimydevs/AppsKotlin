package com.chimy.chimyapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.chimy.chimyapps.IMCcalculator.ImcCalculatorActivity
import com.chimy.chimyapps.firstApp.FirstAppActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludapp = findViewById<Button>(R.id.btnSaludapp)
        val btnImcCalculatorActivity = findViewById<Button>(R.id.btnIMCApp)
        btnImcCalculatorActivity.setOnClickListener{navigateToIMCApp()}
        btnSaludapp.setOnClickListener{navigateToSaludapp()}
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludapp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

}