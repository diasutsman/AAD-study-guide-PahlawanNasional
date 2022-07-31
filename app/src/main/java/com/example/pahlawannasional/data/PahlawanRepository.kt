package com.example.pahlawannasional.data

import android.content.Context
import com.example.pahlawannasional.data.responses.DaftarPahlawan
import com.example.pahlawannasional.data.responses.Pahlawan
import com.example.pahlawannasional.utils.HelperFunctions
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PahlawanRepository(context: Context) {
    val pahlawanStream: Flow<List<Pahlawan>> = flowOf(
        Gson()
            .fromJson(
                HelperFunctions.getJsonDataFromAsset(context, FILENAME).toString(),
                DaftarPahlawan::class.java
            ).daftarPahlawan as List<Pahlawan>
    )

    companion object {
        private const val FILENAME = "pahlawan_nasional.json"
    }
}