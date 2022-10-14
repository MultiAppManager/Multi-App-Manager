package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DiceRoller : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

                val rollButton: Button = findViewById(R.id.button)
                rollButton.setOnClickListener { rollDice() }

                //Do a dice roll when the app starts
                rollDice()
            }

            private fun rollDice() {
                // Create new Dice object with 6 sides and roll it
                val dice = Dice(6)
                val diceRoll = dice.roll()
                val diceImage: ImageView = findViewById(R.id.imageView)

                // Determine which drawable resource ID to use based on the dice roll
                val drawableResource = when(diceRoll){
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> {R.drawable.dice_6}
                }
                //Update the ImageView with the correct drawable resource ID
                diceImage.setImageResource(drawableResource)

                //Update content description
                diceImage.contentDescription = diceRoll.toString()

            }

        }

        //The blueprint of object Dice
        class Dice(private val numSides: Int) {
            fun roll(): Int {
                return (1..numSides).random()
            }
        }