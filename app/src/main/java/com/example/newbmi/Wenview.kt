package com.example.newbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.newbmi.databinding.ActivityWenviewBinding

class Wenview : AppCompatActivity() {
    private lateinit var binding: ActivityWenviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWenviewBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        binding.webview.webViewClient=MyWaveVieuClint()
        binding.webview.loadUrl("https://developer.android.com/develop/ui/views/layout/webapps/webview")
        setContentView(binding.root)
    }
    inner class MyWaveVieuClint : WebViewClient() {
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        binding.progress.visibility=View.GONE
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return super.shouldOverrideUrlLoading(view, request)
    }
}
}
