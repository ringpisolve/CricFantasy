package com.ringpi.cric.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.ringpi.cric.R


class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val t1=view.findViewById<TextView>(R.id.p1)
        val t2=view.findViewById<TextView>(R.id.p2)
        val t3=view.findViewById<TextView>(R.id.p3)
        val t4=view.findViewById<TextView>(R.id.p4)
        val t5=view.findViewById<TextView>(R.id.p5)
        val t6=view.findViewById<TextView>(R.id.p6)
        val t7=view.findViewById<TextView>(R.id.p7)
        val t8=view.findViewById<TextView>(R.id.p8)
        val t9=view.findViewById<TextView>(R.id.p9)
        val t10=view.findViewById<TextView>(R.id.p10)
        val t11=view.findViewById<TextView>(R.id.p11)
        val t12=view.findViewById<TextView>(R.id.p12)
        val t13=view.findViewById<TextView>(R.id.p13)
        val t14=view.findViewById<TextView>(R.id.p14)
        val t15=view.findViewById<TextView>(R.id.p15)




        val mFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        for (i in 1..15) {
           val pp= "player$i"
            val fgf="t$i"
            val docRef: DocumentReference =
                mFirestore.collection("leaques/arun-tean/playing11")
                    .document(pp)
            docRef.get().addOnCompleteListener { task ->
                val document = task.result
                if (task.isSuccessful) {
                    if (document != null) {
                      val  name=document.getString("name").toString()
                        if (i==1){
                            t1.setText(name)
                        }
                        if (i==2){
                            t2.setText(name)
                        }
                        if (i==3){
                            t3.setText(name)
                        }
                        if (i==4){
                            t4.setText(name)
                        }
                        if (i==5){
                            t5.setText(name)
                        }
                        if (i==6){
                            t6.setText(name)
                        }
                        if (i==7){
                            t7.setText(name)
                        }
                        if (i==8){
                            t8.setText(name)
                        }
                        if (i==9){
                            t9.setText(name)
                        }
                        if (i==10){
                            t10.setText(name)
                        }
                        if (i==11){
                            t11.setText(name)
                        }
                        if (i==12){
                            t12.setText(name)
                        }
                        if (i==13){
                            t13.setText(name)
                        }
                        if (i==14){
                            t14.setText(name)
                        }
                        if (i==15){
                            t15.setText(name)
                        }


                    }

                }
            }
        }
        return view
        return root
    }
}