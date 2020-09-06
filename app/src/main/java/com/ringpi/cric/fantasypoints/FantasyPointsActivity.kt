package com.ringpi.cric.fantasypoints

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.ringpi.cric.R

class FantasyPointsActivity : AppCompatActivity() {


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