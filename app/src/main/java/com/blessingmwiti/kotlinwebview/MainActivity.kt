package com.blessingmwiti.kotlinwebview

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            if (isNetworkAvailable()) {
                // Start WebViewActivity if network is available
                startActivity(Intent(this, WebViewActivity::class.java))
            } else {
                // Start NoConnectionActivity if network is not available
                startActivity(Intent(this, NoConnectionActivity::class.java))
            }
            finish() // Close SplashActivity
        }, 2000) // 2 seconds delay
    }
    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}