package ba.unsa.etf.rma.kvizapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ba.unsa.etf.rma.kvizapp.ui.components.SetStatusBarColor
import ba.unsa.etf.rma.kvizapp.ui.components.FilterDropdown
import ba.unsa.etf.rma.kvizapp.ui.components.KvizList
import ba.unsa.etf.rma.kvizapp.ui.components.UpisSection

@Composable
fun KvizMainScreen() {

    val odabraniFilter = rememberSaveable {
        mutableStateOf("Svi kvizovi")
    }

    SetStatusBarColor()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // 1. UPIS STUDENTA
        UpisSection()

        Spacer(modifier = Modifier.height(16.dp))

        // 2. FILTER KVIZOVA
        FilterDropdown(
            selectedOption = odabraniFilter.value,
            onOptionSelected = { noviFilter ->
                odabraniFilter.value = noviFilter
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 3. LISTA KVIZOVA
        KvizList(
            filter = odabraniFilter.value
        )
    }
}