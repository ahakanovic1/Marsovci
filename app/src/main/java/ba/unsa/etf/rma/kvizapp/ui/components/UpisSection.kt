package ba.unsa.etf.rma.kvizapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import ba.unsa.etf.rma.kvizapp.data.staticdata.GrupaStaticData
import ba.unsa.etf.rma.kvizapp.data.staticdata.PredmetStaticData
import ba.unsa.etf.rma.kvizapp.ui.theme.QuizColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpisSection() {

    val selectedYear = rememberSaveable {
        mutableStateOf<Int?>(null)
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

    val subjects =
        selectedYear.value?.let {
            PredmetStaticData.getNeupisaniByGodina(it)
        } ?: emptyList()

    val groups =
        if (selectedSubject.value != null) {
            GrupaStaticData.getGrupaFromPredmet(
                selectedSubject.value!!
            )
        } else emptyList()

    val sviPodaciUneseni =  selectedSubject.value != null &&
            selectedGroup.value != null && selectedYear.value != null//ako smo odabrali i predmet i grupu onda je dostupno dugne

    Column(
        modifier=Modifier
            .fillMaxWidth()
            .statusBarsPadding()//on automatski prilagodi display takoo da ne smeta status bar-u
            .padding(horizontal=16.dp,vertical=16.dp)
    ) {

        // GODINA
        ExposedDropdownMenuBox(
            expanded = expandedYear.value,
            onExpandedChange = {
                expandedYear.value = !expandedYear.value
            }
        ) {
            OutlinedTextField(
                value = selectedYear.value?.toString() ?: "Godina studija",//sadrzi onu vriejdnost koju sadrzi selectedYear
                onValueChange = {},//nije moguce dodirnuti i promijeniti taj TextField READONLY
                readOnly = true,
                shape= RoundedCornerShape(14.dp),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expandedYear.value
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = QuizColors.DropdownBorderFocused,
                    unfocusedBorderColor = Color.Transparent,
                    focusedTextColor = QuizColors.DropdownText,
                    unfocusedTextColor = QuizColors.DropdownText,
                    focusedContainerColor = QuizColors.DropdownBackground,
                    unfocusedContainerColor = QuizColors.DropdownBackground
                ),
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable)
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
            OutlinedTextField(
                value = selectedSubject.value ?: "Odaberi predmet",
                onValueChange = {},
                readOnly = true,
                shape= RoundedCornerShape(14.dp),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expandedSubject.value
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = QuizColors.DropdownBorderFocused,
                    unfocusedBorderColor = Color.Transparent,
                    focusedTextColor = QuizColors.DropdownText,
                    unfocusedTextColor = QuizColors.DropdownText,
                    focusedContainerColor = QuizColors.DropdownBackground,
                    unfocusedContainerColor = QuizColors.DropdownBackground
                ),
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable)
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
            OutlinedTextField(
                value = selectedGroup.value ?: "Odaberi grupu",
                onValueChange = {},
                readOnly = true,
                shape= RoundedCornerShape(14.dp),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expandedGroup.value
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = QuizColors.DropdownBorderFocused,
                    unfocusedBorderColor = Color.Transparent,
                    focusedTextColor = QuizColors.DropdownText,
                    unfocusedTextColor = QuizColors.DropdownText,
                    focusedContainerColor = QuizColors.DropdownBackground,
                    unfocusedContainerColor = QuizColors.DropdownBackground
                ),
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable)
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

                // reset samo predmet i grupa
                selectedSubject.value = null
                selectedGroup.value = null
            },//na klik se desava upis studenta u PredmetStaticData
            enabled = sviPodaciUneseni,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (sviPodaciUneseni)
                    QuizColors.ButtonEnabled
                else
                    QuizColors.ButtonDisabled,   // svijetla sivo-plava
                contentColor = QuizColors.ButtonEnabledTExt,
                disabledContainerColor = QuizColors.ButtonDisabled,
                disabledContentColor = QuizColors.ButtonDisabledTExt
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .testTag("dodajPredmetDugme")
        ) {
            Text("Upiši me")
        }
    }
}