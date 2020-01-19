package com.example.maaspcalculation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CaseC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.case_c)

        val calculateC: Button = findViewById(R.id.calc3)
        calculateC.setOnClickListener {
            val intent = Intent(this, CalculateC::class.java)
            this.startActivity(intent)

        }
    }
}
