package com.example.thenrestaurant

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.renderscript.ScriptGroup
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class MyButton: AppCompatButton {
    private var enabledBackground: Drawable? = null
    private var disabledBackground: Drawable? = null
    private var txtColor: Int = 0
    constructor(context: Context) : super(context) {
        inih()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        inih()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        inih()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = when{
            isEnabled -> enabledBackground
            else -> disabledBackground
        }

        setTextColor(txtColor)
        textSize = 14f
        gravity = Gravity.CENTER
        text = when {
            isEnabled -> "Submit"
            else -> "Enter text"
        }
    }

    private fun inih() {
        txtColor = ContextCompat.getColor(context,R.color.black)
        enabledBackground = ResourcesCompat.getDrawable(resources,R.drawable.bg_button,null)
        disabledBackground =ResourcesCompat.getDrawable(resources,R.drawable.bg_button_diasble,null)
    }
}