package com.ahclipse.ui.login

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.ahclipse.ui.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_login)

        val sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val loginToken = sharedPref.getString(
            getString(R.string.login_token), null
        )

        if (loginToken != null) {
            // Navigate to allRestaurants
            // End this activity
        }

    }

}