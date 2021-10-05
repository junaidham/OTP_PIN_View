package com.nextgen.pinview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCustomPinViewActivity.setOnClickListener {
            startActivity(Intent(this, CustomPinViewActivity::class.java))
        }
        btnPinViewKotlin.setOnClickListener {
            startActivity(Intent(this, PinViewKotlinActivity::class.java))
        }

        btnOtpView.setOnClickListener {
            startActivity(Intent(this,OtpViewActivity::class.java))
        }

        btnCustomPinViewActivity2.setOnClickListener {
            startActivity(Intent(this,PinViewActivity::class.java))
        }
    }

}