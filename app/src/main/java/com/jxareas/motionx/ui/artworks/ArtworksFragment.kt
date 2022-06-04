package com.jxareas.motionx.ui.artworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.fragment.app.viewModels
import com.jxareas.motionx.R
import com.jxareas.motionx.data.domain.model.Artwork
import com.jxareas.motionx.databinding.FragmentArtworksBinding
import com.jxareas.motionx.ui.adapters.ArtworkListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtworksFragment : Fragment() {

    private var _binding : FragmentArtworksBinding? = null
    private val binding : FragmentArtworksBinding
        get() = _binding!!

    private val viewModel : ArtworksFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentArtworksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.artworks.observe(viewLifecycleOwner) { artworks ->
            setupRecyclerView(artworks)
        }
    }

    private fun setupRecyclerView(artworks: List<Artwork>) : Unit = binding.run {
        recyclerView.adapter = ArtworkListAdapter().apply {
            submitList(artworks)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}