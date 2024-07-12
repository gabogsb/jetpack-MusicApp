package br.com.gabodev.musicappui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun AccountDialog(
  modifier: Modifier = Modifier,
  dialogOpen: MutableState<Boolean>
) {


  if (dialogOpen.value) {
    AlertDialog(
      onDismissRequest = {
        dialogOpen.value = false
      },
      confirmButton = {
        TextButton(onClick = {
          dialogOpen.value = false
        }) {
          Text(text = "Confirm")
        }
      },
      dismissButton = {
        TextButton(onClick = {
          dialogOpen.value = false
        }) {
          Text(text = "Dismiss")
        }
      },
      title = {
        Text(text = "Add Account")
      },
      text = {
        Column(
          modifier = modifier
            .wrapContentHeight()
            .padding(top = 24.dp, bottom = 24.dp),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(text = "Add Account:")
          TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Email") }
          )
          TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Password") }
          )
        }
      },
      shape = RoundedCornerShape(10.dp),
      backgroundColor = Color.White,
      properties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true
      )
    )
  }
}