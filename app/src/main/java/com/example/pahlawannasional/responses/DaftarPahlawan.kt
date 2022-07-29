package com.example.pahlawannasional.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DaftarPahlawan(
    @field:SerializedName("daftar_pahlawan")
    val daftarPahlawan: List<Pahlawan>? = null,
) : Parcelable
