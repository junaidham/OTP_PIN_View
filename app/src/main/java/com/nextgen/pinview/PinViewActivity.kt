package com.nextgen.pinview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_custom_pin_view.*

/**
 * https://github.com/wayyanminoo/Custom-PinView-Login
 *
 */

class PinViewActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_pin_view4)


        tv_pinOne.text = ""
        tv_pinTwo.text = ""
        tv_pinThree.text = ""
        tv_pinFour.text = ""
        tv_pinFive.text = ""
        tv_pinSix.text = ""

        //setting click event
        setUpClickEvent()
    }


    private fun setUpClickEvent() {
        btn_login_one.setOnClickListener(this)
        btn_login_two.setOnClickListener(this)
        btn_login_three.setOnClickListener(this)
        btn_login_four.setOnClickListener(this)
        btn_login_five.setOnClickListener(this)
        btn_login_six.setOnClickListener(this)
        btn_login_seven.setOnClickListener(this)
        btn_login_eight.setOnClickListener(this)
        btn_login_nine.setOnClickListener(this)
        btn_login_zero.setOnClickListener(this)
        btn_login_delete.setOnClickListener(this)
        btn_login_clear.setOnClickListener(this)

    }

    //button click event handling
    override fun onClick(v: View?) {
        when (v!!.id) {
            btn_login_one.id -> {
                Toast.makeText(applicationContext, "Hello", Toast.LENGTH_SHORT).show()
                setUpButtonText("1")
            }
            btn_login_two.id -> {
                setUpButtonText("2")
            }
            btn_login_three.id -> {
                setUpButtonText("3")
            }
            btn_login_four.id -> {
                setUpButtonText("4")
            }
            btn_login_five.id -> {
                setUpButtonText("5")
            }
            btn_login_six.id -> {
                setUpButtonText("6")
            }
            btn_login_seven.id -> {
                setUpButtonText("7")
            }
            btn_login_eight.id -> {
                setUpButtonText("8")
            }
            btn_login_nine.id -> {
                setUpButtonText("9")
            }
            btn_login_zero.id -> {
                setUpButtonText("0")
            }
            btn_login_delete.id -> {
                clearText()
            }
            btn_login_clear.id -> {
                tv_pinOne.text = ""
                tv_pinTwo.text = ""
                tv_pinThree.text = ""
                tv_pinFour.text = ""
                tv_pinFive.text = ""
                tv_pinSix.text = ""
            }

        }
    }

    //to check pin text
    private fun pinChecker(): Int {
        when {
            tv_pinOne.text == "" -> return 1
            tv_pinTwo.text == "" -> return 2
            tv_pinThree.text == "" -> return 3
            tv_pinFour.text == "" -> return 4
            tv_pinFive.text == "" -> return 5
            tv_pinSix.text == "" -> return 6
            else -> return 0
        }
    }

    //for button click result
    private fun setUpButtonText(message: String) {
        Log.w("CustomPinViewActivity", "message $message")

        when (pinChecker()) {
            1 -> tv_pinOne.text = message
            2 -> tv_pinTwo.text = message
            3 -> tv_pinThree.text = message
            4 -> tv_pinFour.text = message
            5 -> tv_pinFive.text = message
            6 -> tv_pinSix.text = message
            0 -> Toast.makeText(applicationContext, "Full Text", Toast.LENGTH_SHORT).show()
        }
    }

    //to clear pin code
    private fun clearText() {
        when (pinChecker()) {
            1 -> Toast.makeText(applicationContext, "No pins to clear!", Toast.LENGTH_SHORT).show()
            2 -> tv_pinOne.text = ""
            3 -> tv_pinTwo.text = ""
            4 -> tv_pinThree.text = ""
            5 -> tv_pinFour.text = ""
            6 -> tv_pinFive.text = ""
            0 -> tv_pinSix.text = ""
        }
    }


}