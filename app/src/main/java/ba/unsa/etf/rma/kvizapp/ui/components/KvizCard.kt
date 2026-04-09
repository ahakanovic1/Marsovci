package ba.unsa.etf.rma.kvizapp.ui.components

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ba.unsa.etf.rma.kvizapp.data.model.Kviz
import ba.unsa.etf.rma.kvizapp.data.staticdata.KvizStaticData
import java.time.LocalDateTime

@Composable
fun KvizCard(
    kviz : Kviz,
    referentnoVrijeme : LocalDateTime,
    modifier : Modifier= Modifier
){
    val statusColor : Color
    val statusDescription : String
    val displayedDate : String

    when{
        kviz.datumRada != null ->{
            statusColor= Color.Blue
            statusDescription="Plava"
            displayedDate = kviz.datumRada.toLocalDate().toString()
        }
        kviz.datumPocetak.isAfter(KvizStaticData.getReferentDate())->{
            statusColor=Color.Yellow
            statusDescription="Žuta"
            displayedDate=kviz.datumPocetak.toLocalDate().toString()
        }
        kviz.datumPocetak.isBefore(KvizStaticData.getReferentDate())->{
            statusColor=Color.Red
            statusDescription="Crvena"
            displayedDate=kviz.datumKraj.toLocalDate().toString()
        }
        else ->{
            statusColor=Color.Green
            statusDescription="Zelena"
            displayedDate=kviz.datumKraj.toLocalDate().toString()
        }
    }

    Card(
        modifier = modifier//malim modifier jer mu dodjeljujemo onaj koje je proslijedjen kao parametar
            .padding(5.dp)
            .testTag("kviz_item_${kviz.naziv}"),//ovo je testTag za testiranje Card
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFB0C4C9)
        )
    ){
        Column(
            modifier=Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ){
            Box(
                modifier=Modifier.fillMaxWidth()
            ){
                Text(
                    text=kviz.nazivPredmeta,
                    textAlign= TextAlign.Center,
                    fontSize = 20.sp
                )
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(statusColor, CircleShape)
                        .align(Alignment.TopEnd)
                        .testTag("kviz_status_icon")
                        .semantics{
                            contentDescription=statusDescription
                        }
                )
            }
            //Ovaj dio iznad Column koji u sebi sadrzi Box koji sadrzi u sebi Text i jos jedan Box

            Spacer(modifier=Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE7ECEE)),
                shape=RoundedCornerShape(10.dp)
            ){
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text=kviz.naziv,
                        fontSize = 16.sp
                    )
                    Text(
                        text=displayedDate,
                        fontSize = 14.sp
                    )
                    Spacer(modifier=Modifier.height(6.dp))
                    //sad u ovom Column layout imat cemo na dnu RowLayout koji ce prikazivati min i bodove

                    Row(
                       modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            text=kviz.trajanje.toString() + "min",
                            textAlign=TextAlign.Start
                        )
                        Text(
                            text=kviz.osvojeniBodovi?.toString() ?: "",
                            textAlign=TextAlign.End
                        )
                    }

                }

            }

        }

    }

}