package com.jxareas.motionx.ui.artworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import com.google.android.material.transition.MaterialElevationScale
import com.google.android.material.transition.MaterialFade
import com.jxareas.motionx.R
import com.jxareas.motionx.databinding.FragmentArtworksBinding
import com.jxareas.motionx.domain.model.Artwork
import com.jxareas.motionx.ui.adapters.ArtworkListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtworksFragment : Fragment(), ArtworkListAdapter.ArtworkAdapterListener {

    private var _binding: FragmentArtworksBinding? = null
    private val binding: FragmentArtworksBinding
        get() = _binding!!

    private val artworksAdapter = ArtworkListAdapter(this@ArtworksFragment)
    private val viewModel: ArtworksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentArtworksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() = binding.recyclerViewArtworks.run {
        adapter = artworksAdapter
    }

    private fun setupObservers() {
        viewModel.artworks.observe(viewLifecycleOwner) { listOfArtworks ->
            artworksAdapter.submitList(listOfArtworks)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onArtworkClicked(cardView: View, artwork: Artwork) {
        // TODO: Navigate to Artworks Detail Screen
        //
    }


}