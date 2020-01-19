package com.example.maaspcalculation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CaseA : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.case_a)

        val calculateA: Button = findViewById(R.id.calc1)
        calculateA.setOnClickListener {
            val intent = Intent(this, CalculateA::class.java)
            this.startActivity(intent)

        }
    }

}