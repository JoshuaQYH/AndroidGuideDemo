package com.example.androidguide

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.util.Util
import kotlinx.android.synthetic.main.layout_title.view.*

/**
 * 封装副标题，传入标题文本属性和标题大小属性，实现复用
 */
class TitleLayout: LinearLayout {
    /*两个构造函数针对不同的安卓版本*/
    @JvmOverloads
    constructor(context: Context, attrs:AttributeSet?=null, defStyleAttr: Int = 0):super(context, attrs, defStyleAttr){
        LayoutInflater.from(context).inflate(R.layout.layout_title, this, true)
        attrs.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.TitleLayout, 0, 0)
            val title = resources.getText(typedArray.getResourceId(R.styleable.TitleLayout_custom_title, R.string.header))
            val titleTextSize = resources.getText(typedArray.getResourceId(R.styleable.TitleLayout_title_textSize, R.dimen.Header1Size))
            titleText.text = title
            titleText.textSize = transformSize(titleTextSize)
            typedArray.recycle()
        }
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs:AttributeSet?, defStyleAttr: Int, defStyleRes : Int):super(context, attrs, defStyleAttr, defStyleRes){
        LayoutInflater.from(context).inflate(R.layout.layout_title, this, true)
        attrs.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.TitleLayout, 0, 0)
            val title = resources.getText(typedArray.getResourceId(R.styleable.TitleLayout_custom_title, R.string.header))
            val titleTextSize = resources.getText(typedArray.getResourceId(R.styleable.TitleLayout_title_textSize, R.dimen.Header1Size))
            titleText.text = title
            titleText.textSize = transformSize(titleTextSize)
            typedArray.recycle()
        }
    }


}
