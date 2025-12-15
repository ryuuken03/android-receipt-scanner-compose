package android.receipt.scanner.ui.addedit

import android.receipt.scanner.ui.navigation.Screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddEditExpenseScreen(
    navController: NavController,
    imagePath: String?
) {
    var merchant by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }

    Text("Image path: $imagePath")
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Tambah Pengeluaran",
//            style = MaterialTheme.typography.headlineMedium
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = merchant,
//            onValueChange = { merchant = it },
//            label = { Text("Nama Toko") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = total,
//            onValueChange = { total = it },
//            label = { Text("Total") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = { navController.popBackStack(Screen.Dashboard.route, false) },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Simpan")
//        }
//    }
}
