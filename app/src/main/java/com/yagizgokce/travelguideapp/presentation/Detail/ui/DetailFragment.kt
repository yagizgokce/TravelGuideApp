package com.yagizgokce.travelguideapp.presentation.Detail.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.FragmentDetailBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.Detail.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val navArgs: DetailFragmentArgs? by navArgs()
    private lateinit var updateData: AllTravelListModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        binding.addbutton.setOnClickListener {
            addBookmark()
        }
        binding.backButton.setOnClickListener{
            back()
        }

    }

    private fun init() {
        setTravelDataDetailsByArgs()
        scrollText()

    }


   @SuppressLint("SetTextI18n")
   private fun setTravelDataDetailsByArgs() {
       navArgs?.let{
           binding.choosenTravel = it.travelData
           updateData = it.travelData
       }
       if( updateData.isBookmark == false){
           binding.addbutton.text = "Add Bookmark"
       }else{
           binding.addbutton.text = "Remove Bookmark"
       }
    }

    fun addBookmark(){
        updateData.isBookmark = updateData.isBookmark != true
        detailViewModel.addBookmark(updateData)
    }
    fun back(){
        findNavController().popBackStack()
    }
    fun scrollText(){
        binding.descriptionText.movementMethod = ScrollingMovementMethod()
    }

}