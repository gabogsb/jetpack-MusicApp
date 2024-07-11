package br.com.gabodev.musicappui

import androidx.annotation.DrawableRes

sealed class Screen(
  val title: String,
  val route: String
) {

  sealed class DrawerScreen(
    val dTitle: String,
    val dRoute: String,
    @DrawableRes val icon: Int
  ) : Screen(dTitle, dRoute) {
    object Account : DrawerScreen(
      "Account",
      "account",
      R.drawable.baseline_account_box_24
    )

    object Subscription : DrawerScreen(
      "Subscription",
      "subscription",
      R.drawable.baseline_library_music_24
    )

    object AddAccount : DrawerScreen(
      "Add Account",
      "add_account",
      R.drawable.baseline_person_add_alt_1_24
    )
  }

}

val screensInDrawer = listOf(
  Screen.DrawerScreen.Account,
  Screen.DrawerScreen.Subscription,
  Screen.DrawerScreen.AddAccount
)