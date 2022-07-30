package com.jxareas.motionx.ui.common.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jxareas.motionx.databinding.ItemTourBinding
import com.jxareas.motionx.domain.model.Tour

class TourViewHolder(private val binding: ItemTourBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(tour: Tour) = binding.run {

        Glide.with(root.context)
            .load(tour.imageUrl)
            .into(imageViewTourPhoto)


        textViewTourName.text = tour.title
    }

}