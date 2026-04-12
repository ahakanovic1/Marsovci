package ba.unsa.etf.rma.kvizapp.data.staticdata

import ba.unsa.etf.rma.kvizapp.data.model.Kviz
import java.time.LocalDateTime

object KvizStaticData {
        fun getReferentDate() : LocalDateTime = LocalDateTime.of(2021, 4, 10, 12, 0)


        private val sviKvizovi = listOf(

            // RMA - UPISANI PREDMET
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

            Kviz(
                naziv = "Kviz 3",
                nazivPredmeta = "RMA",
                datumPocetak = LocalDateTime.of(2021, 5, 1, 0, 0),
                datumKraj = LocalDateTime.of(2021, 5, 15, 23, 59),
                datumRada = null,
                trajanje = 25,
                nazivGrupe = "Grupa 2",
                osvojeniBodovi = null
            ),

            Kviz(
                naziv = "Kviz 2",
                nazivPredmeta = "RMA",
                datumPocetak = LocalDateTime.of(2021, 2, 1, 0, 0),
                datumKraj = LocalDateTime.of(2021, 2, 10, 23, 59),
                datumRada = null,
                trajanje = 10,
                nazivGrupe = "Grupa 2",
                osvojeniBodovi = null
            ),

            // IM
            Kviz(
                naziv = "Test Kviz",
                nazivPredmeta = "IM",
                datumPocetak = LocalDateTime.of(2021, 4, 15, 0, 0),
                datumKraj = LocalDateTime.of(2021, 4, 30, 23, 59),
                datumRada = null,
                trajanje = 30,
                nazivGrupe = "Grupa 1",
                osvojeniBodovi = null
            ),
            Kviz(
                naziv = "Test Kviz",
                nazivPredmeta = "IM",
                datumPocetak = LocalDateTime.of(2021, 5, 1, 0, 0),
                datumKraj = LocalDateTime.of(2021, 5, 10, 23, 59),
                datumRada = null,
                trajanje = 25,
                nazivGrupe = "Grupa 3",
                osvojeniBodovi = null
            ),

           //DM
            Kviz(
                naziv = "Kviz 10",
                nazivPredmeta = "DM",
                datumPocetak = LocalDateTime.of(2021, 4, 12, 0, 0),
                datumKraj = LocalDateTime.of(2021, 4, 25, 23, 59),
                datumRada = null,
                trajanje = 20,
                nazivGrupe = "Grupa 2",
                osvojeniBodovi = null
            ),
            Kviz(
                naziv = "Kviz 9",
                nazivPredmeta = "DM",
                datumPocetak = LocalDateTime.of(2021, 4, 20, 0, 0),
                datumKraj = LocalDateTime.of(2021, 5, 1, 23, 59),
                datumRada = null,
                trajanje = 15,
                nazivGrupe = "Grupa 4",
                osvojeniBodovi = null
            ),

            // TP
            Kviz(
                naziv = "Kviz 12",
                nazivPredmeta = "TP",
                datumPocetak = LocalDateTime.of(2021, 4, 18, 0, 0),
                datumKraj = LocalDateTime.of(2021, 4, 28, 23, 59),
                datumRada = null,
                trajanje = 30,
                nazivGrupe = "Grupa 1",
                osvojeniBodovi = null
            ),

            Kviz(
                naziv = "Kviz 5",
                nazivPredmeta = "TP",
                datumPocetak = LocalDateTime.of(2021, 5, 5, 0, 0),
                datumKraj = LocalDateTime.of(2021, 5, 15, 23, 59),
                datumRada = null,
                trajanje = 30,
                nazivGrupe = "Grupa 2",
                osvojeniBodovi = null
            ),

            // SP
            Kviz(
                naziv = "Kviz 6",
                nazivPredmeta = "SP",
                datumPocetak = LocalDateTime.of(2021, 1, 13, 0, 0),
                datumKraj = LocalDateTime.of(2021, 5, 22, 23, 59),
                datumRada = null,
                trajanje = 20,
                nazivGrupe = "Grupa 5",
                osvojeniBodovi = null
            ),
            Kviz(
                naziv = "Kviz 2",
                nazivPredmeta = "SP",
                datumPocetak = LocalDateTime.of(2021, 5, 1, 0, 0),
                datumKraj = LocalDateTime.of(2021, 5, 12, 23, 59),
                datumRada =LocalDateTime.of(2021, 5, 10, 23, 59),
                trajanje = 25,
                nazivGrupe = "Grupa 2",
                osvojeniBodovi = null
            ),

            // ASP
            Kviz(
                naziv = "Algoritmi 1",
                nazivPredmeta = "ASP",
                datumPocetak = LocalDateTime.of(2021, 3, 16, 0, 0),
                datumKraj = LocalDateTime.of(2021, 5, 29, 23, 59),
                datumRada = null,
                trajanje = 35,
                nazivGrupe = "Grupa 6",
                osvojeniBodovi = null
            ),
            Kviz(
                naziv = "Algoritmi 2",
                nazivPredmeta = "ASP",
                datumPocetak = LocalDateTime.of(2021, 2, 10, 0, 0),
                datumKraj = LocalDateTime.of(2021, 2, 25, 3, 59),
                datumRada = LocalDateTime.of(2021, 2, 25, 23, 59),
                trajanje = 40,
                nazivGrupe = "Grupa 7",
                osvojeniBodovi = null
            )
        )

        fun getAll(): List<Kviz> = sviKvizovi

        fun getUpisani(): List<Kviz> {
            val upisaniPredmeti = PredmetStaticData.getUpisani().map { it.naziv }
            return sviKvizovi.filter { it.nazivPredmeta in upisaniPredmeti }
        }

        fun getDone(): List<Kviz> =
            getUpisani().filter { it.datumRada != null }

        fun getFuture(): List<Kviz> =
            getUpisani().filter {
                it.datumRada == null &&
                        it.datumPocetak.isAfter(getReferentDate())
            }

        fun getNotTaken(): List<Kviz> =
            getUpisani().filter {
                it.datumRada == null &&
                        it.datumKraj.isBefore(getReferentDate())
            }

        fun getActive(): List<Kviz> =
            getUpisani().filter {
                it.datumRada == null &&
                        getReferentDate().isAfter(it.datumPocetak) &&
                        getReferentDate().isBefore(it.datumKraj)
            }

        fun getByPredmet(nazivPredmeta: String): List<Kviz> =
            sviKvizovi.filter { it.nazivPredmeta == nazivPredmeta }
    }