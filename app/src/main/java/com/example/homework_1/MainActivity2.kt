package com.example.homework_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_1.databinding.ActivityMain2Binding
import com.example.homework_1.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var bindingClass: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        /////
        val num = intent.getIntExtra(NUM, 0)
        val color = intent.getIntExtra(COLOR, 0)
        bindingClass.textView.text = num.toString()
        bindingClass.cl.setBackgroundResource(color)
        /////



    }


    companion object {
        fun newInstance(context: Context, num: Int, color: Int): Intent {
            return Intent(context, MainActivity2::class.java).apply {
                putExtra(NUM, num)
                putExtra(COLOR, color)

            }
        }

        const val NUM = "EXTRAS_NUM"
        const val COLOR = "EXTRAS_COLOR"
    }
}