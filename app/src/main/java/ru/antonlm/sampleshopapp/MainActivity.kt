package ru.antonlm.sampleshopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import ru.antonlm.common.di.LocalCommonProvider
import ru.antonlm.data.LocalDataProvider
import ru.antonlm.sampleshopapp.di.LocalAppProvider
import ru.antonlm.sampleshopapp.ui.Navigation
import ru.antonlm.sampleshopapp.ui.theme.SampleshopappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        setContent {
            SampleshopappTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CompositionLocalProvider(
                        LocalAppProvider provides application.appProvider,
                        LocalDataProvider provides application.appProvider,
                        LocalCommonProvider provides application.appProvider
                    ) {
                        Navigation()
                    }
                }
            }
        }
    }
}
