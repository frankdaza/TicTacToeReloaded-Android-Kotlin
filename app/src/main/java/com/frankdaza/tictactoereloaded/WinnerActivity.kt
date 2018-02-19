package com.frankdaza.tictactoereloaded

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_game_board.*

class WinnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        // Get the winner of the game
        val bundle: Bundle = intent.extras
        var winner: Int = bundle.getInt("winner")

        if (winner == 1) {
            tvPlayer.text = getString(R.string.lbl_player1_wins)
        } else if (winner == 2) {
            tvPlayer.text = getString(R.string.lbl_player2_wins)
        } else {
            tvPlayer.text = getString(R.string.lbl_tie)
        }
    }

    /**
     * Clear all the activities from the stack and redirect to the main activity
     *
     * Created by Frank Edward Daza González on Feb 18, 2018
     */
    fun playAgain(view: View) {
        val intent = Intent(view.context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        ContextCompat.startActivity(view.context, intent, null)
    }
}
