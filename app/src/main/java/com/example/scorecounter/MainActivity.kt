package com.example.scorecounter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    // var model: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    private val viewModel: MainActivityViewModel by viewModels() // "by viewModels() substitute the ViewModelProvider and you can use it implementing the Android KTX API

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //if (savedInstanceState != null) {
        //   scoreTeamA = savedInstanceState.getInt("scoreTeamA")
        //   scoreTeamB = savedInstanceState.getInt("scoreTeamB")

            /*Istead of this two line of code use the property "android:freezesText="true"" on the
            xml file. Use this first mentioned property only if the TextView show data saved on the
            bundle created in the onSaveInstanceState() method

            teamAScore_tv.text = scoreTeamA.toString()
            teamBScore_tv.text = scoreTeamB.toString()*/
        //}

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
                viewModel.scoreTeamA += 1
                teamAScore_tv.text = viewModel.scoreTeamA.toString()
            }

            R.id.addScoreB_btn ->{
                viewModel.scoreTeamB += 1
                teamBScore_tv.text = viewModel.scoreTeamB.toString()
            }

            R.id.subScoreA_btn ->{
                viewModel.scoreTeamA -= 1
                teamAScore_tv.text = viewModel.scoreTeamA.toString()
            }

            R.id.subScoreB_btn ->{
                viewModel.scoreTeamB -= 1
                teamBScore_tv.text = viewModel.scoreTeamB.toString()
            }
        }
    }

    /*This Method is commented for training with ViewModel but in this case we should use this instead
    because we need to save only two simple data

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("scoreTeamA", scoreTeamA)
        outState.putInt("scoreTeamB", scoreTeamB)
    }*/

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