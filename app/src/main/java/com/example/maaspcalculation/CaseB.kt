package com.example.maaspcalculation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CaseB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.case_b)

        val calculateB: Button = findViewById(R.id.calc2)
        calculateB.setOnClickListener {
            val intent = Intent(this, CalculateB::class.java)
            this.startActivity(intent)

        }
    }
}
