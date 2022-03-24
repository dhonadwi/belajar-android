package com.odonapp.movielite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odonapp.movielite.utils.Preferences
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        preferences = Preferences(this)

        imageView5.setOnClickListener {
            preferences.setValues("status","0")
            Toast.makeText(this@HomeActivity,"test",Toast.LENGTH_LONG).show()

        }
    }
}
