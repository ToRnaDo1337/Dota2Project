package com.example.dota2.ui.aboutdota


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2.R
import com.example.dota2.adapter.ListAdapter
import com.example.dota2.data.model.Responsibility
import com.example.dota2.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ListAdapter
    private lateinit var recView:RecyclerView
    private lateinit var respList:ArrayList<Responsibility>

    lateinit var imageID: Array<Int>
    lateinit var respText: Array<String>
    lateinit var doneby: Array<String>




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(AboutFragmentModel::class.java)
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        val recyclerV = binding.rvList


//        val view = inflater.inflate(R.layout.fragment_about, container, false)
//
//        binding.rvList.layoutManager = LinearLayoutManager(activity)
//        binding.rvList.adapter = recyclerV.adapter



        val listView: TextView = binding.rulesText
        galleryViewModel.text.observe(viewLifecycleOwner) {
            listView.text = it.toString()
            val button: Button = binding.button1
            button.setOnClickListener{
                listView.visibility= View.INVISIBLE
            }
        }

        return root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDat()
        val layoutManager = LinearLayoutManager(context)
        recView= view.findViewById(R.id.rv_list)
        recView.layoutManager=layoutManager
        adapter= ListAdapter(respList)
        recView.adapter= adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initDat(){

        respList = arrayListOf<Responsibility>()
        imageID = arrayOf(
            R.drawable.dota_2_clockwerk_art_game,
            R.drawable.afkgaming_import_media_images_98013_626e3520ecaef8d456162f72037d41ec,
            R.drawable.bodyphoto,
            R.drawable.igry_ota_2_dota_2_risunki_21711,
        )
        respText= arrayOf(
            getString(R.string.affirmation1),
            getString(R.string.affirmation2),
            getString(R.string.affirmation3),
            getString(R.string.affirmation4),


        )
        doneby= arrayOf(
            getString(R.string.d1),
            getString(R.string.d2),
            getString(R.string.d3),
            getString(R.string.d4),

        )

    for (i in imageID.indices){
        val response = Responsibility(imageID[i],respText[i],doneby[i])
        respList.add(response)


    }




    }



}


