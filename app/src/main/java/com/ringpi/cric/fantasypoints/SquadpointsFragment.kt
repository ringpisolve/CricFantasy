package com.ringpi.cric.fantasypoints

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.google.firebase.firestore.FirebaseFirestore
import com.ringpi.cric.R

class SquadpointsFragment : Fragment() {

    lateinit var listView : ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.squadpoints_fragment, container, false)
        val view: View = inflater.inflate(R.layout.squadpoints_fragment, container, false)

        val mFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

        listView = view.findViewById(R.id.study_level_list1)
        var list = mutableListOf<Model1>()

        list.add(Model1("Title 1",   "Description One...",   R.mipmap.ic_launcher  ))
        list.add(Model1("Title Two",   "Description Two...",   R.mipmap.ic_launcher_round  ))
        list.add(Model1("Title Three", "Description Three...", R.mipmap.ic_launcher  ))
        list.add(Model1("Title Four",  "Description Four...",  R.mipmap.ic_launcher_round  ))
        list.add(Model1("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))

        listView.adapter = context?.let { MyListAdapter1(it,R.layout.row2,list) }


        return view
        return root
    }


}