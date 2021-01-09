package com.example.kit3

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class NumberFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_number, container, false)
        val textNum1: TextView = view.findViewById(R.id.num1)
        val textNum2: TextView = view.findViewById(R.id.num2)
        val totalResult: TextView = view.findViewById(R.id.totalView)
        val totalBtn: Button = view.findViewById(R.id.total_btn)

        totalBtn.setOnClickListener {
            totalResult.setText(add(textNum1.text.toString(),textNum2.text.toString()))

        }
        return view
    }

    fun add(n1: String, n2: String): String{
        if (n1.isEmpty() || n2.isEmpty()){
            val dur = Toast.LENGTH_SHORT
            val toast = Toast.makeText(context, R.string.warningNum, dur)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()

            val er: String = ":("
            return er
        }
        else{
            return (n1.toDouble()+n2.toDouble()).toString()
        }
    }
}