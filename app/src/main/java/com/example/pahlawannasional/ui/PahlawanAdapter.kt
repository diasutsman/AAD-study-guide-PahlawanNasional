package com.example.pahlawannasional.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawannasional.databinding.ItemListPahlawanBinding
import com.example.pahlawannasional.responses.DaftarPahlawan
import com.example.pahlawannasional.responses.Pahlawan
import com.example.pahlawannasional.utils.HelperFunctions.getJsonDataFromAsset
import com.google.gson.Gson

class PahlawanAdapter(context: Context) :
    RecyclerView.Adapter<PahlawanViewHolder>() {

    private val pahlawanList: List<Pahlawan> = Gson()
        .fromJson(
            getJsonDataFromAsset(context, FILENAME).toString(),
            DaftarPahlawan::class.java
        ).daftarPahlawan as List<Pahlawan>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PahlawanViewHolder(
        ItemListPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        holder.bind(pahlawanList[position])
    }

    override fun getItemCount() = pahlawanList.size

    companion object {
        private const val FILENAME = "pahlawan_nasional.json"
    }
}