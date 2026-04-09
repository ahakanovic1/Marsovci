package ba.unsa.etf.rma.rmaquizapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import ba.unsa.etf.rma.kvizapp.data.staticdata.KvizStaticData
import ba.unsa.etf.rma.kvizapp.ui.components.KvizCard

@Composable
fun KvizList(filter: String) {

    val quizzes = when (filter) {
        "Svi moji kvizovi" -> KvizStaticData.getUpisani()
        "Svi kvizovi" -> KvizStaticData.getAll()
        "Urađeni kvizovi" -> KvizStaticData.getDone()
        "Budući kvizovi" -> KvizStaticData.getFuture()
        "Prošli kvizovi (neurađeni)" ->
            KvizStaticData.getNotTaken()
        else -> KvizStaticData.getUpisani()
    }.sortedBy { it.datumPocetak }

    val quizRows = quizzes.chunked(2)

    LazyColumn(
        modifier = Modifier.testTag("listaKvizova")
    ) {
        items(quizRows) { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                rowItems.forEach { quiz ->
                    KvizCard(
                        kviz = quiz,
                        referentnoVrijeme =
                            KvizStaticData.getReferentDate(),
                        modifier = Modifier.weight(1f)
                    )
                }

                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}