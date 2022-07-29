package com.example.pahlawannasional.utils

import android.content.Context
import android.util.Log
import com.example.pahlawannasional.responses.DaftarPahlawan
import com.example.pahlawannasional.responses.Pahlawan
import com.google.gson.Gson
import java.io.IOException

object HelperFunctions {
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}