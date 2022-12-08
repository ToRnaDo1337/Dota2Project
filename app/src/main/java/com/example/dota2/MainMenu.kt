package com.example.dota2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.dota2.MainMenuDirections
import com.example.dota2.databinding.FragmentMainMenuBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainMenu : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var _binding: FragmentMainMenuBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        binding.play.setOnClickListener { view: View ->
            view.findNavController().navigate(MainMenuDirections.actionMainMenuToMakoQuestion())
        }
        binding.imageButton4.setOnClickListener { view ->
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://magzhan787.github.io/presentation/"))
            startActivity(i)
        }
        return binding.root
    }
}