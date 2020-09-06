package com.ringpi.cric.fantasypoints

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ringpi.cric.R
import com.ringpi.cric.fantasypoints.FantasypointsFragment
import kotlinx.android.synthetic.main.activity_squad_points_calculation.*

class SquadPointsCalculation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squad_points_calculation)
        /*val intent: Intent = intent
        var jsonstring = intent.getStringExtra("jsonstring")
        var team = intent.getStringExtra("team")
       textView2.text = jsonstring
       */


        val fm: FragmentManager = supportFragmentManager
        var fragment = fm.findFragmentByTag("myFragmentTag")
        if (fragment == null) {
            val ft: FragmentTransaction = fm.beginTransaction()
            fragment = FantasypointsFragment()
            ft.add(android.R.id.content, fragment, "myFragmentTag")
            ft.commit()


        }

    }
}
