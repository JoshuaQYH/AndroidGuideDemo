package com.example.androidguide

import android.content.Context
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


/**
 * 用于RecyclerView的Adapter
 */
class DocAdapter(val context: Context, val docList : ArrayList<DocumentationCard> ) : RecyclerView.Adapter<DocAdapter.ViewHolder>(){
    private lateinit var myWebView : WebView

    // 定义内部类，存放每一个Item相关的控件和数据
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val docImage : ImageView = view.findViewById(R.id.docImage)
        val titleView : TextView = view.findViewById(R.id.title)
        val contentView : TextView = view.findViewById(R.id.summary)
    }

    // 创建一个ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.gird_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return docList.size
    }

    // 通过提供Position定位一个具体的Item
    // 获取对应的数据，设置holder中各个属性
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doc = docList[position]
        holder.titleView.text = doc.title
        holder.contentView.text = doc.content
        if (doc.imageUrl != "")
            Glide.with(context).load(doc.imageUrl).into(holder.docImage)

        holder.titleView.setOnClickListener{
            myWebView = WebView(context)
            myWebView.loadUrl(doc.docUrl)
            (context as MainActivity).setContentView(myWebView)
        }
        holder.docImage.setOnClickListener{
            myWebView = WebView(context)
            myWebView.loadUrl(doc.docUrl)
            (context as MainActivity).setContentView(myWebView)
        }
    }
}