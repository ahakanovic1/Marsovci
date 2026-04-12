package ba.unsa.etf.rma.kvizapp.data.staticdata

import ba.unsa.etf.rma.kvizapp.data.model.Grupa

object GrupaStaticData {
    private val grupe = listOf<Grupa>(
        // RMA (upisan predmet)
        Grupa("Grupa 1", "RMA"),
        Grupa("Grupa 2", "RMA"),

        // IM
        Grupa("Grupa 3", "IM"),
        Grupa("Grupa 1", "IM"),

        // DM
        Grupa("Grupa 2", "DM"),
        Grupa("Grupa 4", "DM"),

        // TP
        Grupa("Grupa 1", "TP"),
        Grupa("Grupa 2", "TP"),

        // SP
        Grupa("Grupa 5", "SP"),
        Grupa("Grupa 2", "SP"),

        // ASP
        Grupa("Grupa 6", "ASP"),
        Grupa("Grupa 7", "ASP"),

        // VI
        Grupa("Grupa 1", "VI"),
        Grupa("Grupa 2", "VI"),

        // RV
        Grupa("Grupa 1", "RV"),
        Grupa("Grupa 2", "RV"),

        // UIS
        Grupa("Grupa 1", "UIS"),
        Grupa("Grupa 2", "UIS")
    )

    fun getAll() : List<Grupa> = grupe
    fun getUpisani(nazivPredmet : String) : List<Grupa> = grupe.filter{it.nazivPredmeta==nazivPredmet}

    fun getGrupaFromPredmet (nazivPredmeta : String) : List<Grupa> = grupe.filter { it.nazivPredmeta == nazivPredmeta }
}
