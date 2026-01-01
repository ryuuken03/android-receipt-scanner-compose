package android.receipt.scanner

import android.net.Uri
import android.os.Bundle
import android.receipt.scanner.ui.addedit.AddEditExpenseScreen
import android.receipt.scanner.ui.dashboard.DashboardScreen
import android.receipt.scanner.ui.navigation.Screen
import android.receipt.scanner.ui.scan.ScanReceiptScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Dashboard.route
                ) {
                    composable(Screen.Dashboard.route) {
                        DashboardScreen(navController)
                    }
                    composable(Screen.Scan.route) {
                        ScanReceiptScreen(navController)
                    }
                    composable(
                        route = Screen.AddEdit.route + "?imageUri={imageUri}",
                        arguments = listOf(
                            navArgument("imageUri") {
                                type = NavType.StringType
                                nullable = true
                            }
                        )
                    ) { backStackEntry ->

                        val imageUri = backStackEntry
                            .arguments
                            ?.getString("imageUri")
                            ?.let { Uri.parse(it) }

                        AddEditExpenseScreen(navController,imageUri = imageUri)
                    }
                }
            }
        }
    }
}