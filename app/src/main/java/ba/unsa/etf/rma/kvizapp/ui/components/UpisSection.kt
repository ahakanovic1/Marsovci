package ba.unsa.etf.rma.rmaquizapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import ba.unsa.etf.rma.kvizapp.data.staticdata.GrupaStaticData
import ba.unsa.etf.rma.kvizapp.data.staticdata.PredmetStaticData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpisSection() {

    val selectedYear = rememberSaveable {
        mutableStateOf(5)
    }

    val selectedSubject = rememberSaveable {
        mutableStateOf<String?>(null)
    }

    val selectedGroup = rememberSaveable {
        mutableStateOf<String?>(null)
    }

    val expandedYear = remember { mutableStateOf(false) }
    val expandedSubject = remember { mutableStateOf(false) }
    val expandedGroup = remember { mutableStateOf(false) }

    val years = listOf(1, 2, 3, 4, 5)

    val subjects = PredmetStaticData
        .getNeupisaniByGodina(selectedYear.value)

    val groups =
        if (selectedSubject.value != null) {
            GrupaStaticData.getGrupaFromPredmet(
                selectedSubject.value!!
            )
        } else emptyList()

    Column {

        // GODINA
        ExposedDropdownMenuBox(
            expanded = expandedYear.value,
            onExpandedChange = {
                expandedYear.value = !expandedYear.value
            }
        ) {
            TextField(
                value = selectedYear.value.toString(),//sadrzi onu vriejdnost koju sadrzi selectedYear
                onValueChange = {},//nije moguce dodirnuti i promijeniti taj TextField READONLY
                readOnly = true,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .testTag("odabirGodina")
            )

            ExposedDropdownMenu(
                expanded = expandedYear.value,
                onDismissRequest = {//u slucaju da ga ne dodirnmeo ostaje false stanje za expanded
                    expandedYear.value = false
                }
            ) {
                //slicno kao LazyColum prolazimo kroz sve godine liste i pravimo DropdownMenuItem sa textom
                // i sta se desava onClick{} lmbda funkcijom
                years.forEach { year ->
                    DropdownMenuItem(
                        text = { Text(year.toString()) },
                        onClick = {
                            selectedYear.value = year
                            selectedSubject.value = null
                            selectedGroup.value = null
                            expandedYear.value = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // PREDMET
        ExposedDropdownMenuBox(
            expanded = expandedSubject.value,
            onExpandedChange = {
                expandedSubject.value = !expandedSubject.value
            }
        ) {
            TextField(
                value = selectedSubject.value ?: "Odaberi predmet",
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .testTag("odabirPredmet")
            )

            ExposedDropdownMenu(
                expanded = expandedSubject.value,
                onDismissRequest = {
                    expandedSubject.value = false
                }
            ) {
                subjects.forEach { predmet ->
                    DropdownMenuItem(
                        text = { Text(predmet.naziv) },//on napise sve predmete koji su se nalazili u listi a mi klikom mijenjamo koji ce biti prikazan
                        onClick = {
                            selectedSubject.value = predmet.naziv
                            selectedGroup.value = null
                            expandedSubject.value = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // GRUPA
        ExposedDropdownMenuBox(
            expanded = expandedGroup.value,
            onExpandedChange = {
                expandedGroup.value = !expandedGroup.value
            }
        ) {
            TextField(
                value = selectedGroup.value ?: "Odaberi grupu",
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .testTag("odabirGrupa")
            )

            ExposedDropdownMenu(
                expanded = expandedGroup.value,
                onDismissRequest = {
                    expandedGroup.value = false
                }
            ) {
                groups.forEach { grupa ->
                    DropdownMenuItem(
                        text = { Text(grupa.naziv) },
                        onClick = {
                            selectedGroup.value = grupa.naziv
                            expandedGroup.value = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                val predmet = PredmetStaticData.getAll()
                    .first { it.naziv == selectedSubject.value }

                PredmetStaticData.upisiPredmet(predmet)
            },//na klik se desava upis studenta u PredmetStaticData
            enabled = selectedSubject.value != null &&
                    selectedGroup.value != null,//ako smo odabrali i predmet i grupu onda je dostupno dugne
            modifier = Modifier
                .fillMaxWidth()
                .testTag("dodajPredmetDugme")
        ) {
            Text("Upiši me")
        }
    }
}