package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val mSecurityPreferences by lazy { SecurityPreferences(context = applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

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
            }
            R.id.happyPhrase -> {
                happyPhrase.setColorFilter(resources.getColor(R.color.colorAccent))
            }
            R.id.morningPhrase -> {
                morningPhrase.setColorFilter(resources.getColor(R.color.colorAccent))

            }
        }
    }

    private fun handleNewPhrase() {
        //TODO
    }
}
