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



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val mFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

        return view
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = context as MainActivity
        val users = arrayOf(
            "Virat Kohli", "Rohit Sharma", "Steve Smith",
            "Kane Williamson", "Ross Taylor"
        )
        val lv = context.findViewById(R.id.study_level_list) as ListView
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, users)
        lv.adapter = adapter
    }
}