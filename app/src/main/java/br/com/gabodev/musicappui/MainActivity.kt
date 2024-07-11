package br.com.gabodev.musicappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.gabodev.musicappui.ui.MainView
import br.com.gabodev.musicappui.ui.theme.MusicAppUITheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MusicAppUITheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          MainView(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}