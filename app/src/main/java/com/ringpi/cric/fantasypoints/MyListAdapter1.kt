package com.ringpi.cric.fantasypoints

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ringpi.cric.R


class MyListAdapter1(var mCtx: Context, var resource:Int, var items:List<Model1>)
    : ArrayAdapter<Model1>( mCtx , resource , items ){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        val imageView : ImageView = view.findViewById(R.id.iconIv1)
        var textView : TextView = view.findViewById(R.id.titleTv1)
        var textView1 : TextView = view.findViewById(R.id.descTv1)


        var person : Model1 = items[position]

        imageView.setImageDrawable(mCtx.resources.getDrawable(person.photo))
        textView.text = person.title
        textView1.text = person.desc


        return view
    }

}