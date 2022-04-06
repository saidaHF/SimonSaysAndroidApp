package com.example.simonsaysandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.simonsaysandroidapp.R
import com.example.simonsaysandroidapp.Blue
import com.example.simonsaysandroidapp.Green
import com.example.simonsaysandroidapp.Red
import com.example.simonsaysandroidapp.Yellow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define needed variables
        var random = (0..3).random()
        val fourColors = arrayOf("Green", "Yellow", "Blue", "Red")
        val allColors: ArrayList<String> = arrayListOf(fourColors[random])
        val start = findViewById<Button>(R.id.startBtn)
        val activitiesArray = arrayOf(Green::class.java, Yellow::class.java, Blue::class.java, Red::class.java)

        // Colors Simon says
        for(i in 0..3){
            random = (0..3).random()
            allColors.add(fourColors[random])
        }

        // Start button used to begin game
        start.setOnClickListener {
            val intent = Intent(this@MainActivity, activitiesArray[random])
            intent.putStringArrayListExtra("colors", allColors)
            intent.putExtra("count", 0)
            intent.putExtra("score", 0)
            startActivity(intent)
        }
    }
}






