package android.receipt.scanner.ui.navigation

sealed class Screen(val route: String) {
    data object Dashboard : Screen("dashboard")
    data object Scan : Screen("scan")
    data object AddEdit : Screen("add_edit?imageUri={imageUri}") {
        fun createRoute(uri: String) =
            "add_edit?imageUri=$uri"
    }
}
