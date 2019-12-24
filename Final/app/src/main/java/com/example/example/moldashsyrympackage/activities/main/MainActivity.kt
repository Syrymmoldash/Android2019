package com.example.example.moldashsyrympackage.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.example.example.moldashsyrympackage.R
import com.example.example.moldashsyrympackage.activities.main.fragments.FeedFragment
import com.example.example.moldashsyrympackage.activities.main.fragments.FragmentType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainFragmentContainer, FeedFragment.newInstance(FragmentType.TOP))
            .commit()

    }
}
