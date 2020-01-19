package com.example.maaspcalculation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalculateC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculate_c)

        val MAASP2: Button = findViewById(R.id.MAASP2)
        val clear3: Button = findViewById(R.id.clear3)
        val CpointMAASP: TextView = findViewById(R.id.pointMAASPC)

        //POINT 1 VARIABLES
        var x1: Double
        var y1: Double
        var z1: Double
        var x11: String
        var y11: String
        var z11: String
        val tvdshb: EditText = findViewById(R.id.Dtvd_sh_b)
        val pfsb: EditText = findViewById(R.id.Pfs_b)
        val pmgb: EditText = findViewById(R.id.Pmg_b)
        var point1: Double
        val p1: TextView = findViewById(R.id.point1c)


        //POINT 2 VARIABLES
        var x2: Double
        var y2: Double
        var z2: Double
        var t2: Double
        var x22: String
        var y22: String
        var z22: String
        var t22: String
        val pca: EditText = findViewById(R.id.Ppc_a)
        val tvdtoc: EditText = findViewById(R.id.Dtvd_toc)
        val mgb: EditText = findViewById(R.id.MGb)
        val mga: EditText = findViewById(R.id.MGa)
        var point2: Double
        val p2: TextView = findViewById(R.id.point2c)


        //POINT 3 VARIABLES
        var x3: Double
        var y3: Double
        var t3: Double
        var x33: String
        var y33: String
        var t33: String
        val pcb: EditText = findViewById(R.id.Ppc_b)
        val tvdsh: EditText = findViewById(R.id.Dtvd_sh)
        val bfc: EditText = findViewById(R.id.Pbf_c)
        var point3: Double
        val p3: TextView = findViewById(R.id.point3c)

        //POINT 4 VARIABLES
        var miyp1: Double
        var miyp2: Double
        var Pyp: Double
        val PGrade: EditText = findViewById(R.id.pgradeC)
        val OGrade: EditText = findViewById(R.id.ogradeC)
        val d: EditText = findViewById(R.id.DC)
        val t: EditText = findViewById(R.id.tC)
        var d8: Double
        var t8: Double
        val p4: TextView = findViewById(R.id.point4c)

        //pressure casing shoe
        val pcs: TextView = findViewById(R.id.pointCsC)
        var pressure: Double
        var gg: Double
        var mg: Double
        var cg: Double
        var hg: Double
        var hm: Double
        var hc: Double
        var sgg: String
        var smg: String
        var scg: String
        var shg: String
        var shm: String
        var shc: String
        val gasgrad: EditText = findViewById(R.id.ggC)
        val mudgrad: EditText = findViewById(R.id.mgC)
        val cementgrad: EditText = findViewById(R.id.cgC)
        val hgas: EditText = findViewById(R.id.hgasC)
        val hmud: EditText = findViewById(R.id.hmudC)
        val hcement: EditText = findViewById(R.id.hcementC)


        MAASP2.setOnClickListener {

            var d88: String = d.text.toString()
            var t88: String = t.text.toString()
            val miyp81: String = PGrade.text.toString().drop(1)
            val miyp82: String = OGrade.text.toString().drop(1)
            if (miyp81 == "" || miyp82 == "" || d.text.toString() == "" || t.text.toString() == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p4.setText("error")
            } else {
                d8 = d88.toDouble()
                t8 = t88.toDouble()


                miyp2 = miyp82.toDouble() * 0.3 * 6894 * 1000
                Pyp = 2 * miyp81.toDouble() * (((d8 / t8) - 1) / ((d8 / t8) * (d8 / t8))) * 0.75 * 6894 * 1000

                if (miyp2 < Pyp) {
                    p4.setText(miyp2.toString())
                }
                else if (Pyp < miyp2){
                    p4.setText(Pyp.toString())
                }
                else{
                    p4.setText(miyp2.toString())
                }
            }

            //point 1 MAASP*************************************************************************
            x11 = tvdshb.text.toString()
            y11 = pfsb.text.toString()
            z11 = pmgb.text.toString()

            if(x11 == "" || y11 == "" || z11 == ""){
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG ).show()
                p1.setText("error")
            }
            else {
                x1 = x11.toDouble()
                y1 = y11.toDouble()
                z1 = z11.toDouble()

                point1 = x1 * (y1 - z1)
                p1.setText(point1.toString())
            }


            //point 2 MAASP*************************************************************************
            x22 = pca.text.toString()
            y22 = tvdtoc.text.toString()
            z22 = mgb.text.toString()
            t22 = mga.text.toString()

            if(x22 == "" || y22 == "" || z22 == "" || t22 == ""){
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG ).show()
                p2.setText("error")
            }
            else {
                x2 = x22.toDouble()
                y2 = y22.toDouble()
                z2 = z22.toDouble()
                t2 = t22.toDouble()

                point2 = x2 - (y2 * (z2 - t2))
                p2.setText(point2.toString())
            }


            //point 3 MAASP*************************************************************************
            x33 = pcb.text.toString()
            y33 = tvdsh.text.toString()
            t33 = bfc.text.toString()

            if(x33 == "" || y33 == "" || z22 == "" || t33 == ""){
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG ).show()
                p3.setText("error")
            }
            else {
                x3 = x33.toDouble()
                y3 = y33.toDouble()
                z2 = z22.toDouble()
                t3 = t33.toDouble()

                point3 = x3 - (y3 * (z2 - t3))
                p3.setText(point3.toString())
            }

            if (p1.text.toString() == "error" || p2.text.toString()== "error" || p3.text.toString() == "error" || p4.text.toString() == "error"){
                CpointMAASP.setText("error")
            }
            else if(p1.text.toString().toDouble() < p2.text.toString().toDouble() && p1.text.toString().toDouble() < p2.text.toString().toDouble() && p1.text.toString().toDouble() < p4.text.toString().toDouble()){
                CpointMAASP.setText(p1.text.toString())
            }
            else if (p2.text.toString().toDouble() < p1.text.toString().toDouble() && p2.text.toString().toDouble() < p3.text.toString().toDouble() && p2.text.toString().toDouble() < p4.text.toString().toDouble()){
                CpointMAASP.setText(p2.text.toString())
            }
            else if (p3.text.toString().toDouble() < p1.text.toString().toDouble() && p3.text.toString().toDouble() < p2.text.toString().toDouble() && p3.text.toString().toDouble() < p4.text.toString().toDouble()){
                CpointMAASP.setText(p3.text.toString())
            }
            else if (p4.text.toString().toDouble() < p1.text.toString().toDouble() && p4.text.toString().toDouble() < p2.text.toString().toDouble() && p4.text.toString().toDouble() < p3.text.toString().toDouble()){
                CpointMAASP.setText(p4.text.toString())
            }


            // pressure
            sgg = gasgrad.text.toString()
            smg = mudgrad.text.toString()
            scg = cementgrad.text.toString()
            shg = hgas.text.toString()
            shm = hmud.text.toString()
            shc = hcement.text.toString()


            if (sgg == "" || smg == "" || scg == "" || shg == "" || shm == "" || shc == "" || CpointMAASP.text.toString() == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                pcs.setText("error")
            }
            else {

                gg = sgg.toDouble()
                mg = smg.toDouble()
                cg = scg.toDouble()
                hg = shg.toDouble()
                hm = shm.toDouble()
                hc = shc.toDouble()

                pressure = CpointMAASP.text.toString().toDouble() + (gg * hg) + (mg * hm) + (cg * hc)

                pcs.setText(pressure.toString())
            }
        }



        if(savedInstanceState != null){
            x11 = savedInstanceState.getString("x11")!!
            y11 = savedInstanceState.getString("y11")!!
            z11 = savedInstanceState.getString("z11")!!

            x22 = savedInstanceState.getString("x22")!!
            y22 = savedInstanceState.getString("y22")!!
            z22 = savedInstanceState.getString("z22")!!
            t22 = savedInstanceState.getString("t22")!!

            x33 = savedInstanceState.getString("x33")!!
            y33 = savedInstanceState.getString("y33")!!
            t33 = savedInstanceState.getString("t33")!!
        }

        clear3.setOnClickListener {
            Toast.makeText(this, "Done!", Toast.LENGTH_LONG).show()
            tvdsh.setText("")
            pfsb.setText("")
            pmgb.setText("")

            pca.setText("")
            tvdtoc.setText("")
            mgb.setText("")
            mga.setText("")

            pcb.setText("")
            tvdsh.setText("")
            bfc.setText("")
        }

    }

//    override fun onSaveInstanceState(outState: Bundle?){
//        super.onSaveInstanceState(outState!!)
//
//        outState.putString("x11", tvdshb.text.toString())
//        outState.putString("y11", pfsb.text.toString())
//        outState.putString("z11", pmgb.text.toString())
//
//        outState.putString("x22", pca.text.toString())
//        outState.putString("y22", tvdtoc.text.toString())
//        outState.putString("z22", mgb.text.toString())
//        outState.putString("t22", mga.text.toString())
//
//        outState.putString("x33", pcb.text.toString())
//        outState.putString("y33", tvdsh.text.toString())
//        outState.putString("t33", bfc.text.toString())
//
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        savedInstanceState.getString("x11")
//        savedInstanceState.getString("y11")
//        savedInstanceState.getString("z11")
//
//        savedInstanceState.getString("x22")
//        savedInstanceState.getString("y22")
//        savedInstanceState.getString("z22")
//        savedInstanceState.getString("t22")
//
//        savedInstanceState.getString("x33")
//        savedInstanceState.getString("y33")
//        savedInstanceState.getString("t33")
//
//    }


}
