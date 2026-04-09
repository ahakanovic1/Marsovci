package ba.unsa.etf.rma.rmaquizapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterDropdown(
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val opcije = listOf(
        "Svi moji kvizovi",
        "Svi kvizovi",
        "Urađeni kvizovi",
        "Budući kvizovi",
        "Prošli kvizovi (neurađeni)"
    )

    var daLiJeKliknut by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded = daLiJeKliknut,
        onExpandedChange = {
            daLiJeKliknut = !daLiJeKliknut
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .testTag("filterKvizova")
    ) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = { Text("Filter") },
            trailingIcon = {
                TrailingIcon(expanded = daLiJeKliknut)
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = daLiJeKliknut,
            onDismissRequest = {
                daLiJeKliknut = false
            }
        ) {
            opcije.forEach { opcija ->
                DropdownMenuItem(
                    text = { Text(opcija) },
                    onClick = {
                        onOptionSelected(opcija)
                        daLiJeKliknut = false
                    }
                )
            }
        }
    }
}