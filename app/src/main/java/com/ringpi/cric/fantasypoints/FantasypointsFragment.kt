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
import com.ringpi.cric.networkconnect.*
import org.json.JSONObject
import java.lang.Exception

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
        var pidlist=Utils.getCurrentMatchPlayersPIDList(jsonstring)
        // get team pid list from firebase
        var teampidlist=FirebaseUtils.getTeamPIDList(team)
        // find playing squad pid list for this match
        var playingElevenpidlist=FirebaseUtils.getPlayingElevenPIDList(team)
        // parse bowling array and return bowling obj for each pid

        try
        {
            val jsonobj = JSONObject(jsonstring)
            val dataobj = jsonobj.getJSONObject("data")
            val matchbowlingobject = dataobj.getJSONArray("bowling")
            val teambowlingaarray=matchbowlingobject.getJSONObject(0)
            val matchbowlingaarray=teambowlingaarray.getJSONArray("scores")





            for (i in 0..matchbowlingaarray!!.length()) {
                for (i in 0..playingElevenpidlist.size){
                    val id= playingElevenpidlist[i]

                    val playerid = matchbowlingaarray.getJSONObject(i).getString("pid")
                    if (id.equals(playerid)) {
                        val wickets = matchbowlingaarray.getJSONObject(i).getString("W").toInt()
                        val maidens = matchbowlingaarray.getJSONObject(i).getString("M").toInt()
                        val economy = matchbowlingaarray.getJSONObject(i).getString("Econ").toFloat()


                        val bowlingScore = BowlingScore(wickets,maidens,economy)
                        bowlingScore.setWickets(wickets)
                        bowlingScore.setMaidens(maidens)
                        bowlingScore.setEconomy(economy)



                    }
                }


            }

        }  catch (e:Exception){
            e.printStackTrace()
        }


        try
        {
            val jsonobj = JSONObject(jsonstring)
            val dataobj = jsonobj.getJSONObject("data")
            val matchbattingobject = dataobj.getJSONArray("batting")
            val teambattingaarray=matchbattingobject.getJSONObject(0)
            val matchbattingaarray=teambattingaarray.getJSONArray("scores")





            for (i in 0..matchbattingaarray!!.length()) {
                for (i in 0..playingElevenpidlist.size){
                    val id= playingElevenpidlist[i]

                    val playerid = matchbattingaarray.getJSONObject(i).getString("pid")
                    if (id.equals(playerid)) {
                        val runs = matchbattingaarray.getJSONObject(i).getString("R").toInt()
                        val fours = matchbattingaarray.getJSONObject(i).getString("4s").toInt()
                        val sixes = matchbattingaarray.getJSONObject(i).getString("6s").toInt()


                        val battingScore = BattingScore(runs,fours,sixes)
                           battingScore.setRuns(runs)
                           battingScore.setNoOfFours(fours)
                           battingScore.setNoOfSixes(sixes)



                    }
                }


            }

        } catch (e:Exception){
            e.printStackTrace()
        }

        try
        {
            val jsonobj = JSONObject(jsonstring)
            val dataobj = jsonobj.getJSONObject("data")
            val matchfieldingobject = dataobj.getJSONArray("fielding")
            val teamfieldingaarray=matchfieldingobject.getJSONObject(0)
            val matchfieldingaarray=teamfieldingaarray.getJSONArray("scores")





            for (i in 0..matchfieldingaarray!!.length()) {
                for (i in 0..playingElevenpidlist.size){
                    val id= playingElevenpidlist[i]

                    val playerid = matchfieldingaarray.getJSONObject(i).getString("pid")
                    if (id.equals(playerid)) {
                        val catches = matchfieldingaarray.getJSONObject(i).getString("W").toInt()
                        val stumped = matchfieldingaarray.getJSONObject(i).getString("M").toInt()

                  // Json response format is not in a proper need to think about it

                       val fieldingScore=FieldingScore(catches,stumped)
                        fieldingScore.setCatches(catches);
                        fieldingScore.setStumped(stumped);



                    }
                }


            }

        } catch (e:Exception){
            e.printStackTrace()
        }



        // parse batting array and return batting obj for each pid
        // parse fielding array and return fielding obj for each pid
        // build PlayerPointsData for each pid and supply to adaptor


        listView = view.findViewById(R.id.study_level_list1)
        var list = mutableListOf<PlayerPointsData>()

        list.add(PlayerPointsData("Title 1", "Description One...", R.mipmap.ic_launcher))
        list.add(PlayerPointsData("Title Two", "Description Two...", R.mipmap.ic_launcher_round))
        list.add(PlayerPointsData("Title Three", "Description Three...", R.mipmap.ic_launcher))
        list.add(PlayerPointsData("Title Four", "Description Four...", R.mipmap.ic_launcher_round))
        list.add(PlayerPointsData("Title Five", "Description Five...", R.mipmap.ic_launcher))

        listView.adapter = context?.let { FantasyPointsAdapter(
            it,
            R.layout.fantasy_points_list_item,
            list
        ) }


        return view
        return root
    }


}