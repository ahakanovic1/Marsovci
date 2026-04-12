package ba.unsa.etf.rma.kvizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ba.unsa.etf.rma.kvizapp.ui.theme.KVIZAppTheme
import ba.unsa.etf.rma.kvizapp.ui.screens.KvizMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            KVIZAppTheme {
                KvizMainScreen()
            }
        }
    }
}