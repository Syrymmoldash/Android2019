package com.example.example.moldashsyrympackage.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.example.moldashsyrympackage.R
import com.example.example.moldashsyrympackage.activities.main.MainActivity
import com.example.example.moldashsyrympackage.services.ServiceCreator

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        startActivity(Intent(this, MainActivity::class.java))
    }
}
