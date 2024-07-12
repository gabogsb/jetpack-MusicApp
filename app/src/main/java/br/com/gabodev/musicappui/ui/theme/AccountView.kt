package br.com.gabodev.musicappui.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.gabodev.musicappui.R

@Composable
fun AccountView(
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Row {
        Icon(
          imageVector = Icons.Default.AccountCircle,
          contentDescription = "Account",
          modifier = Modifier.padding(end = 8.dp)
        )
        Column {
          Text(text = "Gabo")
          Text(text = "@gabogsb")
        }
      }
      IconButton(onClick = {}) {
        Icon(
          imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
          contentDescription = null
        )
      }
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clickable {  },
    ) {
      Icon(
        painter = painterResource(id = R.drawable.baseline_music_note_24),
        contentDescription = "MyMusic",
        modifier = Modifier.padding(end = 8.dp)
      )
      Text(text = "MyMusic")
    }
    Divider()
  }
}