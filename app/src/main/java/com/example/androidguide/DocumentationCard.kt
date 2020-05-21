package com.example.androidguide

/**
 * 此处定义一个数据类
 * 用于保存GridItem中的各个数据项
 */
data class DocumentationCard(val imageUrl : String, val docUrl : String  = "", val title : String, val content: String)