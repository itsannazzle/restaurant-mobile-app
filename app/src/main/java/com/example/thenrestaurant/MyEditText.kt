package com.example.thenrestaurant

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener

class MyEditText : AppCompatEditText, View.OnTouchListener {
    internal lateinit var mClearButton : Drawable
    constructor(context: Context) : super(context) {
        inih()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        inih()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        inih()
    }
    private fun inih(){
        mClearButton = ResourcesCompat.getDrawable(resources,R.drawable.ic_baseline_close_24,null) as Drawable
        setOnTouchListener(this)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty())
                    showClearIcon()
                else hideClearIcon()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        hint = "What's so funny?"
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (compoundDrawables[2] != null){
            val clearIconStart : Float
            val clearIconEnd : Float
            var isClearButtonClick = false
            when(layoutDirection){
                View.LAYOUT_DIRECTION_RTL -> {
                    clearIconEnd = (mClearButton.intrinsicWidth + paddingStart).toFloat()
                    if (event != null) {
                        when{
                            event.x < clearIconEnd -> isClearButtonClick = true
                        }
                    }
                }
                else -> {
                    clearIconStart = (width - paddingEnd - mClearButton.intrinsicHeight).toFloat()
                    if (event != null) {
                        when{
                            event.x < clearIconStart -> isClearButtonClick = true
                        }
                    }
                }
            }
            when{
                isClearButtonClick -> if (event != null) {
                    when {
                        event.action == MotionEvent.ACTION_DOWN -> {
                            mClearButton =
                                ResourcesCompat.getDrawable(
                                resources,
                                R.drawable.ic_baseline_close_24,
                                null) as Drawable
                            showClearIcon()
                            return true
                        }
                        event.action == MotionEvent.ACTION_UP -> {
                            mClearButton =
                                ResourcesCompat.getDrawable(
                                    resources,
                                    R.drawable.ic_baseline_close_24,
                                    null
                                ) as Drawable
                            when{
                                text != null -> text?.clear()
                            }
                            hideClearIcon()
                            return true
                        }
                        else -> return false
                    }
                }
                else -> return false
            }
        }
        return false
    }

    private fun showClearIcon(){
        setCompoundDrawablesWithIntrinsicBounds(null,null,mClearButton,null)
    }
    private fun hideClearIcon(){
        setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
    }
}