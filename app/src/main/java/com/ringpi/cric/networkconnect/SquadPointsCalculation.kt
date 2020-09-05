package com.ringpi.cric.networkconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringpi.cric.R
import kotlinx.android.synthetic.main.activity_squad_points_calculation.*

class SquadPointsCalculation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squad_points_calculation)
        val intent: Intent = intent
        var jsonstring = intent.getStringExtra("jsonstring")
        var team = intent.getStringExtra("team")
        textView2.text = jsonstring
    }
}