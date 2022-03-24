package com.odonapp.movielite.onboarding

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odonapp.movielite.R
import com.odonapp.movielite.sign.signin.SignInActivity
import com.odonapp.movielite.utils.Preferences
import kotlinx.android.synthetic.main.activity_onboarding_one.*

class OnboardingOneActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        preferences = Preferences(this)

        if(preferences.getValues("onboarding").equals("1")) {
            finishAffinity()
            var signin = Intent(this@OnboardingOneActivity,SignInActivity::class.java)
            startActivity(signin)
        }

        btn_home.setOnClickListener {
            var intent = Intent(this@OnboardingOneActivity, OnboardingTwoActivity::class.java)
            startActivity(intent)
        }

        btn_daftar.setOnClickListener {
            preferences.setValues("onboarding","1")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity()
            }

            var intent = Intent(this@OnboardingOneActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
