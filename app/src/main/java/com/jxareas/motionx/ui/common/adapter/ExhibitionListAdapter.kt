package com.jxareas.motionx.ui.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.jxareas.motionx.databinding.ItemExhibitionBinding
import com.jxareas.motionx.domain.model.Exhibition
import com.jxareas.motionx.ui.common.callback.ExhibitionDiffCallback
import com.jxareas.motionx.ui.common.listener.ExhibitionAdapterListener
import com.jxareas.motionx.ui.common.viewholder.ExhibitionViewHolder
import com.jxareas.motionx.utils.bind


class ExhibitionListAdapter(private val listener: ExhibitionAdapterListener) :
    ListAdapter<Exhibition, ExhibitionViewHolder>(
        AsyncDifferConfig.Builder(ExhibitionDiffCallback).build()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitionViewHolder =
        ExhibitionViewHolder(parent bind ItemExhibitionBinding::inflate).apply {
            val exhibition by lazy {
                currentList[bindingAdapterPosition]
            }

            itemView.setOnClickListener { root ->
                listener.onClick(root, exhibition)
            }

        }

    override fun onBindViewHolder(holder: ExhibitionViewHolder, position: Int) =
        holder.bind(currentList[position])

}