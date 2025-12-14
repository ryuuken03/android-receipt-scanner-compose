package android.receipt.scanner

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                    composable(Screen.AddEdit.route) {
                        AddEditExpenseScreen(navController)
                    }
                }
            }
        }
    }
}