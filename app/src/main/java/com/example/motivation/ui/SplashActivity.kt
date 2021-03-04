package com.example.motivation.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity() : AppCompatActivity(), View.OnClickListener {

    private val  mSecurityPreferences by lazy { SecurityPreferences(context = applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        buttonSave.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()
        if (name != EMPTY) {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, NAME_ERROR_TEXT, Toast.LENGTH_SHORT).show()
        }
    }

    private companion object {
        private const val EMPTY = ""
        private const val NAME_ERROR_TEXT ="Por favor insira seu nome!"
    }
}

