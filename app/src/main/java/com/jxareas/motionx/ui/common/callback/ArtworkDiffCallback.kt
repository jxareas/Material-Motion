package com.jxareas.motionx.ui.common.callback

import androidx.recyclerview.widget.DiffUtil
import com.jxareas.motionx.domain.model.Artwork

object ArtworkDiffCallback : DiffUtil.ItemCallback<Artwork>() {
    override fun areItemsTheSame(oldItem: Artwork, newItem: Artwork): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Artwork, newItem: Artwork): Boolean =
        oldItem.imageUrl == newItem.imageUrl
}