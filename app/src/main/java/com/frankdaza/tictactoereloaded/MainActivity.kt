package com.frankdaza.tictactoereloaded

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Go to the GameBoard activity, and set the type of game with 1,
     * that's mean, that player 1 will play with the machine.
     *
     * Created by Frank Edward Daza González on Feb 18, 2018
     */
    fun action_player_1(view: View) {
        val intent = Intent(view.context, GameBoardActivity::class.java)
        intent.putExtra("typeOfGame", "1")
        ContextCompat.startActivity(view.context, intent, null)
    }

    /**
     * Go to the GameBoard activity, and set the type of game with 2,
     * that's mean, that player 1 will play with the player 2.
     *
     * Created by Frank Edward Daza González on Feb 18, 2018
     */
    fun action_player_2(view: View) {
        val intent = Intent(view.context, GameBoardActivity::class.java)
        intent.putExtra("typeOfGame", "2")
        ContextCompat.startActivity(view.context, intent, null)
    }

}
