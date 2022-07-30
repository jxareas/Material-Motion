package com.jxareas.motionx.ui.common.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jxareas.motionx.databinding.ItemExhibitionBinding
import com.jxareas.motionx.domain.model.Exhibition

class ExhibitionViewHolder(private val binding: ItemExhibitionBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(exhibition: Exhibition) = binding.run {
        Glide.with(root.context)
            .load(exhibition.imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageViewExhibitionPhoto)

        textViewExhibitionName.text = exhibition.title
    }


}