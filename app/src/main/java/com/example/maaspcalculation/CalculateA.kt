package com.example.maaspcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.calculate_a.view.*
import kotlin.math.absoluteValue

class CalculateA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculate_a)

        val MAASP: Button = findViewById(R.id.MAASP)
        val clear: Button = findViewById(R.id.clear)
        val ApointMAASP: TextView = findViewById(R.id.pointMAASP)


        //POINT 1 VARIABLES
        var x1: Double
        var y1: Double
        var z1: Double
        var t1: Double
        var x11: String
        var y11: String
        var z11: String
        var t11: String
        val pcsv: EditText = findViewById(R.id.Ppc_sv)
        val tvdsv: EditText = findViewById(R.id.Dtvd_sv)
        val mga: EditText = findViewById(R.id.MGa)
        val mgtub: EditText = findViewById(R.id.MGtub)
        var point1: Double
        val p1: TextView = findViewById(R.id.point1)


        //POINT 2 VARIABLES
        var x2: Double
        var y2: Double
        var x22: String
        var y22: String
        val pcacc: EditText = findViewById(R.id.Ppc_acc)
        val tvdacc: EditText = findViewById(R.id.Dtvd_acc)
        var point2: Double
        val p2: TextView = findViewById(R.id.point2)


        //POINT 3 VARIABLES
        var x3: Double
        var y3: Double
        var x33: String
        var y33: String
        val pcpp: EditText = findViewById(R.id.Ppc_pp)
        val tvdpp: EditText = findViewById(R.id.Dtvd_pp)
        var point3: Double
        val p3: TextView = findViewById(R.id.point3)


        //POINT 4 VARIABLES
        var x4: Double
        var y4: Double
        var t4: Double
        var x44: String
        var y44: String
        var t44: String
        val splh: EditText = findViewById(R.id.Ppb_lh)
        val tvdlh: EditText = findViewById(R.id.Dtvd_lh)
        val sfs: EditText = findViewById(R.id.Pbf_b)
        var point4: Double
        val p4: TextView = findViewById(R.id.point4)

        val lh: EditText = findViewById(R.id.Plh)
        val fpform: EditText = findViewById(R.id.Pfp_form)
        val form: EditText = findViewById(R.id.Pform)
        val tvdform: EditText = findViewById(R.id.Dtvd_form)
        var stringlh: String
        var stringfpform: String
        var stringform: String
        var stringtvdform: String
        var doublelh: Double
        var doublefpform: Double
        var doubleform: Double
        var doubletvdform: Double
        var point44: Double


        //POINT 5 VARIABLES
        var x5: Double
        var x55: String
        val pct: EditText = findViewById(R.id.Ppc_t)
        var point5: Double
        val p5: TextView = findViewById(R.id.point5)


        //POINT 6 VARIABLES
        var z6: Double
        var t6: Double
        var z66: String
        var t66: String
        val fsa: EditText = findViewById(R.id.Pfs_a)
        val pmga: EditText = findViewById(R.id.Pmg_a)
        var point6: Double
        val p6: TextView = findViewById(R.id.point6)


        //POINT 7A case1 VARIABLES
        var x7A1: Double
        var x77A1: String
        val pss: EditText = findViewById(R.id.Pps_s)
        var point7A1: Double
        val p7A1: TextView = findViewById(R.id.point7A1)


        //POINT 7A case2 VARIABLES
        var point7A2: Double
        val p7A2: TextView = findViewById(R.id.point7A2)

        //POINT 7B VARIABLES
        var t7B: Double
        var t77B: String
        val fp: EditText = findViewById(R.id.Pfp)
        var point7B: Double
        val p7B: TextView = findViewById(R.id.point7B)

        //POINT 8 VARIABLES
        var miyp1: Double
        var miyp2: Double
        var Pyp: Double
        val PGrade: EditText = findViewById(R.id.pgrade)
        val OGrade: EditText = findViewById(R.id.ograde)
        val d: EditText = findViewById(R.id.D)
        val t: EditText = findViewById(R.id.t)
        var d8: Double
        var t8: Double
        val p8: TextView = findViewById(R.id.point8)


        //pressure casing shoe
        val pcs: TextView = findViewById(R.id.pointCs)
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
        val gasgrad: EditText = findViewById(R.id.gg)
        val mudgrad: EditText = findViewById(R.id.mg)
        val cementgrad: EditText = findViewById(R.id.cg)
        val hgas: EditText = findViewById(R.id.hgas)
        val hmud: EditText = findViewById(R.id.hmud)
        val hcement: EditText = findViewById(R.id.hcement)





        MAASP.setOnClickListener {


            //point 8 MAASP*************************************************************************
            var d88: String = d.text.toString()
            var t88: String = t.text.toString()
            val miyp81: String = PGrade.text.toString().drop(1)
            val miyp82: String = OGrade.text.toString().drop(1)
            if (miyp81 == "" || miyp82 == "" || d.text.toString() == "" || t.text.toString() == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p8.setText("error")
            } else {
                d8 = d88.toDouble()
                t8 = t88.toDouble()

                miyp1 = miyp81.toDouble() * 0.5 * 6894 * 1000
                miyp2 = miyp82.toDouble() * 0.8 * 6894 * 1000
                Pyp =
                    2 * miyp81.toDouble() * (((d8 / t8) - 1) / ((d8 / t8) * (d8 / t8))) * 0.75 * 6894 * 1000

                if (miyp1 < miyp2 && miyp1 < Pyp) {
                    p8.setText(miyp1.toString())
                } else if (miyp2 < miyp1 && miyp2 < Pyp) {
                    p8.setText(miyp2.toString())
                } else if (Pyp < miyp1 && Pyp < miyp2){
                    p8.setText(Pyp.toString())
                }
            }


            // point 1 MAASP************************************************************************
            x11 = pcsv.text.toString()
            y11 = tvdsv.text.toString()
            z11 = mga.text.toString()
            t11 = mgtub.text.toString()

            if (x11 == "" || y11 == "" || z11 == "" || t11 == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p1.setText("error")
            } else {
                x1 = x11.toDouble()
                y1 = y11.toDouble()
                z1 = z11.toDouble()
                t1 = t11.toDouble()
                point1 = x1 - (y1 * (z1 - t1))
                p1.setText(point1.toString())
            }


            //point 2 Maasp*************************************************************************
            x22 = pcacc.text.toString()
            y22 = tvdacc.text.toString()

            if (x22 == "" || y22 == "" || z11 == "" || t11 == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p2.setText("error")
            } else {
                x2 = x22.toDouble()
                y2 = y22.toDouble()
                z1 = z11.toDouble()
                t1 = t11.toDouble()
                point2 = x2 - (y2 * (z1 - t1))
                p2.setText(point2.toString())
            }


            //point 3 MAASP*************************************************************************
            x33 = pcpp.text.toString()
            y33 = tvdpp.text.toString()

            if (x33 == "" || y33 == "" || z11 == "" || t11 == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p3.setText("error")
            } else {
                x3 = x33.toDouble()
                y3 = y33.toDouble()
                z1 = z11.toDouble()
                t1 = t11.toDouble()
                point3 = x3 - (y3 * (z1 - t1))
                p3.setText(point3.toString())
            }


            //point 4 MAASP*************************************************************************
            x44 = splh.text.toString()
            y44 = tvdlh.text.toString()
            t44 = sfs.text.toString()
            stringlh = lh.text.toString()
            stringfpform = fpform.text.toString()
            stringform = form.text.toString()
            stringtvdform = tvdform.text.toString()

            if (x44 == "" || y44 == "" || z11 == "" || t44 == "" || stringlh == "" || stringfpform == "" || stringform == "" || stringtvdform == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p4.setText("error")
            } else {
                x4 = x44.toDouble()
                y4 = y44.toDouble()
                z1 = z11.toDouble()
                t4 = t44.toDouble()
                doublelh = stringlh.toDouble()
                doublefpform = stringfpform.toDouble()
                doubleform = stringform.toDouble()
                doubletvdform = stringtvdform.toDouble()
                point4 = x4 - (y4 * (z1 - t4))
                point44 =
                    doublelh + (y4 * (doublefpform - z1)) - (doubleform * (doubletvdform - t4))

                if (point4 < point44) {
                    p4.setText(point4.toString())
                } else {
                    p4.setText(point44.toString())
                }

            }

            //point 5 MAASP*************************************************************************
            x55 = pct.text.toString()

            if (x55 == "" || y33 == "" || z11 == "" || t11 == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p5.setText("error")
            } else {
                x5 = x55.toDouble()
                y3 = y33.toDouble()
                z1 = z11.toDouble()
                t1 = t11.toDouble()
                point5 = x5 - (y3 * (z1 - t1))
                p5.setText(point5.toString())
            }


            //point 6 MAASP*************************************************************************
            z66 = fsa.text.toString()
            t66 = pmga.text.toString()


            if (y33 == "" || z66 == "" || t66 == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p6.setText("error")
            } else {
                z6 = z66.toDouble()
                t6 = t66.toDouble()
                y3 = y33.toDouble()
                point6 = y3 * (z6 - t6)
                p6.setText(point6.toString())
            }


            //point 7A1 MAASP***********************************************************************
            x77A1 = pss.text.toString()


            if (x77A1 == "" || y33 == "" || z11 == "" || t44 == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p7A1.setText("error")
            } else {
                x7A1 = x77A1.toDouble()
                y3 = y33.toDouble()
                t4 = t44.toDouble()
                z1 = z11.toDouble()
                point7A1 = x7A1 - (y3 * (z1 - t4))
                p7A1.setText(point7A1.toString())
            }


            //point 7A2 MAASP***********************************************************************
            if (x77A1 == "" || y44 == "" || z11 == "" || t44 == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p7A2.setText("error")
            } else {
                x7A1 = x77A1.toDouble()
                y4 = y44.toDouble()
                t4 = t44.toDouble()
                z1 = z11.toDouble()
                point7A2 = x7A1 - (y4 * (z1 - t4))
                p7A2.setText(point7A2.toString())
            }


            //point 7B MAASP************************************************************************
            t77B = fp.text.toString()

            if (x77A1 == "" || y33 == "" || z11 == "" || t77B == "") {
                Toast.makeText(this, "Please, assign value to all variables", Toast.LENGTH_LONG)
                    .show()
                p7B.setText("error")
            } else {
                x7A1 = x77A1.toDouble()
                y3 = y33.toDouble()
                t7B = t77B.toDouble()
                z1 = z11.toDouble()
                point7B = x7A1 - (y3 * (z1 - t7B))
                p7B.setText(point7B.toString())
            }


            //PMAASP********************************************************************************
            if (p1.text.toString() == "error" ||
                p2.text.toString() == "error" ||
                p3.text.toString() == "error" ||
                p4.text.toString() == "error" ||
                p5.text.toString() == "error" ||
                p6.text.toString() == "error" ||
                p7A1.text.toString() == "error" ||
                p7A2.text.toString() == "error" ||
                p7B.text.toString() == "error" ||
                p8.text.toString() == "error")
            {
                ApointMAASP.setText("error")
            }
            else if (p1.text.toString().toDouble() < p2.text.toString().toDouble() &&
                p1.text.toString().toDouble() < p3.text.toString().toDouble() &&
                p1.text.toString().toDouble() < p4.text.toString().toDouble() &&
                p1.text.toString().toDouble() < p5.text.toString().toDouble() &&
                p1.text.toString().toDouble() < p6.text.toString().toDouble() &&
                p1.text.toString().toDouble() < p7A1.text.toString().toDouble() &&
                p1.text.toString().toDouble() < p7A2.text.toString().toDouble() &&
                p1.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p1.text.toString().toDouble() < p8.text.toString().toDouble())
            {
                ApointMAASP.setText(p1.text.toString())
            }
            else if (p2.text.toString().toDouble() < p1.text.toString().toDouble() &&
                p2.text.toString().toDouble() < p3.text.toString().toDouble() &&
                p2.text.toString().toDouble() < p4.text.toString().toDouble() &&
                p2.text.toString().toDouble() < p5.text.toString().toDouble() &&
                p2.text.toString().toDouble() < p6.text.toString().toDouble() &&
                p2.text.toString().toDouble() < p7A1.text.toString().toDouble() &&
                p2.text.toString().toDouble() < p7A2.text.toString().toDouble() &&
                p2.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p2.text.toString().toDouble() < p8.text.toString().toDouble())
            {
                ApointMAASP.setText(p2.text.toString())
            }
            else if (p3.text.toString().toDouble() < p2.text.toString().toDouble() &&
                p3.text.toString().toDouble() < p1.text.toString().toDouble() &&
                p3.text.toString().toDouble() < p4.text.toString().toDouble() &&
                p3.text.toString().toDouble() < p5.text.toString().toDouble() &&
                p3.text.toString().toDouble() < p6.text.toString().toDouble() &&
                p3.text.toString().toDouble() < p7A1.text.toString().toDouble() &&
                p3.text.toString().toDouble() < p7A2.text.toString().toDouble() &&
                p3.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p3.text.toString().toDouble() < p8.text.toString().toDouble())
            {
                ApointMAASP.setText(p3.text.toString())
            }
            else if (p4.text.toString().toDouble() < p2.text.toString().toDouble() &&
                p4.text.toString().toDouble() < p3.text.toString().toDouble() &&
                p4.text.toString().toDouble() < p1.text.toString().toDouble() &&
                p4.text.toString().toDouble() < p5.text.toString().toDouble() &&
                p4.text.toString().toDouble() < p6.text.toString().toDouble() &&
                p4.text.toString().toDouble() < p7A1.text.toString().toDouble() &&
                p4.text.toString().toDouble() < p7A2.text.toString().toDouble() &&
                p4.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p4.text.toString().toDouble() < p8.text.toString().toDouble())
            {
                ApointMAASP.setText(p4.text.toString())
            }
            else if (p5.text.toString().toDouble() < p2.text.toString().toDouble() &&
                p5.text.toString().toDouble() < p3.text.toString().toDouble() &&
                p5.text.toString().toDouble() < p1.text.toString().toDouble() &&
                p5.text.toString().toDouble() < p4.text.toString().toDouble() &&
                p5.text.toString().toDouble() < p6.text.toString().toDouble() &&
                p5.text.toString().toDouble() < p7A1.text.toString().toDouble() &&
                p5.text.toString().toDouble() < p7A2.text.toString().toDouble() &&
                p5.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p5.text.toString().toDouble() < p8.text.toString().toDouble())
            {
                ApointMAASP.setText(p5.text.toString())
            }
            else if (p6.text.toString().toDouble() < p2.text.toString().toDouble() &&
                p6.text.toString().toDouble() < p3.text.toString().toDouble() &&
                p6.text.toString().toDouble() < p4.text.toString().toDouble() &&
                p6.text.toString().toDouble() < p5.text.toString().toDouble() &&
                p6.text.toString().toDouble() < p1.text.toString().toDouble() &&
                p6.text.toString().toDouble() < p7A1.text.toString().toDouble() &&
                p6.text.toString().toDouble() < p7A2.text.toString().toDouble() &&
                p6.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p6.text.toString().toDouble() < p8.text.toString().toDouble())
            {
                ApointMAASP.setText(p6.text.toString())
            }
            else if (p7A1.text.toString().toDouble() < p2.text.toString().toDouble() &&
                p7A1.text.toString().toDouble() < p3.text.toString().toDouble() &&
                p7A1.text.toString().toDouble() < p4.text.toString().toDouble() &&
                p7A1.text.toString().toDouble() < p5.text.toString().toDouble() &&
                p7A1.text.toString().toDouble() < p6.text.toString().toDouble() &&
                p7A1.text.toString().toDouble() < p1.text.toString().toDouble() &&
                p7A1.text.toString().toDouble() < p7A2.text.toString().toDouble() &&
                p7A1.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p7A1.text.toString().toDouble() < p8.text.toString().toDouble())
            {
                ApointMAASP.setText(p7A1.text.toString())
            }
            else if (p7A2.text.toString().toDouble() < p2.text.toString().toDouble() &&
                p7A2.text.toString().toDouble() < p3.text.toString().toDouble() &&
                p7A2.text.toString().toDouble() < p4.text.toString().toDouble() &&
                p7A2.text.toString().toDouble() < p5.text.toString().toDouble() &&
                p7A2.text.toString().toDouble() < p6.text.toString().toDouble() &&
                p7A2.text.toString().toDouble() < p7A1.text.toString().toDouble() &&
                p7A2.text.toString().toDouble() < p1.text.toString().toDouble() &&
                p7A2.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p7A2.text.toString().toDouble() < p8.text.toString().toDouble())
            {
                ApointMAASP.setText(p7A2.text.toString())
            }
            else if (p8.text.toString().toDouble() < p2.text.toString().toDouble() &&
                p8.text.toString().toDouble() < p3.text.toString().toDouble() &&
                p8.text.toString().toDouble() < p4.text.toString().toDouble() &&
                p8.text.toString().toDouble() < p5.text.toString().toDouble() &&
                p8.text.toString().toDouble() < p6.text.toString().toDouble() &&
                p8.text.toString().toDouble() < p7A1.text.toString().toDouble() &&
                p8.text.toString().toDouble() < p7A2.text.toString().toDouble() &&
                p8.text.toString().toDouble() < p7B.text.toString().toDouble() &&
                p8.text.toString().toDouble() < p1.text.toString().toDouble())
            {
                ApointMAASP.setText(p8.text.toString())
            }


            //pressure casing shoe
            sgg = gasgrad.text.toString()
            smg = mudgrad.text.toString()
            scg = cementgrad.text.toString()
            shg = hgas.text.toString()
            shm = hmud.text.toString()
            shc = hcement.text.toString()


            if (sgg == "" || smg == "" || scg == "" || shg == "" || shm == "" || shc == "" || ApointMAASP.text.toString() == "") {
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

                pressure = ApointMAASP.text.toString().toDouble() + (gg * hg) + (mg * hm) + (cg * hc)

                pcs.setText(pressure.toString())
            }
        }

            clear.setOnClickListener {
                Toast.makeText(this, "Done!", Toast.LENGTH_LONG).show()
                pcsv.setTag("")
                tvdsv.setText("")
                mga.setText("")
                mgtub.setText("")

                pcacc.setText("")
                tvdacc.setText("")

                pcpp.setText("")
                tvdpp.setText("")

                splh.setText("")
                tvdlh.setText("")
                sfs.setText("")

                pct.setText("")

                fsa.setText("")
                pmga.setText("")

                pss.setText("")

                fp.setText("")

            }




    }

}