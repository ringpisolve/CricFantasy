package com.ringpi.cric.fantasypoints

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import com.ringpi.cric.R

class FantasypointsFragment : Fragment() {

    lateinit var listView : ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.squadpoints_fragment, container, false)
        val view: View = inflater.inflate(R.layout.squadpoints_fragment, container, false)
        val teamName: TextView = view.findViewById(R.id.team_name)
        val bundle = this.arguments
        val jsonstring = bundle!!.getString("jsonstring")
        val team = bundle!!.getString("team")
        teamName.setText(team)

        val mFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        // get current match pid list from json string
        // get team pid list from firebase
        // find playing squad pid list for this match
        // parse bowling array and return bowling obj for each pid
        // parse batting array and return batting obj for eaach pid
        // parse fielding array and return fielding obj for each pid
        // build PlayerPointsData for each pid and supply to adaptor.


        listView = view.findViewById(R.id.study_level_list1)
        var list = mutableListOf<PlayerPointsData>()

        list.add(PlayerPointsData("Title 1",   "Description One...",   R.mipmap.ic_launcher  ))
        list.add(PlayerPointsData("Title Two",   "Description Two...",   R.mipmap.ic_launcher_round  ))
        list.add(PlayerPointsData("Title Three", "Description Three...", R.mipmap.ic_launcher  ))
        list.add(PlayerPointsData("Title Four",  "Description Four...",  R.mipmap.ic_launcher_round  ))
        list.add(PlayerPointsData("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))

        listView.adapter = context?.let { FantasyPointsAdapter(it,R.layout.fantasy_points_list_item,list) }


        return view
        return root
    }


}