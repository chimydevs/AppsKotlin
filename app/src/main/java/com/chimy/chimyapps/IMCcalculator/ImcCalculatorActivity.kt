package com.chimy.chimyapps.IMCcalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.chimy.chimyapps.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeigth: Int = 50
    private var currentAge: Int = 20
    private var currentHeigth: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnRestarPeso: FloatingActionButton
    private lateinit var btnSumarPeso: FloatingActionButton
    private lateinit var tvWeigth: TextView
    private lateinit var btnRestarEdad: FloatingActionButton
    private lateinit var btnSumarEdad: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()

    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSumarPeso = findViewById(R.id.btnSumarPeso)
        btnRestarPeso = findViewById(R.id.btnRestarPeso)
        tvWeigth = findViewById(R.id.tvWeigth)
        btnRestarEdad = findViewById(R.id.btnRestarEdad)
        btnSumarEdad = findViewById(R.id.btnSumarEdad)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeigth = df.format(value).toInt()
            tvHeight.text = "$currentHeigth cm"
        }

        btnSumarPeso.setOnClickListener {
            currentWeigth += 1
            setWeigth()
        }
        btnRestarPeso.setOnClickListener {
            currentWeigth -= 1
            setWeigth()
        }

        btnSumarEdad.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnRestarEdad.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            calculateIMC()
        }

    }

    private fun calculateIMC() {
        val imc = currentWeigth / (currentHeigth * currentHeigth)
        Log.i("michiapps","El IMC es: $imc")
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeigth() {
        tvWeigth.text = currentWeigth.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeigth()
        setAge()
    }

}