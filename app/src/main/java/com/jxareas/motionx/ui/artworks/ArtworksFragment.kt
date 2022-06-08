package com.jxareas.motionx.ui.artworks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.MaterialFadeThrough
import com.jxareas.motionx.R
import com.jxareas.motionx.data.domain.model.Artwork
import com.jxareas.motionx.databinding.FragmentArtworksBinding
import com.jxareas.motionx.ui.adapters.ArtworkListAdapter
import com.jxareas.motionx.utils.safeNavigate
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArtworksFragment : Fragment(), ArtworkListAdapter.ArtworkAdapterListener {

    private var _binding: FragmentArtworksBinding? = null
    private val binding: FragmentArtworksBinding
        get() = _binding!!

    private val viewModel: ArtworksFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
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
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.artworks.observe(viewLifecycleOwner) { artworks ->
            (binding.recyclerView.adapter as ArtworkListAdapter).submitList(artworks)
        }
    }

    private fun setupRecyclerView(): Unit = binding.recyclerView.run {
        layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        adapter = ArtworkListAdapter(this@ArtworksFragment).apply {
            stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onArtworkClicked(cardView: View, artwork: Artwork) {
        val transitionName = getString(R.string.artwork_detail_transition)
        val extra = FragmentNavigatorExtras(cardView to transitionName)
        val direction = ArtworksFragmentDirections.actionArtworkToDetail(artwork.id)
        findNavController().safeNavigate(direction, extra)
    }


}