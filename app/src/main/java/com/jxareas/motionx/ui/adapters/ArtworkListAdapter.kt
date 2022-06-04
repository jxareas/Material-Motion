package com.jxareas.motionx.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jxareas.motionx.data.domain.model.Artwork
import com.jxareas.motionx.databinding.ItemArtworkBinding
import com.jxareas.motionx.ui.adapters.ArtworkListAdapter.ArtworkViewHolder
import com.jxareas.motionx.utils.bind

class ArtworkListAdapter : ListAdapter<Artwork, ArtworkViewHolder>(diffConfig) {

    private companion object {
        private object ArtworkDiffUtil : DiffUtil.ItemCallback<Artwork>() {
            override fun areItemsTheSame(oldItem: Artwork, newItem: Artwork): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Artwork, newItem: Artwork): Boolean =
                oldItem.imageUrl == newItem.imageUrl

        }

        val diffConfig = AsyncDifferConfig.Builder(ArtworkDiffUtil).build()


    }

    inner class ArtworkViewHolder(private val binding: ItemArtworkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        internal fun bind(artwork: Artwork): Unit = binding.run {
            Glide.with(root.context)
                .load(artwork.imageUrl)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworkViewHolder =
        ArtworkViewHolder(parent bind ItemArtworkBinding::inflate)

    override fun onBindViewHolder(holder: ArtworkViewHolder, position: Int) =
        holder.bind(currentList[position])

}