package ba.unsa.etf.rma.kvizapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import ba.unsa.etf.rma.kvizapp.ui.theme.QuizColors

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
            shape= RoundedCornerShape(14.dp),
            label = { Text(
                text = "Filter",
                color = Color.White
            )},
            trailingIcon = {
                TrailingIcon(expanded = daLiJeKliknut)
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = QuizColors.DropdownText,
                unfocusedTextColor = QuizColors.DropdownText,
                focusedContainerColor = QuizColors.DropdownBackground,
                unfocusedContainerColor = QuizColors.DropdownBackground
            ),
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryNotEditable)
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