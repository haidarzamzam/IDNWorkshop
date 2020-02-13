package com.haidev.idnworkshopandroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        //3 second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashActivity, OnBoardingActivity::class.java))
            //finish this activity
            finish()
        }, 3000)

    }
}
