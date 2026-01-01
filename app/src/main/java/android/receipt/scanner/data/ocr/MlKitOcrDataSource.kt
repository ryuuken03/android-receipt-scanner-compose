package android.receipt.scanner.data.ocr

import android.content.Context
import android.net.Uri
import javax.inject.Inject
import kotlin.coroutines.resumeWithException
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine

class MlKitOcrDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) : OcrDataSource {

    override suspend fun extractText(imageUri: Uri): String =
        suspendCancellableCoroutine { continuation ->

            val image = InputImage.fromFilePath(context, imageUri)

            val recognizer = TextRecognition.getClient(
                TextRecognizerOptions.DEFAULT_OPTIONS
            )

            recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    continuation.resume(
                        visionText.text,
                        onCancellation = null
                    )
                }
                .addOnFailureListener { e ->
                    continuation.resumeWithException(e)
                }
        }
}
