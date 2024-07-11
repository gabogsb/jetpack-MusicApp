package br.com.gabodev.musicappui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.gabodev.musicappui.Screen
import br.com.gabodev.musicappui.screensInDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
  modifier: Modifier = Modifier
) {

  val scaffoldState: ScaffoldState = rememberScaffoldState()
  val scope: CoroutineScope = rememberCoroutineScope()

  //find to veiew
  val controller: NavController = rememberNavController()
  val navBackStackEntry by controller.currentBackStackEntryAsState()
  val currentRoute = navBackStackEntry?.destination?.route

  val title = remember {
    mutableStateOf("")
  }


  Scaffold(
    topBar = {
      TopAppBar(title = { Text(text = title.value) },
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
    },
    scaffoldState = scaffoldState,
    drawerContent = {
      LazyColumn(
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
      ) {
        items(screensInDrawer){ item ->
          DrawerItem(item = item, selected = currentRoute == item.route) {
            scope.launch {
              scaffoldState.drawerState.close()
            }
            if (item.dRoute == "add_account"){
              //TODO Add Account open dialog
            } else {
              controller.navigate(item.route)
              title.value = item.dTitle
            }
          }

        }
      }
    }
  ) {
    Text(text = "Main View", modifier = modifier.padding(it))
  }

}

@Composable
fun DrawerItem(
  selected: Boolean,
  item:Screen.DrawerScreen,
  onDrawerItemClick: () -> Unit
) {

  val background = if (selected) Color.LightGray else Color.White

  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp)
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