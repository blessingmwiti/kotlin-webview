package com.blessingmwiti.kotlinwebview

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.blessingmwiti.kotlinwebview.databinding.ActivityNoConnectionBinding

class NoConnectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoConnectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoConnectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Displaying the toast message immediately when the activity starts
        Toast.makeText(this, "No internet connection. Please check your network settings.", Toast.LENGTH_LONG).show()

        binding.buttonRetry.setOnClickListener {
            if (isNetworkAvailable()) {
                startActivity(Intent(this, WebViewActivity::class.java))
                finish() // Close NoConnectionActivity
            } else {
                Toast.makeText(this, "Network is still unavailable. Please check your internet connection and try again.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}

