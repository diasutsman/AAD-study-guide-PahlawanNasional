package com.example.pahlawannasional.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pahlawannasional.R
import com.example.pahlawannasional.databinding.ItemListPahlawanBinding
import com.example.pahlawannasional.responses.DaftarPahlawan
import com.example.pahlawannasional.responses.Pahlawan
import com.example.pahlawannasional.utils.HelperFunctions.getJsonDataFromAsset
import com.google.gson.Gson

class PahlawanAdapter(context: Context) :
    RecyclerView.Adapter<PahlawanAdapter.PahlawanViewHolder>() {
    class PahlawanViewHolder(val binding: ItemListPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val pahlawanList: List<Pahlawan> = Gson()
        .fromJson(
            getJsonDataFromAsset(context, FILENAME).toString(),
            DaftarPahlawan::class.java
        ).daftarPahlawan as List<Pahlawan>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PahlawanViewHolder(
        ItemListPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        holder.binding.apply {
            tvNamePahlawan.text = pahlawanList[position].nama
            Glide.with(ivImagePahlawan)
                .load(pahlawanList[position].img)
                .placeholder(R.drawable.ic_broken_image)
                .error(R.drawable.ic_broken_image)
                .into(ivImagePahlawan)
        }
    }

    override fun getItemCount() = pahlawanList.size

    companion object {
        private const val FILENAME = "pahlawan_nasional.json"
    }
}