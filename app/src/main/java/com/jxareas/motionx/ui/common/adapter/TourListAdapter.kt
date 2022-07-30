package com.jxareas.motionx.ui.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.jxareas.motionx.databinding.ItemTourBinding
import com.jxareas.motionx.domain.model.Tour
import com.jxareas.motionx.ui.common.callback.TourDiffCallback
import com.jxareas.motionx.ui.common.listener.TourAdapterListener
import com.jxareas.motionx.ui.common.viewholder.TourViewHolder
import com.jxareas.motionx.utils.bind

class TourListAdapter(private val listener: TourAdapterListener) :
    ListAdapter<Tour, TourViewHolder>(
        AsyncDifferConfig.Builder(TourDiffCallback).build()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder =
        TourViewHolder(parent bind ItemTourBinding::inflate).apply {
            val tour by lazy { currentList[bindingAdapterPosition] }

            itemView.setOnClickListener { root ->
                listener.onArtworkClicked(root, tour)
            }

        }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) =
        holder.bind(currentList[position])
}