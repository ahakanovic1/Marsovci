package ba.unsa.etf.rma.kvizapp.data.staticdata

import ba.unsa.etf.rma.kvizapp.data.model.Kviz
import java.time.LocalDateTime

object KvizStaticData {
    private val sviKvizovi = listOf<Kviz>(
        // PLAVA - Urađen kviz (datumRada != null)
        Kviz(
            naziv = "Kviz 1",
            nazivPredmeta = "RMA",
            datumPocetak = LocalDateTime.of(2021, 3, 1, 0, 0),
            datumKraj = LocalDateTime.of(2021, 3, 15, 23, 59),
            datumRada = LocalDateTime.of(2021, 3, 10, 14, 30),
            trajanje = 15,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = 8.5f
        ),
        // ZELENA - Aktivan kviz (početak < referentno < kraj, datumRada == null)
        Kviz(
            naziv = "Kviz 2",
            nazivPredmeta = "RMA",
            datumPocetak = LocalDateTime.of(2021, 4, 5, 0, 0),
            datumKraj = LocalDateTime.of(2021, 4, 20, 23, 59),
            datumRada = null,
            trajanje = 20,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = null
        ),
        // ŽUTA - Budući kviz (početak > referentno)
        Kviz(
            naziv = "Spirala 3",
            nazivPredmeta = "RMA",
            datumPocetak = LocalDateTime.of(2021, 5, 1, 0, 0),
            datumKraj = LocalDateTime.of(2021, 5, 15, 23, 59),
            datumRada = null,
            trajanje = 25,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = null
        ),

        // CRVENA - Propušten kviz (kraj < referentno, datumRada == null)
        Kviz(
            naziv = "Kviz 0",
            nazivPredmeta = "RMA",
            datumPocetak = LocalDateTime.of(2021, 2, 1, 0, 0),
            datumKraj = LocalDateTime.of(2021, 2, 10, 23, 59),
            datumRada = null,
            trajanje = 10,
            nazivGrupe = "Grupa 2",
            osvojeniBodovi = null
        ),

        // Još jedan urađen za Grupu 2
        Kviz(
            naziv = "Kviz 1",
            nazivPredmeta = "RMA",
            datumPocetak = LocalDateTime.of(2021, 3, 5, 0, 0),
            datumKraj = LocalDateTime.of(2021, 3, 20, 23, 59),
            datumRada = LocalDateTime.of(2021, 3, 18, 10, 0),
            trajanje = 15,
            nazivGrupe = "Grupa 2",
            osvojeniBodovi = 12f
        ),

        // =====================
        // IM - NEUPISAN PREDMET
        // =====================
        Kviz(
            naziv = "Kviz 1",
            nazivPredmeta = "IM",
            datumPocetak = LocalDateTime.of(2021, 4, 1, 0, 0),
            datumKraj = LocalDateTime.of(2021, 4, 15, 23, 59),
            datumRada = null,
            trajanje = 30,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = null
        ),
        Kviz(
            naziv = "Kviz 2",
            nazivPredmeta = "IM",
            datumPocetak = LocalDateTime.of(2021, 5, 1, 0, 0),
            datumKraj = LocalDateTime.of(2021, 5, 10, 23, 59),
            datumRada = null,
            trajanje = 25,
            nazivGrupe = "Grupa 2",
            osvojeniBodovi = null
        ),

        // =====================
        // DM - NEUPISAN PREDMET
        // =====================
        Kviz(
            naziv = "Kviz 1",
            nazivPredmeta = "DM",
            datumPocetak = LocalDateTime.of(2021, 3, 10, 0, 0),
            datumKraj = LocalDateTime.of(2021, 3, 25, 23, 59),
            datumRada = null,
            trajanje = 20,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = null
        ),
        Kviz(
            naziv = "Kviz 2",
            nazivPredmeta = "DM",
            datumPocetak = LocalDateTime.of(2021, 4, 5, 0, 0),
            datumKraj = LocalDateTime.of(2021, 4, 20, 23, 59),
            datumRada = null,
            trajanje = 15,
            nazivGrupe = "Grupa 2",
            osvojeniBodovi = null
        ),

        // =====================
        // OIS - NEUPISAN PREDMET
        // =====================
        Kviz(
            naziv = "Parcijalni 1",
            nazivPredmeta = "OIS",
            datumPocetak = LocalDateTime.of(2021, 4, 8, 0, 0),
            datumKraj = LocalDateTime.of(2021, 4, 22, 23, 59),
            datumRada = null,
            trajanje = 45,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = null
        ),
        Kviz(
            naziv = "Parcijalni 2",
            nazivPredmeta = "OIS",
            datumPocetak = LocalDateTime.of(2021, 5, 15, 0, 0),
            datumKraj = LocalDateTime.of(2021, 5, 30, 23, 59),
            datumRada = null,
            trajanje = 45,
            nazivGrupe = "Grupa 2",
            osvojeniBodovi = null
        ),

        // =====================
        // TP - NEUPISAN PREDMET
        // =====================
        Kviz(
            naziv = "Test 1",
            nazivPredmeta = "TP",
            datumPocetak = LocalDateTime.of(2021, 3, 15, 0, 0),
            datumKraj = LocalDateTime.of(2021, 3, 30, 23, 59),
            datumRada = null,
            trajanje = 30,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = null
        ),
        Kviz(
            naziv = "Test 2",
            nazivPredmeta = "TP",
            datumPocetak = LocalDateTime.of(2021, 4, 20, 0, 0),
            datumKraj = LocalDateTime.of(2021, 5, 5, 23, 59),
            datumRada = null,
            trajanje = 30,
            nazivGrupe = "Grupa 2",
            osvojeniBodovi = null
        ),

        // =====================
        // SP - NEUPISAN PREDMET
        // =====================
        Kviz(
            naziv = "Kviz A",
            nazivPredmeta = "SP",
            datumPocetak = LocalDateTime.of(2021, 2, 20, 0, 0),
            datumKraj = LocalDateTime.of(2021, 3, 5, 23, 59),
            datumRada = null,
            trajanje = 20,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = null
        ),
        Kviz(
            naziv = "Kviz B",
            nazivPredmeta = "SP",
            datumPocetak = LocalDateTime.of(2021, 4, 1, 0, 0),
            datumKraj = LocalDateTime.of(2021, 4, 15, 23, 59),
            datumRada = null,
            trajanje = 25,
            nazivGrupe = "Grupa 2",
            osvojeniBodovi = null
        ),

        // =====================
        // ASP - NEUPISAN PREDMET
        // =====================
        Kviz(
            naziv = "Algoritmi 1",
            nazivPredmeta = "ASP",
            datumPocetak = LocalDateTime.of(2021, 3, 25, 0, 0),
            datumKraj = LocalDateTime.of(2021, 4, 8, 23, 59),
            datumRada = null,
            trajanje = 35,
            nazivGrupe = "Grupa 1",
            osvojeniBodovi = null
        ),
        Kviz(
            naziv = "Algoritmi 2",
            nazivPredmeta = "ASP",
            datumPocetak = LocalDateTime.of(2021, 5, 10, 0, 0),
            datumKraj = LocalDateTime.of(2021, 5, 25, 23, 59),
            datumRada = null,
            trajanje = 40,
            nazivGrupe = "Grupa 2",
            osvojeniBodovi = null
        )
    )

    fun getReferentDate() : LocalDateTime = LocalDateTime.of(2021, 4, 10, 12, 0)

    fun getAll() : List<Kviz> = sviKvizovi

    fun getUpisani() : List<Kviz>{
        val upisaniPredmeti=PredmetStaticData.getUpisani().map{it.naziv}
        return sviKvizovi.filter{it.nazivPredmeta in upisaniPredmeti}
    }

    fun getDone() : List<Kviz> =
        getUpisani().filter { it.datumRada != null }

    fun getFuture() : List<Kviz> =
        getUpisani().filter { it.datumRada == null && it.datumPocetak.isAfter(getReferentDate()) }

    fun getNotTaken() : List<Kviz> =
        getUpisani().filter { it.datumRada == null && it.datumKraj.isBefore(getReferentDate()) }

    fun getActive() : List<Kviz> =
        getUpisani().filter { it.datumRada == null &&
                it.datumPocetak.isAfter(getReferentDate()) &&
                it.datumKraj.isBefore(getReferentDate())
        }
    fun getByPredmet(nazivPredmeta : String) =
        sviKvizovi.filter { it.nazivPredmeta == nazivPredmeta }
}