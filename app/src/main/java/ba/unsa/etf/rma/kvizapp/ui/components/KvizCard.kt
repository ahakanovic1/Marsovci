package ba.unsa.etf.rma.kvizapp.ui.components

import ba.unsa.etf.rma.kvizapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ba.unsa.etf.rma.kvizapp.data.model.Kviz
import ba.unsa.etf.rma.kvizapp.ui.theme.QuizColors
import java.time.LocalDateTime

@Composable
fun KvizCard(
    kviz : Kviz,
    referentnoVrijeme : LocalDateTime,
    modifier : Modifier= Modifier
){
    val statusIcon : Int
    val statusDescription : String
    val displayedDate : String


    when {
        kviz.datumRada != null -> {
            statusIcon = R.drawable.plava
            statusDescription = "Plava"
            displayedDate = kviz.datumRada.toLocalDate().toString()
        }

        referentnoVrijeme.isBefore(kviz.datumPocetak) -> {
            statusIcon = R.drawable.zuta
            statusDescription = "Žuta"
            displayedDate = kviz.datumPocetak.toLocalDate().toString()
        }

        referentnoVrijeme.isAfter(kviz.datumKraj) -> {
            statusIcon = R.drawable.crvena
            statusDescription = "Crvena"
            displayedDate = kviz.datumKraj.toLocalDate().toString()
        }

        else -> {
            statusIcon = R.drawable.zelena
            statusDescription = "Zelena"
            displayedDate = kviz.datumKraj.toLocalDate().toString()
        }
    }

    Card(
        modifier = modifier//malim modifier jer mu dodjeljujemo onaj koje je proslijedjen kao parametar
            .padding(5.dp)
            .testTag("kviz_item_${kviz.naziv}"),//ovo je testTag za testiranje Card
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = QuizColors.QuizCardOuter
        )
    ){
        Column(
            modifier=Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            ){
            Box(
                modifier=Modifier.fillMaxWidth(),
            ){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text=kviz.nazivPredmeta,
                    textAlign= TextAlign.Center,
                    fontSize = 20.sp
                )
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .testTag("kviz_status_icon"),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Image(
                        painter = painterResource(id = statusIcon),
                        contentDescription = statusDescription,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            //Ovaj dio iznad Column koji u sebi sadrzi Box koji sadrzi u sebi Text i jos jedan Box

            Spacer(modifier=Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = QuizColors.QuizCardInner),
                shape=RoundedCornerShape(10.dp)
            ){
                Column(
                    modifier = Modifier.padding(10.dp),
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),//sada zauzmi citavu sirinu i na toj sirini se centriraj
                        text=kviz.naziv,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),//sada zauzmi citavu sirinu i na toj sirini se centriraj
                        text=displayedDate,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )

                    Spacer(modifier=Modifier.height(6.dp))
                    //sad u ovom Column layout imat cemo na dnu RowLayout koji ce prikazivati min i bodove

                    Row(
                       modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text=kviz.trajanje.toString() + "min",
                        )

                        Text(
                            text=kviz.osvojeniBodovi?.toString() ?: "",
                        )
                    }

                }

            }

        }

    }

}