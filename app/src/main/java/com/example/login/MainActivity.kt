package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.login.databinding.ActivitySingInBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculator1 = findViewById<Button>(R.id.CalculatorButton)
        val AboutComputer1 = findViewById<Button>(R.id.About_Computer)
        val Shortcutkeys1 = findViewById<Button>(R.id.shortcutKey)
        val DiceRoller1 = findViewById<Button>(R.id.DicerollerButton)
        val Stopwatch1 = findViewById<Button>(R.id.Stop_Watch)

        calculator1.setOnClickListener {
            val intent = Intent(this, Calculator::class.java)
            startActivity(intent)
        }
        AboutComputer1.setOnClickListener {
            val intent = Intent(this, AboutComputer::class.java)
            startActivity(intent)
        }
        Shortcutkeys1.setOnClickListener {
            val intent = Intent(this, ShortcutKeys::class.java)
            startActivity(intent)
        }

        DiceRoller1.setOnClickListener {
            val intent = Intent(this, DiceRoller::class.java)
            startActivity(intent)
        }
        Stopwatch1.setOnClickListener {
            val intent = Intent(this, TimerApp::class.java)
            startActivity(intent)
        }


    }
}