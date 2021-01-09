package com.example.kit3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private var ifNum: Boolean = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragSlot = findViewById<FrameLayout>(R.id.fragment_holder)
        val btnCh = findViewById<Button>(R.id.btnCh)
        val btnAct = findViewById<Button>(R.id.anAct)

        if(fragSlot!= null){
            setNumFrag()
            btnCh.setOnClickListener{
                if(ifNum)
                    setFragStr()
                else
                    setNumFrag()
            }

            btnAct.setOnClickListener {
                val intent = Intent(this, NextActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun setFrag(fragment: Fragment){
        val manager = supportFragmentManager
        val trans = manager.beginTransaction()
        trans.replace(R.id.fragment_holder, fragment)
        trans.commit()
    }

    fun setFragStr(){
        val fragment = StringFragment()
        setFrag(fragment)
        ifNum = false
    }

    fun setNumFrag(){
        val fragment = NumberFragment()
        setFrag(fragment)
        ifNum = true
    }
}