package android.receipt.scanner.ui.navigation

sealed class Screen(val route: String) {
    data object Dashboard : Screen("dashboard")
    data object Scan : Screen("scan")
    data object AddEdit : Screen("add_edit")
}
