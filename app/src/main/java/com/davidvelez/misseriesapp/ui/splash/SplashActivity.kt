package com.davidvelez.misseriesapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidvelez.misseriesapp.R
import com.davidvelez.misseriesapp.databinding.ActivitySignUpBinding
import com.davidvelez.misseriesapp.databinding.ActivitySplashBinding
import com.davidvelez.misseriesapp.ui.signup.SignUpActivity
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.timerTask


class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        val timer = Timer()
        timer.schedule(timerTask {
            val intent = Intent(this@SplashActivity,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)


//        splashBinding.logoImageView.setOnClickListener{
//            val intent = Intent(this,SignUpActivity::class.java)
//            startActivity(intent)
//
//        }

    }


}