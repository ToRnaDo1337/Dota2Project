//
//package com.example.dota2.ui.game
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.Fragment
//import androidx.navigation.findNavController
//import com.example.android.navigation.databinding.FragmentGameOverBinding
//import com.example.dota2.R
//
//class GameOverFragment : Fragment() {
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
//                inflater, R.layout.fragment_game_over, container, false)
//
//        binding.tryAgainButton.setOnClickListener { view: View ->
//            view.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToGameFragment())
//        }
//        return binding.root
//    }
//}
