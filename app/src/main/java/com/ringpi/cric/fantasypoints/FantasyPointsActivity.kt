package com.ringpi.cric.fantasypoints

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ringpi.cric.R

class FantasyPointsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squad_points_calculation)
        val intent: Intent = intent
        var jsonstring = intent.getStringExtra("jsonstring")
        var team = intent.getStringExtra("team")

        val bundle = Bundle()
        bundle.putString("jsonstring", jsonstring)
        bundle.putString("team", team)

        val fm: FragmentManager = supportFragmentManager
        var fragment = fm.findFragmentByTag("myFragmentTag")
        if (fragment == null) {
            val ft: FragmentTransaction = fm.beginTransaction()
            fragment = FantasypointsFragment()
            fragment.setArguments(bundle)
            ft.add(android.R.id.content, fragment, "myFragmentTag")
            ft.commit()


        }

    }
}