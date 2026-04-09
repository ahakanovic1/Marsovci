package ba.unsa.etf.rma.kvizapp.data.staticdata

import ba.unsa.etf.rma.kvizapp.data.model.Grupa

object GrupaStaticData {
    private val grupe = listOf<Grupa>(
        //grupe za predmet RMA
        Grupa("Grupa 1","RMA"),
        Grupa("Grupa 2","RMA"),
        //grupe za IM
        Grupa("Grupa 3","IM"),
        Grupa("Grupa 2","IM"),
        //Grupe za MLTI
        Grupa("Grupa 4","MLTI"),
        Grupa("Grupa 1","MLTI"),
        // Grupe za DM
        Grupa("Grupa 1", "DM"),
        Grupa("Grupa 2", "DM"),
        // Grupe za SP
        Grupa("Grupa 1", "SP"),
        Grupa("Grupa 2", "SP"),
        // ASP grupe
        Grupa("Grupa 1", "ASP"),
        Grupa("Grupa 2", "ASP"),
        // VI grupe
        Grupa("Grupa 3", "VI"),
        Grupa("Grupa 4", "VI"),
    )

    fun getAll() : List<Grupa> = grupe
    fun getUpisani(nazivPredmet : String) : List<Grupa> = grupe.filter{it.nazivPredmeta==nazivPredmet}

    fun getGrupaFromPredmet (nazivPredmeta : String) : List<Grupa> = grupe.filter { it.nazivPredmeta == nazivPredmeta }
}
