package com.example.androidguide

// 去除尾部的 sp/dp 字符，提取浮点数部分
fun transformSize(viewSize : CharSequence) : Float{
    val floatPart = viewSize.subSequence(0, viewSize.length-2)
    return floatPart.toString().toFloat()
}