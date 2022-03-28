package com.odonapp.movielite.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.odonapp.movielite.R
import com.odonapp.movielite.sign.signin.SignInActivity
import com.odonapp.movielite.sign.signup.SignUpPhotoscreenActivity
import com.odonapp.movielite.utils.Preferences
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragmentTicket = TicketFragment()
        val fragmentSetting = SettingFragment()
        val fragmentHome = DashboardFragment()

        setFragment(fragmentHome)

        iv_menu1.setOnClickListener {
            setFragment(fragmentHome)

            changeIcon(iv_menu1, R.drawable.ic_home_active)
            changeIcon(iv_menu2, R.drawable.ic_tiket)
            changeIcon(iv_menu3, R.drawable.ic_profile)
        }

        iv_menu2.setOnClickListener {
            setFragment(fragmentTicket)

            changeIcon(iv_menu1, R.drawable.ic_home)
            changeIcon(iv_menu2, R.drawable.ic_tiket_active)
            changeIcon(iv_menu3, R.drawable.ic_profile)
        }

        iv_menu3.setOnClickListener {
            setFragment(fragmentSetting)

            changeIcon(iv_menu1, R.drawable.ic_home)
            changeIcon(iv_menu2, R.drawable.ic_tiket)
            changeIcon(iv_menu3, R.drawable.ic_profile_active)
        }

//        preferences = Preferences(this)
//
//        iv_menu3.setOnClickListener {
//            finishAffinity()
//            preferences.setValues("onboarding", "0")
//            preferences.setValues("status","0")
//            Toast.makeText(this@HomeActivity,"LogOut",Toast.LENGTH_LONG).show()
//
//            var goSignin = Intent(this@HomeActivity,SignInActivity::class.java)
//            startActivity(goSignin)
//        }
//
//        imageView5.setOnClickListener {
////            preferences.setValues("status","0")
////            Toast.makeText(this@HomeActivity,"test",Toast.LENGTH_LONG).show()
//            var goUpload = Intent(this@HomeActivity, SignUpPhotoscreenActivity::class.java)
//            startActivity(goUpload)
//        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_frame, fragment)
        fragmentTransaction.commit()

    }

    private fun changeIcon(imageView: ImageView, int: Int) {
        imageView.setImageResource(int)
    }
}
