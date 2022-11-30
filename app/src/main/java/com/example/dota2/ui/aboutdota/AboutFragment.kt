package com.example.dota2.ui.aboutdota


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2.R
import com.example.dota2.databinding.ActivityMainBinding
import com.example.dota2.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val galleryViewModel =
            ViewModelProvider(this).get(AboutFragmentModel::class.java)

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root




        val textView: TextView = binding.rulesText
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
            val button: Button = binding.button1
            button.setOnClickListener{
                textView.visibility= View.INVISIBLE
            }
        }

        return root


    }







    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}


