package br.com.gabodev.musicappui.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
  modifier: Modifier = Modifier
) {

  val scaffoldState: ScaffoldState = rememberScaffoldState()
  val scope: CoroutineScope = rememberCoroutineScope()

  Scaffold(
    topBar = {
      TopAppBar(title = { Text(text = "Home") },
        navigationIcon = {
          IconButton(onClick = {
            //TODO Open the drawer
            scope.launch {
              scaffoldState.drawerState.open()
            }
          }) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
          }
        }
      )
    }
  ) {
    Text(text = "Main View", modifier = modifier.padding(it))
  }

}

@Preview
@Composable
private fun PreviewMainView() {
  MainView()
}