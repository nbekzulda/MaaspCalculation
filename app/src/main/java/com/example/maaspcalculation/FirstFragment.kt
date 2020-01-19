package com.example.maaspcalculation


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val case1 : Button = view.findViewById(R.id.CaseA)
        case1.setOnClickListener {
            val intent = Intent(this.context, CaseA::class.java)
            this.context!!.startActivity(intent)
        }

        val case2: Button = view.findViewById(R.id.CaseB)
        case2.setOnClickListener {
            val intent = Intent(this.context, CaseB::class.java)
            this.context!!.startActivity(intent)
        }

        val case3: Button = view.findViewById(R.id.CaseC)
        case3.setOnClickListener {
            val intent = Intent(this.context, CaseC::class.java)
            this.context!!.startActivity(intent)
        }

        val definitions: Button = view.findViewById(R.id.definitions)
        definitions.setOnClickListener {
            val intent = Intent(this.context, Definitions::class.java)
            this.context!!.startActivity(intent)
        }

        return view




    }

    

}
