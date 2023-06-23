package com.example.navigationcomponentsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<LinearLayout>(R.id.linearLayout).setOnClickListener(this)
        view.findViewById<LinearLayout>(R.id.linearLayout2).setOnClickListener(this)
        view.findViewById<LinearLayout>(R.id.linearLayout3).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.linearLayout -> navController!!.navigate(R.id.action_mainFragment_to_ketQua)
            R.id.linearLayout2 -> navController!!.navigate(R.id.action_mainFragment_to_homNay)
            R.id.linearLayout3 -> navController!!.navigate(R.id.action_mainFragment_to_ketQuaDai)
        }
    }
}