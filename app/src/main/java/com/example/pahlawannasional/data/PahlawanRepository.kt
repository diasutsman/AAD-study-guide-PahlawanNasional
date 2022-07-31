package com.example.pahlawannasional.data

import android.content.Context
import android.util.Log
import com.example.pahlawannasional.data.responses.DaftarPahlawan
import com.example.pahlawannasional.data.responses.Pahlawan
import com.example.pahlawannasional.utils.HelperFunctions
import com.google.gson.Gson

class PahlawanRepository(context: Context) {
    private val pahlawanList: List<Pahlawan> =
        Gson()
            .fromJson(
                HelperFunctions.getJsonDataFromAsset(context, FILENAME).toString(),
                DaftarPahlawan::class.java
            ).daftarPahlawan?.mapIndexed { i, it -> it.copy(id = i) } as List<Pahlawan>


    fun pahlawanPagingSource() : PahlawanPagingSource {
        Log.d("PahlawanRepository", pahlawanList.size.toString())
        return PahlawanPagingSource(pahlawanList)
    }

    companion object {
        private const val FILENAME = "pahlawan_nasional.json"
    }
}