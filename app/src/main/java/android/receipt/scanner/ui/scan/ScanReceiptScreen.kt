package android.receipt.scanner.ui.scan

import android.net.Uri
import android.receipt.scanner.ui.navigation.Screen
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.navigation.NavController
import java.io.File

@Composable
fun ScanReceiptScreen(navController: NavController) {

    val context = LocalContext.current

    val imageCapture = remember {
        ImageCapture.Builder()
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
            .build()
    }

    CameraPermission {
        Box(modifier = Modifier.fillMaxSize()) {

            CameraPreview(imageCapture)

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(24.dp),
                onClick = {
                    val photoFile = File(
                        context.cacheDir,
                        "receipt_${System.currentTimeMillis()}.jpg"
                    )

                    val outputOptions =
                        ImageCapture.OutputFileOptions.Builder(photoFile).build()

                    imageCapture.takePicture(
                        outputOptions,
                        ContextCompat.getMainExecutor(context),
                        object : ImageCapture.OnImageSavedCallback {
                            override fun onImageSaved(
                                outputFileResults: ImageCapture.OutputFileResults
                            ) {
                                val imageUri = outputFileResults.savedUri
                                    ?: photoFile.toUri()
                                navController.navigate(
                                    Screen.AddEdit.route + "?imageUri=${Uri.encode(imageUri.toString())}"
                                )
                            }

                            override fun onError(exception: ImageCaptureException) {
                                exception.printStackTrace()
                            }
                        }
                    )
                }
            ) {
                Text("CAPTURE")
            }
        }
    }
}

