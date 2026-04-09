package ba.unsa.etf.rma.rmaquizapp.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import ba.unsa.etf.rma.rmaquizapp.ui.components.FilterDropdown
import ba.unsa.etf.rma.rmaquizapp.ui.components.KvizList
import ba.unsa.etf.rma.rmaquizapp.ui.components.UpisSection

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun KvizMainScreen() {

    val odabraniFilter = rememberSaveable {
        mutableStateOf("Svi kvizovi")
    }

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