package ba.unsa.etf.rma.kvizapp.data.model

import java.time.LocalDateTime

data class Kviz(
    val naziv: String,
    val nazivPredmeta: String,
    val datumPocetak: LocalDateTime,
    val datumKraj: LocalDateTime,
    val datumRada: LocalDateTime?=null,
    val trajanje: Int,
    val nazivGrupe: String,
    val osvojeniBodovi: Float?=null
)
