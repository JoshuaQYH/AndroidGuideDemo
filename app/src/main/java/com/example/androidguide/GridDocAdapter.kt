package com.example.androidguide

import android.app.Activity
import android.content.Context
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

/**
 * 用于GridView的Adapter ---- 【弃用】
 */

class GridDocAdapter(val context : Context, val docList : ArrayList<DocumentationCard>) : BaseAdapter() {

    private lateinit var holder: ViewHolder
    private lateinit var myWebView : WebView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var myView = convertView
        var mInflater = (context as AppCompatActivity).layoutInflater

        if(myView == null){
            myView = mInflater.inflate(R.layout.gird_item, parent, false)
            holder = ViewHolder(myView)
            myView.tag = holder
        }
        else{
            holder = myView.tag as ViewHolder
        }

        val doc = docList[position]
        holder.titleView.text = doc.title
        holder.summaryView.text = doc.content
        holder.summaryView.movementMethod = ScrollingMovementMethod.getInstance()

        if(doc.imageUrl != "")
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

        return myView
    }

    override fun getItem(position: Int): Any {
        return docList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return docList.size
    }

    class ViewHolder(view : View){
        var docImage : ImageView = view.findViewById(R.id.docImage)
        var titleView : TextView = view.findViewById(R.id.title)
        var summaryView : TextView = view.findViewById(R.id.summary)
    }

}