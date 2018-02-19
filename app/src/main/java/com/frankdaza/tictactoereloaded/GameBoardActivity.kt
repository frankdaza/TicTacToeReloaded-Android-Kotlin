package com.frankdaza.tictactoereloaded

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class GameBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_board)

        val bundle: Bundle = intent.extras
        Toast.makeText(this, "The type of game is: " + bundle.getString("typeOfGame"), Toast.LENGTH_LONG).show()
    }
}
