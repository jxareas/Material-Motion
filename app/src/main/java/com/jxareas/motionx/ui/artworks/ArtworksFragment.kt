package com.jxareas.motionx.ui.artworks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy
import com.jxareas.motionx.databinding.FragmentArtworksBinding
import com.jxareas.motionx.domain.model.Artwork
import com.jxareas.motionx.ui.common.adapter.ArtworkListAdapter
import com.jxareas.motionx.ui.common.listener.ArtworkAdapterListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtworksFragment : Fragment(), ArtworkAdapterListener {

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
        adapter = artworksAdapter.apply {
            stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }
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