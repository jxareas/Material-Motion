package com.jxareas.motionx.ui.artworks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jxareas.motionx.data.domain.model.Artwork
import com.jxareas.motionx.databinding.FragmentArtworkDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtworkDetailFragment : Fragment() {

    private var _binding : FragmentArtworkDetailBinding? = null
    private val binding : FragmentArtworkDetailBinding
        get()= _binding!!

    private val viewModel : ArtworkDetailFragmentViewModel by viewModels()
    private val args : ArtworkDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentArtworkDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchArtworkById(args.id)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.artwork.observe(viewLifecycleOwner) { artwork : Artwork ->
            bindData(artwork)
        }
    }

    private fun bindData(artwork: Artwork) : Unit = binding.run {
        Glide.with(root.context)
            .load(artwork.imageUrl)
            .into(imageViewArtwork)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}