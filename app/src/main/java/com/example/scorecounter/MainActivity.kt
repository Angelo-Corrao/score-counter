package com.example.scorecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt("scoreTeamA")
            scoreTeamB = savedInstanceState.getInt("scoreTeamB")

            /*Istead of this two line of code use the property "android:freezesText="true"" on the
            xml file. Use this first mentioned property only if the TextView show data saved on the
            bundle created in the onSaveInstanceState() method

            teamAScore_tv.text = scoreTeamA.toString()
            teamBScore_tv.text = scoreTeamB.toString()*/
        }

        addScoreA_btn.setOnClickListener {
            updateScore(it.id)
        }

        addScoreB_btn.setOnClickListener {
            updateScore(it.id)
        }

        subScoreA_btn.setOnClickListener {
            updateScore(it.id)
        }

        subScoreB_btn.setOnClickListener {
            updateScore(it.id)
        }
    }

    private fun updateScore(id: Int) {
        when (id) {
            R.id.addScoreA_btn ->{
                scoreTeamA += 1
                teamAScore_tv.text = scoreTeamA.toString()
            }

            R.id.addScoreB_btn ->{
                scoreTeamB += 1
                teamBScore_tv.text = scoreTeamB.toString()
            }

            R.id.subScoreA_btn ->{
                scoreTeamA -= 1
                teamAScore_tv.text = scoreTeamA.toString()
            }

            R.id.subScoreB_btn ->{
                scoreTeamB -= 1
                teamBScore_tv.text = scoreTeamB.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("scoreTeamA", scoreTeamA)
        outState.putInt("scoreTeamB", scoreTeamB)
    }

    /* This method is called after onStart() only when the OS Destroy and then Recreate the activity
    such as when you rotate the phone or when the OS kills your activity in order to free memory and
    then you restart the activity.
    I think it's better to not ovveride this method and restore the state of the activity directly in
    the onCreate() method because it's the first method is called when the activity is created and
    because we could do operations whit the data saved on the bundle created on the onSaveInstanceState()
    method within the onCreate() so it's better to restore the state of the activity as first thing.

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt("SCORE_TEAM_A")
            scoreTeamB = savedInstanceState.getInt("SCORE_TEAM_B")

            teamAScore_tv.text = scoreTeamA.toString()
            teamBScore_tv.text = scoreTeamB.toString()
        }
    }*/
}