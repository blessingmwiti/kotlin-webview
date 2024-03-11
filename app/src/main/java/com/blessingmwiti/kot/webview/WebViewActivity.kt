package com.blessingmwiti.kot.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.blessingmwiti.kot.webview.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize WebView
        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        binding.webview.apply {
            webViewClient = WebViewClient() // Ensure links open in the WebView not in a browser
            loadUrl("https://your-url.com") // TODO: Replace with your actual URL
            settings.javaScriptEnabled = true // Enable JavaScript if required by your web app
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.webview.canGoBack()) {
            binding.webview.goBack() // Go back in webview history
        } else {
            super.onBackPressed()
        }
    }
}
