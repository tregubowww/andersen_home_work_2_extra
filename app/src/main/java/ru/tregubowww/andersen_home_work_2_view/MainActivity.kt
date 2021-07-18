package ru.tregubowww.andersen_home_work_2_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var counterTextView: TextView
    private lateinit var buttonIncrement: Button
    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initClickListeners()

    }

    private fun initClickListeners() {
        counterTextView.setOnClickListener {
            val intent = Intent(this, CounterActivity::class.java)
            intent.putExtra(KEY_COUNTER, counter)
            startActivity(intent)
        }
        buttonIncrement.setOnClickListener {
            counter++
            counterTextView.text = counter.toString()
        }
    }

    private fun initView() {
        counterTextView = findViewById(R.id.counter)
        buttonIncrement = findViewById(R.id.increment)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNTER, counter)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        counter = savedInstanceState.getInt(KEY_COUNTER)
        counterTextView.text = counter.toString()
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        private const val KEY_COUNTER = "KEY_COUNTER"
    }
}