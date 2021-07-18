package ru.tregubowww.andersen_home_work_2_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CounterActivity : AppCompatActivity() {
    private lateinit var counterTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        counterTextView = findViewById(R.id.counterTextView)
        counterTextView.text = intent.getIntExtra(KEY_COUNTER, 0).toString()
    }

    companion object {
        private const val KEY_COUNTER = "KEY_COUNTER"
    }
}