package br.edu.ifsp.ads.pdm.pedrapapeltesouro

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Config(val numeroJogadores: Int = -1): Parcelable

