package com.nextgen.pinview

import android.graphics.Bitmap
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

/**
 * https://github.com/ajayhack/PinViewKotlin
 */
class PinViewKotlinActivity : AppCompatActivity() {

    //All MPIN EditText Views:-
    private val mpin_otp_et1 by lazy { findViewById<EditText>(R.id.mpin_otp_et1) }
    private val mpin_otp_et2 by lazy { findViewById<EditText>(R.id.mpin_otp_et2) }
    private val mpin_otp_et3 by lazy { findViewById<EditText>(R.id.mpin_otp_et3) }
    private val mpin_otp_et4 by lazy { findViewById<EditText>(R.id.mpin_otp_et4) }

    //All KeyPad Buttons:-
    private val tv_button_one by lazy { findViewById<TextView>(R.id.tv_button_one) }
    private val tv_button_two by lazy { findViewById<TextView>(R.id.tv_button_two) }
    private val tv_button_three by lazy { findViewById<TextView>(R.id.tv_button_three) }
    private val tv_button_four by lazy { findViewById<TextView>(R.id.tv_button_four) }
    private val tv_button_five by lazy { findViewById<TextView>(R.id.tv_button_five) }
    private val tv_button_six by lazy { findViewById<TextView>(R.id.tv_button_six) }
    private val tv_button_seven by lazy { findViewById<TextView>(R.id.tv_button_seven) }
    private val tv_button_eight by lazy { findViewById<TextView>(R.id.tv_button_eight) }
    private val tv_button_nine by lazy { findViewById<TextView>(R.id.tv_button_nine) }
    private val tv_button_zero by lazy { findViewById<TextView>(R.id.tv_button_zero) }
    private val tv_button_clear by lazy { findViewById<ImageView>(R.id.tv_button_clear) }
    private val mpin_otp_tv by lazy { findViewById<TextView>(R.id.mpin_otp_tv) }
    private val back_icon by lazy { findViewById<ImageView>(R.id.back_icon) }
    private val logo_icon by lazy { findViewById<ImageView>(R.id.logo_icon) }
    private val user_name_tv by lazy { findViewById<TextView>(R.id.user_name_tv) }
    private val parent_view by lazy { findViewById<ConstraintLayout>(R.id.parent_view) }
    private val forgot_pin_tv by lazy { findViewById<TextView>(R.id.forgot_pin_tv) }

    private var emptyBackgroundColor : Int = 0
    private var emptyBorderColor : Int = 0
    private var emptyShapeValue : Int = 0
    private var emptyWidthValue : Int = 0
    private var filledBackgroundColor : Int = 0
    private var filledBorderColor : Int = 0
    private var filledShapeValue : Int = 0
    private var filledWidthValue : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_view_kotlin)

        systemKeyboardHideForAllEditText()
        mpin_otp_tv.text = getString(R.string.enter_m_pin)

        //All click events:-
        allClickEventHandling()
        styleEmptyCircle(ContextCompat.getColor(this , android.R.color.transparent) ,
            ContextCompat.getColor(this , R.color.colorWhite) , 0 , 2)

        styleFilledCircle(ContextCompat.getColor(this , android.R.color.darker_gray) ,
            ContextCompat.getColor(this , android.R.color.darker_gray) , 0 , 2)

        forgotMPINClickEvent(::show)

    }


    private fun show(){
        Toast.makeText(this , "Forgot Forgot" , Toast.LENGTH_LONG).show()
    }
    /*Change Activity Background Color */
    private fun changeViewBackgroundColor(color : Int){
        parent_view.setBackgroundColor(color)
    }

    /*Method to Handle Click event on Brand Logo */
    private fun brandLogoClickEvent(logoEvent : () -> Unit){
        logo_icon.setOnClickListener {
            logoEvent()
        }
    }

    /*Method to Handle Enter MPIN Clicked */
    private fun enterMPINClickEvent(mpinEvent : () -> Unit){
        mpin_otp_tv.setOnClickListener {
            mpinEvent()
        }
    }

    /* Method to Handle UserName Click */
    private fun userNameClickEvent(userNameEvent : () -> Unit){
        user_name_tv.setOnClickListener {
            userNameEvent()
        }
    }

    /* Method to Handle Forgot MPIN Click */
    private fun forgotMPINClickEvent(userNameEvent : () -> Unit){
        forgot_pin_tv.setOnClickListener {
            userNameEvent()
        }
    }

    /*Show/Hide Back button */
    private fun showHideBackIcon(isShow : Int){
        when(isShow){
            0 -> back_icon.visibility = View.GONE
            1 -> back_icon.visibility = View.VISIBLE
        }
    }

    /*Change Brand Logo and Back Icon*/
    private fun changeBrandLogo(bitmapBrandLogo: Bitmap){
        logo_icon.setImageBitmap(bitmapBrandLogo)

    }

    /*Change Back Icon */
    private fun changeBackIcon(backBitmap : Bitmap){
        back_icon.setImageBitmap(backBitmap)
    }

    /*Change Clear KeyPad Icon */
    private fun changeClearIcon(clearBitmap : Bitmap){
        tv_button_clear.setImageBitmap(clearBitmap)
    }

    /*Style Enter MPIN Text */
    private fun styleEnterMPINText(customText : String , customColor : Int , fontSize : Float){
        mpin_otp_tv.text = customText
        mpin_otp_tv.setTextColor(customColor)
        mpin_otp_tv.textSize = fontSize
    }

    /*Style Enter MPIN Text */
    private fun styleNameText(customText : String , customColor : Int , fontSize : Float){
        user_name_tv.text = customText
        user_name_tv.setTextColor(customColor)
        user_name_tv.textSize = fontSize
    }

    /*Style Forgot MPIN Text */
    private fun styleForgotMPINText(customText : String , customColor : Int , fontSize : Float){
        forgot_pin_tv.text = customText
        forgot_pin_tv.setTextColor(customColor)
        forgot_pin_tv.textSize = fontSize
    }

    /*Style All KeyPad Text */
    private fun styleKeyPadButtons(textColor : Int , fontSize : Float){
        tv_button_one.setTextColor(textColor)
        tv_button_one.textSize = fontSize

        tv_button_two.setTextColor(textColor)
        tv_button_two.textSize = fontSize

        tv_button_three.setTextColor(textColor)
        tv_button_three.textSize = fontSize

        tv_button_four.setTextColor(textColor)
        tv_button_five.textSize = fontSize

        tv_button_five.setTextColor(textColor)
        tv_button_five.textSize = fontSize

        tv_button_six.setTextColor(textColor)
        tv_button_six.textSize = fontSize

        tv_button_seven.setTextColor(textColor)
        tv_button_seven.textSize = fontSize

        tv_button_eight.setTextColor(textColor)
        tv_button_eight.textSize = fontSize

        tv_button_nine.setTextColor(textColor)
        tv_button_nine.textSize = fontSize

        tv_button_zero.setTextColor(textColor)
        tv_button_zero.textSize = fontSize

    }

    //Handle click events:-
    private fun allClickEventHandling() {
        tv_button_one.setOnClickListener {
            setKeypadDataToEditText(tv_button_one.text.toString().trim())
        }
        tv_button_two.setOnClickListener {
            setKeypadDataToEditText(tv_button_two.text.toString().trim())
        }
        tv_button_three.setOnClickListener {
            setKeypadDataToEditText(tv_button_three.text.toString().trim())
        }
        tv_button_four.setOnClickListener {
            setKeypadDataToEditText(tv_button_four.text.toString().trim())
        }
        tv_button_five.setOnClickListener {
            setKeypadDataToEditText(tv_button_five.text.toString().trim())
        }
        tv_button_six.setOnClickListener {
            setKeypadDataToEditText(tv_button_six.text.toString().trim())
        }
        tv_button_seven.setOnClickListener {
            setKeypadDataToEditText(tv_button_seven.text.toString().trim())
        }
        tv_button_eight.setOnClickListener {
            setKeypadDataToEditText(tv_button_eight.text.toString().trim())
        }
        tv_button_nine.setOnClickListener {
            setKeypadDataToEditText(tv_button_nine.text.toString().trim())
        }
        tv_button_zero.setOnClickListener {
            setKeypadDataToEditText(tv_button_zero.text.toString().trim())
        }

        tv_button_clear.setOnClickListener {
            clearEditTextData()
        }

        mpin_otp_et4.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if(!TextUtils.isEmpty(s.toString().trim())) {
                    val mpinValue = mpin_otp_et1.text.toString().trim() + mpin_otp_et2.text.toString().trim() +
                            mpin_otp_et3.text.toString().trim() + mpin_otp_et4.text.toString().trim()
                    Log.d("MPIN_VALUE", mpinValue)
                    getPinValue(mpinValue)
                }
            }
        })
    }

    /*This metho return value of all Pin together if all have value otherwise it will return blank*/
    private fun getPinValue(mpinValue: String) : String {
        return if(!TextUtils.isEmpty(mpinValue)){
            mpinValue
        }else
            ""
    }

    //Handling System Keyboard Hide for All EditText:-
    private fun systemKeyboardHideForAllEditText() {
        mpin_otp_et1.showSoftInputOnFocus = false
        mpin_otp_et2.showSoftInputOnFocus = false
        mpin_otp_et3.showSoftInputOnFocus = false
        mpin_otp_et4.showSoftInputOnFocus = false
    }

    //Handling KeyPad Button click and set in EditText:-
    private fun setKeypadDataToEditText(keypadValue : String){
        if(!TextUtils.isEmpty(keypadValue)){
            when{
                mpin_otp_et1.text.toString().trim().isEmpty()-> {
                    mpin_otp_et1.background = createBackgroundShape(filledBackgroundColor , filledBorderColor , filledShapeValue , filledWidthValue)
                    mpin_otp_et1.setText(keypadValue)
                }
                mpin_otp_et2.text.toString().trim().isEmpty()-> {
                    mpin_otp_et2.background = createBackgroundShape(filledBackgroundColor , filledBorderColor , filledShapeValue , filledWidthValue)
                    mpin_otp_et2.setText(keypadValue)
                }
                mpin_otp_et3.text.toString().trim().isEmpty()-> {
                    mpin_otp_et3.background = createBackgroundShape(filledBackgroundColor , filledBorderColor , filledShapeValue , filledWidthValue)
                    mpin_otp_et3.setText(keypadValue)
                }
                mpin_otp_et4.text.toString().trim().isEmpty()-> {
                    mpin_otp_et4.background = createBackgroundShape(filledBackgroundColor , filledBorderColor , filledShapeValue , filledWidthValue)
                    mpin_otp_et4.setText(keypadValue)
                }
            }
        }
    }

    /*Style Empty Circle */
    private fun styleEmptyCircle(emptyBgColor : Int , emptyBdColor: Int , shapeStatus : Int , width: Int ){
        mpin_otp_et1.background = createBackgroundShape(emptyBgColor , emptyBdColor , shapeStatus , width)
        mpin_otp_et2.background = createBackgroundShape(emptyBgColor , emptyBdColor , shapeStatus , width)
        mpin_otp_et3.background = createBackgroundShape(emptyBgColor , emptyBdColor , shapeStatus , width)
        mpin_otp_et4.background = createBackgroundShape(emptyBgColor , emptyBdColor , shapeStatus , width)

        emptyBackgroundColor = emptyBgColor
        emptyBorderColor = emptyBdColor
        emptyShapeValue = shapeStatus
        emptyWidthValue = width
    }

    /*Style Filled Circle */
    private fun styleFilledCircle(filledBgColor : Int , filledBdColor : Int , filledShapeV : Int , filledWidthV : Int){
        filledBackgroundColor = filledBgColor
        filledBorderColor = filledBdColor
        filledShapeValue = filledShapeV
        filledWidthValue = filledWidthV

    }

    //Handling KeyPad clear click and clear EditText data:-
    private fun clearEditTextData(){
        when{
            mpin_otp_et4.text.toString().trim().isNotEmpty()-> {
                mpin_otp_et4.background = createBackgroundShape(emptyBackgroundColor , emptyBorderColor , emptyShapeValue , emptyWidthValue)
                mpin_otp_et4.setText("")
            }
            mpin_otp_et3.text.toString().trim().isNotEmpty()-> {
                mpin_otp_et3.background = createBackgroundShape(emptyBackgroundColor , emptyBorderColor , emptyShapeValue , emptyWidthValue)
                mpin_otp_et3.setText("")
            }
            mpin_otp_et2.text.toString().trim().isNotEmpty()-> {
                mpin_otp_et2.background = createBackgroundShape(emptyBackgroundColor , emptyBorderColor , emptyShapeValue , emptyWidthValue)
                mpin_otp_et2.setText("")
            }
            mpin_otp_et1.text.toString().trim().isNotEmpty()-> {
                mpin_otp_et1.background = createBackgroundShape(emptyBackgroundColor , emptyBorderColor , emptyShapeValue , emptyWidthValue)
                mpin_otp_et1.setText("")
            }
        }
    }

    private fun clearAllView(){
        mpin_otp_et1.setText("")
        mpin_otp_et1.background = createBackgroundShape(emptyBackgroundColor , emptyBorderColor , emptyShapeValue , emptyWidthValue)
        mpin_otp_et2.setText("")
        mpin_otp_et2.background = createBackgroundShape(emptyBackgroundColor , emptyBorderColor , emptyShapeValue , emptyWidthValue)
        mpin_otp_et3.setText("")
        mpin_otp_et3.background = createBackgroundShape(emptyBackgroundColor , emptyBorderColor , emptyShapeValue , emptyWidthValue)
        mpin_otp_et4.setText("")
        mpin_otp_et4.background = createBackgroundShape(emptyBackgroundColor , emptyBorderColor , emptyShapeValue , emptyWidthValue)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun createBackgroundShape(backgroundColor: Int, borderColor: Int, shape : Int , width : Int): GradientDrawable {
        val gradientDrawable = GradientDrawable()
        when(shape){
            0 -> gradientDrawable.shape = GradientDrawable.OVAL
            1 -> gradientDrawable.shape = GradientDrawable.RECTANGLE
            2 -> gradientDrawable.shape = GradientDrawable.LINE
        }
        gradientDrawable.setColor(backgroundColor)
        gradientDrawable.setStroke(width, borderColor)

        return gradientDrawable
    }

}