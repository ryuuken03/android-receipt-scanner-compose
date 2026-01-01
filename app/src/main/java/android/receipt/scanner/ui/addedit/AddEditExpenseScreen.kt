package android.receipt.scanner.ui.addedit

import android.net.Uri
import android.receipt.scanner.ui.navigation.Screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AddEditExpenseScreen(
    navController: NavController,
    imageUri: Uri?,
    viewModel: AddEditExpenseViewModel = hiltViewModel()
) {
    val ocrText by viewModel.ocrResult.collectAsState()

    if (imageUri == null) {
        Text("No image selected")
        return
    }else{
        LaunchedEffect(imageUri) {
            viewModel.runOcr(imageUri)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Hasil OCR",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (ocrText.isBlank()) {
            CircularProgressIndicator()
        } else {
            Text(
                text = ocrText,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Kembali")
        }
    }
}

