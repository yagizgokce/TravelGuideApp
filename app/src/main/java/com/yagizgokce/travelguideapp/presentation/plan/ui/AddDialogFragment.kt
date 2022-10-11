package com.yagizgokce.travelguideapp.presentation.plan.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.FragmentAddDialogBinding
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel
import com.yagizgokce.travelguideapp.presentation.plan.viewmodel.TripPlanViewModel
import com.yagizgokce.travelguideapp.presentation.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentAddDialogBinding
    private lateinit var cityInput: String
    private lateinit var countryInput: String
    private lateinit var tripDate: String
    private lateinit var tripPlanModel:TripPlanModel

    private val  tripPlanViewModel: TripPlanViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_dialog,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
             cityInput = binding.editCityName.text.toString()
             countryInput = binding.editCountryName.text.toString()
             tripDate = binding.editDate.text.toString()
             tripPlanModel = TripPlanModel(cityInput,countryInput,tripDate)
             tripPlanViewModel.saveSql(tripPlanModel)
        }




    }

}