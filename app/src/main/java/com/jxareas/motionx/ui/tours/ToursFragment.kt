package com.jxareas.motionx.ui.tours


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jxareas.motionx.databinding.FragmentToursBinding
import com.jxareas.motionx.domain.model.Tour
import com.jxareas.motionx.ui.common.adapter.TourListAdapter
import com.jxareas.motionx.ui.common.listener.TourAdapterListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToursFragment : Fragment(), TourAdapterListener {
    private var _binding: FragmentToursBinding? = null
    private val binding: FragmentToursBinding
        get() = _binding!!

    private val toursAdapter = TourListAdapter(this@ToursFragment)
    private val viewModel: ToursViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentToursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.tours.observe(viewLifecycleOwner) { listOfTours ->
            toursAdapter.submitList(listOfTours)
        }
    }

    private fun setupRecyclerView() = binding.recyclerViewTours.run {
        adapter = toursAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View, item: Tour) {
        //
    }


}