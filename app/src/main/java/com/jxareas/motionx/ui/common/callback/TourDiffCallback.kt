package com.jxareas.motionx.ui.common.callback

import androidx.recyclerview.widget.DiffUtil
import com.jxareas.motionx.domain.model.Tour

object TourDiffCallback : DiffUtil.ItemCallback<Tour>() {
    override fun areItemsTheSame(oldItem: Tour, newItem: Tour): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Tour, newItem: Tour): Boolean =
        oldItem.image == newItem.image
}