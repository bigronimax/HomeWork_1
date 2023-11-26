package com.example.homework_1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework_1.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private val adapter = ElemAdapter()
    private var num = 0
    private var color = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        init()
    }

    private fun init() {
        bindingClass.apply {
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            else
                rcView.layoutManager = GridLayoutManager(this@MainActivity, 4)


            rcView.adapter = adapter
            btn.setOnClickListener {
                num++
                if (num % 2 == 0) {
                    color = R.color.red
                }
                else {
                    color = R.color.blue
                }
                val elem = Elem(num, color)
                adapter.addElem(elem)

            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("num", num)
        outState.putInt("color", num)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        num = savedInstanceState.getInt("num")
        color = savedInstanceState.getInt("color")

        bindingClass.apply {


            rcView.adapter = adapter

            for (n in 1..num) {

                if (n % 2 == 0) {
                    color = R.color.red
                }
                else {
                    color = R.color.blue
                }

                val elem = Elem(n, color)
                adapter.addElem(elem)
            }
        }


    }
}