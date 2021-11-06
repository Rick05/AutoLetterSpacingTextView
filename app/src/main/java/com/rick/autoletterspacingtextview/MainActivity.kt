package com.rick.autoletterspacingtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_first).setOnClickListener{
            findViewById<TextView>(R.id.tv_second).text = "测试一下"
        }
    }
}