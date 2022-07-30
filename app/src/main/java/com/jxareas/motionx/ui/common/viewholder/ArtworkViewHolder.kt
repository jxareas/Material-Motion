package com.jxareas.motionx.ui.common.viewholder

import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.jxareas.motionx.R
import com.jxareas.motionx.databinding.ItemArtworkBinding
import com.jxareas.motionx.domain.model.Artwork

class ArtworkViewHolder(private val binding: ItemArtworkBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(artwork: Artwork) = binding.run {

        val defaultRequestOptions by lazy {
            RequestOptions()
                .placeholder(R.drawable.course_image_placeholder)
        }



        Glide.with(root.context)
            .applyDefaultRequestOptions(defaultRequestOptions)
            .load(artwork.imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)


        ViewCompat.setTransitionName(root, "shared_element${artwork.id}")


    }

}