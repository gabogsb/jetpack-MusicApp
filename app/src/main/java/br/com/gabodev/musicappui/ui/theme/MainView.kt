package br.com.gabodev.musicappui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.gabodev.musicappui.Screen
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

@Composable
fun DrawerItem(
  selected: Boolean = false,
  item:Screen.DrawerScreen,
  onDrawerItemClick: () -> Unit
) {

  val background = if (selected) Color.LightGray else Color.White

  Row(
    modifier = Modifier.fillMaxWidth()
      .padding(horizontal = 8.dp, vertical = 16.dp)
      .background(background)
      .clickable {
        onDrawerItemClick()
      }
  ) {
    Icon(
      painter = painterResource(id = item.icon),
      contentDescription = item.dTitle,
      modifier = Modifier.padding(end = 8.dp, top = 4.dp)
    )
    Text(
      text = item.dTitle,
      style = MaterialTheme.typography.h5
    )
  }

}