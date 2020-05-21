package com.example.androidguide

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.*
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val introText : String = "\n" +
            "<p>Welcome to the Android developer guides. The\n" +
            "documents listed in the left navigation teach you how to build Android apps using APIs in the\n" +
            "Android framework and other libraries.</p>\n" +
            "\n" +
            "<p>If you're brand new to Android and want to jump into code, start with the <a\n" +
            "href=\"https://developer.android.com/training/basics/firstapp\">Build Your First App</a> tutorial.</p>\n" +
            "  <p>And check out these other resources to learn Android development:</p>\n" +
            "<ul>\n" +
            "  <li><a href=\"https://codelabs.developers.google.com/?cat=Android\">Codelabs</a>: Short,\n" +
            "    self-paced tutorials that each cover a discrete topic. Most codelabs step you through the\n" +
            "    process of building a small app, or adding a new feature to an existing app.</li>\n" +
            "  <li><a href=\"https://developer.android.com/courses\">Courses</a>: Guided training\n" +
            "    paths that teach you how to build Android apps.</li>\n" +
            "  <li>Online training: If you prefer to learn online with videos, check out the\n" +
            "    <a href=\"https://www.udacity.com/course/ud9012\">Developing Android Apps with Kotlin</a> course on Udacity\n" +
            "    (trailer embedded here), and other <a href=\"https://developer.android.com/guide#videos\">online courses below</a>.</ul>\n" +
            "\n\n" +
            "<p>Otherwise, the following is a small selection of essential developer guides that you should\n" +
            "be familiar with.</p>\n"

    // 本地 url -> android.resource://$packageName/${R.raw.video}
    private val videoUrl : String = "https://r5---sn-4g5e6nlk.googlevideo.com/videoplayback?expire=1590079152&ei=UFrGXr75M8fw1gLuh6v4BA&ip=95.179.169.26&id=d09520041ca73dd5&itag=22&source=youtube&requiressl=yes&mh=Kr&mm=31%2C29&mn=sn-4g5e6nlk%2Csn-4g5ednsy&ms=au%2Crdu&mv=m&mvi=4&pl=26&initcwndbps=3356250&vprv=1&mime=video%2Fmp4&ratebypass=yes&dur=54.706&lmt=1557938222737605&mt=1590057515&fvip=5&fexp=23882514&beids=9466585&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAPs97Qd-ghFyEjrq2Qj7hTT-O5MN7u_7LSsHrLCNe1SEAiAGkH1w_vdG6RzmiJPd-TgfnxBwHYgopSDoX5DxCTHrzw%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRgIhAKwwF6npQiloLaFOwnkkKbF-Z8ic7tn02xIp5IccA2D6AiEAsx5_elLgEj_F6WbJEf1O86bjv3_FUmOcdL9vPt2g3Dw%3D&contentlength=3169330&video_id=0JUgBBynPdU&title=Learn+how+to+Build+Android+Apps+with+Android+Jetpack+and+Kotlin"

    private val docList1 = ArrayList<DocumentationCard>()
    private val docList2 = ArrayList<DocumentationCard>()

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 设置固定横屏
        if(this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        }

        setContentView(R.layout.activity_main)

        // 隐藏标题栏
        supportActionBar?.hide()

        // 设置正文 HTML
        val introTextView = findViewById<TextView>(R.id.intro_text)
        introTextView.text = HtmlCompat.fromHtml(introText, HtmlCompat.FROM_HTML_MODE_COMPACT)
        introTextView.movementMethod = LinkMovementMethod.getInstance()

        // 使用MediaController设置视频播放
        configureVideoView(videoUrl)

        // 初始化两个列表
        initDocList()
        val layoutManager1 = GridLayoutManager(this, 3)
        RecyclerView1.layoutManager = layoutManager1
        val adapter1 = DocAdapter(this, docList1)
        RecyclerView1.adapter = adapter1

        val layoutManager2 = GridLayoutManager(this, 3)
        RecyclerView2.layoutManager = layoutManager2
        val adapter2 = DocAdapter(this, docList2)
        RecyclerView2.adapter = adapter2

        /**
        使用GridView实现列表
        val adapter2 = GridDocAdapter(this, docList2)
        GridView1.adapter = adapter2
        */
    }

    // 初始化文档列表
    private fun initDocList(){
        repeat(4){
            docList1.add(DocumentationCard("",
            "https://developer.android.com/training/location/request-updates?hl=en", "Request location updates",
            "information can be beneficial to users of your" +
                    " app. For example, if your app helps the user find their way while walking or" +
                    " driving, or if your app tracks the location of assets, it needs to get the" +
                    " location of the"))
            docList1.add(DocumentationCard("https://developer.android.com/images/training/testing/testing-workflow.png",
                "https://developer.android.com/training/location/request-updates?hl=en", "Request location updates",
                "information can be beneficial to users of your" +
                        " app. For example, if your app helps the user find their way while walking or" +
                        " driving, or if your app tracks the location of assets, it needs to get the" +
                        " location of the"))
            docList2.add(DocumentationCard("https://developer.android.com/images/training/testing/testing-workflow.png",
                "https://developer.android.com/training/location/request-updates?hl=en", "Request location updates",
                "information can be beneficial to users of your" +
                        " app. For example, if your app helps the user find their way while walking or" +
                        " driving, or if your app tracks the location of assets, it needs to get the" +
                        " location of the"))
        }
    }


    private fun configureVideoView(videoUrl : String){
        val uri = Uri.parse(videoUrl)
        videoView.setVideoURI(uri)
        var mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()
    }

}
