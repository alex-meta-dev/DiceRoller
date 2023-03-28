package com.example.diceroller

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


var playerScoreGlobal = 0
var pcScoreGlobal = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

        }
    }

    private fun rollDice() {


        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.ResultTextView)
        resultTextView.text = diceRoll.toString()

        val diceImage: ImageView = findViewById(R.id.imageView)
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        val dicePC = Dice(6)
        val diceRollPC = dicePC.roll()
        val  pcResultTextView: TextView = findViewById(R.id.PcResultTextView)
        pcResultTextView.text = diceRollPC.toString()

        val diceImagePC: ImageView = findViewById(R.id.imageView2)
        when (diceRollPC) {
            1 -> diceImagePC.setImageResource(R.drawable.dice_1)
            2 -> diceImagePC.setImageResource(R.drawable.dice_2)
            3 -> diceImagePC.setImageResource(R.drawable.dice_3)
            4 -> diceImagePC.setImageResource(R.drawable.dice_4)
            5 -> diceImagePC.setImageResource(R.drawable.dice_5)
            6 -> diceImagePC.setImageResource(R.drawable.dice_6)
        }

        checkResults(diceRoll, diceRollPC)
        updateScoreUI()
    }

    private fun checkResults(humanScore: Int, pcScore: Int) {
        val messageTextView: TextView = findViewById(R.id.textViewMessage)
        val humanWinText = "You won!"
        val humanLoseText = "You lost! Try again!"
        val drawText = "It's a draw!"
        if (humanScore > pcScore) {
            messageTextView.text = humanWinText
            messageTextView.setTextColor(Color.parseColor("#3F51B5"))
            playerScoreGlobal += 1
        }
        else if (humanScore == pcScore) {
            messageTextView.text = drawText
        }
        else {
            messageTextView.text = humanLoseText
            messageTextView.setTextColor(Color.parseColor("#E91E63"))
            pcScoreGlobal += 1
        }

    }

    private fun updateScoreUI() {
        val playerScore: TextView = findViewById(R.id.pScoretextView)
        playerScore.text = playerScoreGlobal.toString()

        val pcScore: TextView = findViewById(R.id.textView5)
        pcScore.text = pcScoreGlobal.toString()
    }

}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
