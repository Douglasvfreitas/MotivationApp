package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mSecurityPreferences by lazy { SecurityPreferences(context = applicationContext) }

    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        allPhrase.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewPhrase()

        buttonNewPhase.setOnClickListener(this)
        allPhrase.setOnClickListener(this)
        happyPhrase.setOnClickListener(this)
        morningPhrase.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(R.id.allPhrase, R.id.happyPhrase, R.id.morningPhrase)

        if (id == R.id.buttonNewPhase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

        allPhrase.setColorFilter(resources.getColor(R.color.white))
        happyPhrase.setColorFilter(resources.getColor(R.color.white))
        morningPhrase.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            R.id.allPhrase -> {
                allPhrase.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.happyPhrase -> {
                happyPhrase.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.morningPhrase -> {
                morningPhrase.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }
    }

    private fun handleNewPhrase() {
        textPhrase.text = Mock().getPhrase(mPhraseFilter)
    }
}
