package com.ringpi.cric.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.ringpi.cric.MainActivity
import com.ringpi.cric.R


class HomeFragment : Fragment() {


    lateinit var listView : ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val mFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

        listView = view.findViewById(R.id.study_level_list)
        var list = mutableListOf<Model>()

        list.add(Model("Title One",   "Description One...",   R.mipmap.ic_launcher  ))
        list.add(Model("Title Two",   "Description Two...",   R.mipmap.ic_launcher_round  ))
        list.add(Model("Title Three", "Description Three...", R.mipmap.ic_launcher  ))
        list.add(Model("Title Four",  "Description Four...",  R.mipmap.ic_launcher_round  ))
        list.add(Model("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))

        listView.adapter = context?.let { MyListAdapter(it,R.layout.row,list) }


        return view
        return root
    }


}