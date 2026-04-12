package ba.unsa.etf.rma.kvizapp.data.staticdata

import ba.unsa.etf.rma.kvizapp.data.model.Predmet

object PredmetStaticData {

    private val sviPredmeti= listOf<Predmet>(
        // Predmeti na koje je korisnik UPISAN
        Predmet("RMA", 3),

        // Predmeti na koje korisnik NIJE upisan (min 3)
        Predmet("IM", 1),
        Predmet("DM", 2),
        Predmet("TP", 1),
        Predmet("SP", 2),
        Predmet("ASP", 2),
        Predmet("VI", 3),
        Predmet("RV", 4),
        Predmet("UIS", 5)
    )

    private val upisaniPredmeti = mutableListOf<Predmet>(
        Predmet("RMA",3)
    )

    fun getAll()  : List<Predmet> = sviPredmeti

    fun getUpisani()  : List<Predmet> = upisaniPredmeti

    fun getByGodina(godina: Int) : List<Predmet> =
        sviPredmeti.filter { it.godina == godina }

    fun getNeupisaniByGodina(godina: Int) : List<Predmet> =
        sviPredmeti.filter { it.godina==godina && !upisaniPredmeti.contains(it) }

    fun upisiPredmet(predmet : Predmet) {
        if(!upisaniPredmeti.contains((predmet)))
            upisaniPredmeti.add(predmet)
    }

    fun isUpisan(predmet : Predmet) : Boolean = upisaniPredmeti.contains(predmet)
}