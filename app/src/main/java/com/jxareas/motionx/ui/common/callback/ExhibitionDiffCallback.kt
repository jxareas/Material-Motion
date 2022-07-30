package com.jxareas.motionx.ui.common.callback

import androidx.recyclerview.widget.DiffUtil
import com.jxareas.motionx.domain.model.Exhibition

object ExhibitionDiffCallback : DiffUtil.ItemCallback<Exhibition>() {
    override fun areItemsTheSame(oldItem: Exhibition, newItem: Exhibition): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Exhibition, newItem: Exhibition): Boolean =
        oldItem.imageUrl == newItem.imageUrl
}