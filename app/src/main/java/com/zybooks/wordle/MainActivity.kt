package com.zybooks.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

        val guessesField = findViewById<TextView>(R.id.guesses_view)
        val debug_view = findViewById<TextView>(R.id.DEBUG_view_word)
        val getUserInput = findViewById<Button>(R.id.button_user_input) // The button for the user
        val editText = findViewById<EditText>(R.id.editText_user_input) // The text entry for user

        getUserInput.setOnClickListener{
            // pass text to checker
            // use conditional block after 4
            val editTextString = editText.text.toString().uppercase(Locale.getDefault());
            val result = checkGuess(editTextString, wordToGuess)
            checkGuess(editText.text.toString(), wordToGuess)
            guessesField.text = result
            debug_view.text = wordToGuess

        }


        /**
         * Parameters / Fields:
         * wordToGuess : String - the target word the user is trying to guess
         * guess : String - what the user has entered as their guess
         *
         * Returns a String of 'O', '+', and 'X', where:
         * 'O' represents the right letter in the right place
         * '+' represents the right letter in the wrong place
         * 'X' represents a letter not in the target word
         */

    }
    private fun checkGuess(guess: String, wordToGuess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}