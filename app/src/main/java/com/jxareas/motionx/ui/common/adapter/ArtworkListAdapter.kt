package com.jxareas.motionx.ui.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.jxareas.motionx.databinding.ItemArtworkBinding
import com.jxareas.motionx.domain.model.Artwork
import com.jxareas.motionx.ui.common.callback.ArtworkDiffCallback
import com.jxareas.motionx.ui.common.listener.ArtworkAdapterListener
import com.jxareas.motionx.ui.common.viewholder.ArtworkViewHolder
import com.jxareas.motionx.utils.bind

class ArtworkListAdapter(private val listener: ArtworkAdapterListener) :
    ListAdapter<Artwork, ArtworkViewHolder>(
        AsyncDifferConfig.Builder(ArtworkDiffCallback).build()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworkViewHolder =
        ArtworkViewHolder(parent bind ItemArtworkBinding::inflate).apply {

            val artwork by lazy { currentList[bindingAdapterPosition] }

            itemView.setOnClickListener { root ->
                listener.onArtworkClicked(root, artwork)
            }

        }

    override fun onBindViewHolder(holder: ArtworkViewHolder, position: Int) =
        holder.bind(currentList[position])
}



