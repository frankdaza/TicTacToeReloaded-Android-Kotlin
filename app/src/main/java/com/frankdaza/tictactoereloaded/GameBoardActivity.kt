package com.frankdaza.tictactoereloaded

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_board.*

class GameBoardActivity : AppCompatActivity() {

    private var typeOfGame: Int = 1
    private var move: String = "X"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_board)

        // Get the type of game from the MainActivity
        val bundle: Bundle = intent.extras
        this.typeOfGame = bundle.getInt("typeOfGame")

        // Set player 1 for default
        tvPlayer.text = getString(R.string.lbl_turn_player_1)
    }

    /**
     * Set the value of the move for the player
     *
     * Created by Frank Edward Daza González on Feb 18, 2018
     */
    fun playMove(view: View) {
        val buttonSelected: Button = view as Button

        if (buttonSelected.isEnabled) {
            buttonSelected.text = this.move
            buttonSelected.isEnabled = false

            if (this.typeOfGame == 1) {
                Toast.makeText(view.context, "Missing this functionality", Toast.LENGTH_LONG).show()
            } else {
                if (this.move == "X") {
                    this.move = "O"
                    turnOfPlayer(view)
                } else {
                    this.move = "X"
                    turnOfPlayer(view)
                }
            }
        }
    }

    /**
     * Set the turn of player
     *
     * Created by Frank Edward Daza González on Feb 18, 2018
     */
    fun turnOfPlayer(view: View) {
        if (this.move == "X") {
            tvPlayer.text = getString(R.string.lbl_turn_player_1)
        } else {
            tvPlayer.text = getString(R.string.lbl_turn_player_2)
        }
    }

}
