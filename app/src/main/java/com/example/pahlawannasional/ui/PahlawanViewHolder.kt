package com.example.pahlawannasional.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawannasional.R
import com.example.pahlawannasional.databinding.ItemListPahlawanBinding
import com.example.pahlawannasional.responses.Pahlawan

class PahlawanViewHolder(private val binding: ItemListPahlawanBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.apply {
            listOf<View>(tvDescPahlawan, tvMoreLess)
                .forEach { it.setOnClickListener { toggleDescLines() } }
        }
    }

    private fun toggleDescLines() {
        binding.apply {
            val context = tvMoreLess.context
            tvMoreLess.text = context.getString(if (tvDescPahlawan.maxLines == 5) {
                tvDescPahlawan.maxLines = Int.MAX_VALUE
                R.string.txt_show_less
            } else {
                tvDescPahlawan.maxLines = 5
                R.string.txt_show_more
            })
        }
    }

    fun bind(pahlawan: Pahlawan) {
        binding.pahlawan = pahlawan
    }
}