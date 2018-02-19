package com.frankdaza.tictactoereloaded

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_board.*
import java.util.*

class GameBoardActivity : AppCompatActivity() {

    private var typeOfGame: Int = 1
    private var move: String = "X"
    private var listMovesPlayer1: ArrayList<Int> = ArrayList<Int>()
    private var listMovesPlayer2: ArrayList<Int> = ArrayList<Int>()


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
            var buttonNewId: Int = 0

            when (buttonSelected.id) {
                R.id.button1 -> buttonNewId = 1
                R.id.button2 -> buttonNewId = 2
                R.id.button3 -> buttonNewId = 3
                R.id.button4 -> buttonNewId = 4
                R.id.button5 -> buttonNewId = 5
                R.id.button6 -> buttonNewId = 6
                R.id.button7 -> buttonNewId = 7
                R.id.button8 -> buttonNewId = 8
                R.id.button9 -> buttonNewId = 9
            }

            if (this.typeOfGame == 1) {
                this.listMovesPlayer1.add(buttonNewId)
                var emptyCells: ArrayList<Int> = ArrayList<Int>()

                for (cellId in 1..9) {
                    if (!(this.listMovesPlayer1.contains(cellId) || this.listMovesPlayer2.contains(cellId))) {
                        emptyCells.add(cellId)
                    }
                }

                if (emptyCells.size > 0) {
                    val ramd = Random()
                    val ramdIndex = ramd.nextInt(emptyCells.size)
                    val cellId = emptyCells[ramdIndex]

                    if (this.listMovesPlayer1.size + this.listMovesPlayer2.size < 8) {
                        when (cellId) {
                            1 -> {
                                this.listMovesPlayer2.add(1)
                                button1.isEnabled = false
                                button1.text = "O"
                            }
                            2 -> {
                                this.listMovesPlayer2.add(2)
                                button2.isEnabled = false
                                button2.text = "O"
                            }
                            3 -> {
                                this.listMovesPlayer2.add(3)
                                button3.isEnabled = false
                                button3.text = "O"
                            }
                            4 -> {
                                this.listMovesPlayer2.add(4)
                                button4.isEnabled = false
                                button4.text = "O"
                            }
                            5 -> {
                                this.listMovesPlayer2.add(5)
                                button5.isEnabled = false
                                button5.text = "O"
                            }
                            6 -> {
                                this.listMovesPlayer2.add(6)
                                button6.isEnabled = false
                                button6.text = "O"
                            }
                            7 -> {
                                this.listMovesPlayer2.add(7)
                                button7.isEnabled = false
                                button7.text = "O"
                            }
                            8 -> {
                                this.listMovesPlayer2.add(8)
                                button8.isEnabled = false
                                button8.text = "O"
                            }
                            9 -> {
                                this.listMovesPlayer2.add(9)
                                button9.isEnabled = false
                                button9.text = "O"
                            }
                        }
                    }
                }
                checkWinner(view)
            } else {
                if (this.move == "X") {
                    this.listMovesPlayer1.add(buttonNewId)
                    this.move = "O"
                } else {
                    this.listMovesPlayer2.add(buttonNewId)
                    this.move = "X"
                }
            }
            checkWinner(view)
        }
    }

    /**
     * Check the winner of the game
     *
     * Created by Frank Edward Daza González on Feb 18, 2018
     */
    fun checkWinner(view: View) {
        // Check if the player 1 won
        if (this.listMovesPlayer1.contains(1) && this.listMovesPlayer1.contains(2) && this.listMovesPlayer1.contains(3)
                || this.listMovesPlayer1.contains(4) && this.listMovesPlayer1.contains(5) && this.listMovesPlayer1.contains(6)
                || this.listMovesPlayer1.contains(7) && this.listMovesPlayer1.contains(8) && this.listMovesPlayer1.contains(9)
                || this.listMovesPlayer1.contains(1) && this.listMovesPlayer1.contains(4) && this.listMovesPlayer1.contains(7)
                || this.listMovesPlayer1.contains(2) && this.listMovesPlayer1.contains(5) && this.listMovesPlayer1.contains(8)
                || this.listMovesPlayer1.contains(3) && this.listMovesPlayer1.contains(6) && this.listMovesPlayer1.contains(9)
                || this.listMovesPlayer1.contains(1) && this.listMovesPlayer1.contains(5) && this.listMovesPlayer1.contains(9)
                || this.listMovesPlayer1.contains(3) && this.listMovesPlayer1.contains(5) && this.listMovesPlayer1.contains(7)) {

            val intent = Intent(view.context, WinnerActivity::class.java)
            intent.putExtra("winner", 1)
            ContextCompat.startActivity(view.context, intent, null)
            return
        }

        // Check if the player 2 won
        if (this.listMovesPlayer2.contains(1) && this.listMovesPlayer2.contains(2) && this.listMovesPlayer2.contains(3)
                || this.listMovesPlayer2.contains(4) && this.listMovesPlayer2.contains(5) && this.listMovesPlayer2.contains(6)
                || this.listMovesPlayer2.contains(7) && this.listMovesPlayer2.contains(8) && this.listMovesPlayer2.contains(9)
                || this.listMovesPlayer2.contains(1) && this.listMovesPlayer2.contains(4) && this.listMovesPlayer2.contains(7)
                || this.listMovesPlayer2.contains(2) && this.listMovesPlayer2.contains(5) && this.listMovesPlayer2.contains(8)
                || this.listMovesPlayer2.contains(3) && this.listMovesPlayer2.contains(6) && this.listMovesPlayer2.contains(9)
                || this.listMovesPlayer2.contains(1) && this.listMovesPlayer2.contains(5) && this.listMovesPlayer2.contains(9)
                || this.listMovesPlayer2.contains(3) && this.listMovesPlayer2.contains(5) && this.listMovesPlayer2.contains(7)) {

            val intent = Intent(view.context, WinnerActivity::class.java)
            intent.putExtra("winner", 2)
            ContextCompat.startActivity(view.context, intent, null)
            return
        }

        // Check tie
        if (this.listMovesPlayer1.size + this.listMovesPlayer2.size >= 9) {
            val intent = Intent(view.context, WinnerActivity::class.java)
            intent.putExtra("winner", 0)
            ContextCompat.startActivity(view.context, intent, null)
            return
        } else {
            // Set the turn of the player
            if (this.move == "X")
                tvPlayer.text = getString(R.string.lbl_turn_player_1)
            else
                tvPlayer.text = getString(R.string.lbl_turn_player_2)
        }
    }

}
