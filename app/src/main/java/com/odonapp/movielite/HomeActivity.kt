package com.odonapp.movielite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odonapp.movielite.sign.signin.SignInActivity
import com.odonapp.movielite.sign.signup.SignUpPhotoscreenActivity
import com.odonapp.movielite.utils.Preferences
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        preferences = Preferences(this)

        iv_menu3.setOnClickListener {
            finishAffinity()
            preferences.setValues("onboarding", "0")
            preferences.setValues("status","0")
            Toast.makeText(this@HomeActivity,"LogOut",Toast.LENGTH_LONG).show()

            var goSignin = Intent(this@HomeActivity,SignInActivity::class.java)
            startActivity(goSignin)
        }

        imageView5.setOnClickListener {
//            preferences.setValues("status","0")
//            Toast.makeText(this@HomeActivity,"test",Toast.LENGTH_LONG).show()
            var goUpload = Intent(this@HomeActivity, SignUpPhotoscreenActivity::class.java)
            startActivity(goUpload)
        }
    }
}
