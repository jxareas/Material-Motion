package com.jxareas.motionx.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jxareas.motionx.data.domain.model.Artwork
import com.jxareas.motionx.databinding.ItemArtworkBinding
import com.jxareas.motionx.ui.adapters.ArtworkListAdapter.ArtworkViewHolder
import com.jxareas.motionx.utils.bind

class ArtworkListAdapter(private val listener: ArtworkAdapterListener) :
    ListAdapter<Artwork, ArtworkViewHolder>(diffConfig) {


    interface ArtworkAdapterListener {
        fun onArtworkClicked(cardView: View, artwork: Artwork)
    }

    private companion object {
        private object ArtworkDiffUtil : DiffUtil.ItemCallback<Artwork>() {
            override fun areItemsTheSame(oldItem: Artwork, newItem: Artwork): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Artwork, newItem: Artwork): Boolean =
                oldItem.imageUrl == newItem.imageUrl

        }

        val diffConfig = AsyncDifferConfig.Builder(ArtworkDiffUtil).build()

    }

    inner class ArtworkViewHolder(
        private val binding: ItemArtworkBinding,
        private val listener: ArtworkAdapterListener,
    ) :
        RecyclerView.ViewHolder(binding.root) {



        internal fun bind(artwork: Artwork): Unit = binding.run {

            Glide.with(root.context)
                .load(artwork.imageUrl)
                .into(imageView)

            ViewCompat.setTransitionName(root, "shared_element${artwork.id}")

            root.setOnClickListener {
                listener.onArtworkClicked(it, artwork)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworkViewHolder =
        ArtworkViewHolder(parent bind ItemArtworkBinding::inflate, listener)

    override fun onBindViewHolder(holder: ArtworkViewHolder, position: Int) =
        holder.bind(currentList[position])

}