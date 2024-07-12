package br.com.gabodev.musicappui.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SubscribeView(
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .height(200.dp)
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "Manage Subscription")
    Card(
      modifier = Modifier
        .padding(8.dp),
      elevation = 4.dp
    ) {
      Column(
        modifier = Modifier
          .padding(8.dp),
      ) {
        Column {
          Text(text = "Musical")
          Row(
            modifier = Modifier
              .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
          ) {
            Text(
              text = "Free Tier",
              fontWeight = FontWeight.Bold
            )
            Row(
              verticalAlignment = Alignment.CenterVertically
            ) {
              TextButton(onClick = { /*TODO*/ }) {
                Text(text = "See All Plans")
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                  contentDescription = "See All Plans"
                )
              }
            }
          }
        }
        Divider(
          thickness = 1.dp,
          modifier = Modifier.padding(horizontal = 8.dp)
        )
        Row(
          modifier = Modifier.padding(vertical = 8.dp)
        ) {
          TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(1f),
            border = BorderStroke(1.dp, MaterialTheme.colors.secondary)
          ) {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Get a Plan")
            Text(text = "Get a plan")
          }
        }
      }
    }
  }
}

@Preview
@Composable
private fun SubscribeViewPreview() {
  SubscribeView()
}