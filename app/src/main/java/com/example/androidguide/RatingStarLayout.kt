package com.example.androidguide

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

/**
 * 封装星星评分控件，实现复用
 */
class RatingStarLayout: LinearLayout {
    var starImageList : ArrayList<ImageView> = ArrayList()
    val mContext : Context

    /*两个构造函数分别是针对不同安卓版本*/
    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int = 0):super(context, attrs, defStyleAttr){
        LayoutInflater.from(context).inflate(R.layout.layout_rating_star, this, true)
        initStarImageList()
        mContext = context
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes : Int):super(context, attrs, defStyleAttr, defStyleRes){
        LayoutInflater.from(context).inflate(R.layout.layout_rating_star, this, true)
        initStarImageList()
        mContext = context
    }

    /*初始化星星image列表，并设置监听事件*/
    private fun initStarImageList(){
        starImageList.add(findViewById(R.id.starImage1))
        starImageList.add(findViewById(R.id.starImage2))
        starImageList.add(findViewById(R.id.starImage3))
        starImageList.add(findViewById(R.id.starImage4))
        starImageList.add(findViewById(R.id.starImage5))
        for(item in starImageList){
            item.setOnClickListener{rating(it)}
        }
    }

    /*判断点击按钮的ID，发送不同的系统通知，以及实现星星的显示和隐藏*/
    private fun rating(view : View){
        var rateNum : Int = 0
        when(view.id){
            R.id.starImage1 -> {
                rateNum = 1
                Toast.makeText(mContext, "Unusable documentation", Toast.LENGTH_LONG).show()
            }
            R.id.starImage2 -> {
                rateNum = 2
                Toast.makeText(mContext, "Poor documentation", Toast.LENGTH_LONG).show()
            }
            R.id.starImage3 -> {
                rateNum = 3
                Toast.makeText(mContext, "OK documentation", Toast.LENGTH_LONG).show()
            }
            R.id.starImage4 -> {
                rateNum = 4
                Toast.makeText(mContext, "Good documentation", Toast.LENGTH_LONG).show()
            }
            R.id.starImage5 -> {
                rateNum = 5
                Toast.makeText(mContext, "Excellent documentation", Toast.LENGTH_LONG).show()
            }
        }

        for(item in starImageList){
            if(rateNum > 0)
                item.setImageResource(R.drawable.btn_star_big_on)
            else
                item.setImageResource(R.drawable.btn_star_big_off)
            rateNum -= 1
        }

    }


}

