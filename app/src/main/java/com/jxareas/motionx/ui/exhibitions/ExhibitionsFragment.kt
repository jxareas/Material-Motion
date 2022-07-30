package com.jxareas.motionx.ui.exhibitions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jxareas.motionx.databinding.FragmentExhibitionsBinding
import com.jxareas.motionx.domain.model.Exhibition
import com.jxareas.motionx.ui.common.adapter.ExhibitionListAdapter
import com.jxareas.motionx.ui.common.listener.ExhibitionAdapterListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExhibitionsFragment : Fragment(), ExhibitionAdapterListener {
    private var _binding: FragmentExhibitionsBinding? = null
    private val binding: FragmentExhibitionsBinding
        get() = _binding!!

    private val exhibitionAdapter: ExhibitionListAdapter = ExhibitionListAdapter(this)
    private val viewModel: ExhibitionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentExhibitionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.exhibitions.observe(viewLifecycleOwner) { listOfExhibitions ->
            listOfExhibitions?.let { exhibitionAdapter.submitList(it) }
        }
    }

    private fun setupRecyclerView() = binding.recyclerViewExhibitions.run {
        adapter = exhibitionAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View, item: Exhibition) {
        // TODO: Navigate to details screen
    }


}