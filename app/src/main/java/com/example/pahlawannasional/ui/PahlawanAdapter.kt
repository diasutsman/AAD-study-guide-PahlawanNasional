package com.example.pahlawannasional.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.pahlawannasional.data.responses.Pahlawan
import com.example.pahlawannasional.databinding.ItemListPahlawanBinding

class PahlawanAdapter :
    ListAdapter<Pahlawan, PahlawanViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PahlawanViewHolder(
        ItemListPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        val pahlawan = getItem(position)
        pahlawan?.let { holder.bind(it) }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pahlawan>() {
            override fun areItemsTheSame(oldItem: Pahlawan, newItem: Pahlawan): Boolean =
                oldItem.hashCode() == newItem.hashCode()

            override fun areContentsTheSame(oldItem: Pahlawan, newItem: Pahlawan): Boolean =
                oldItem == newItem
        }
    }
}