package android.receipt.scanner.data.ocr

import android.net.Uri

interface OcrDataSource {
    suspend fun extractText(imagePath: Uri): String
}