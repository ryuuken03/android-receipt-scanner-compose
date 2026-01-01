package android.receipt.scanner.ui.addedit

import android.net.Uri
import android.receipt.scanner.data.ocr.OcrDataSource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditExpenseViewModel @Inject constructor(
    private val ocrDataSource: OcrDataSource
) : ViewModel() {

    private val _ocrResult = MutableStateFlow("")
    val ocrResult: StateFlow<String> = _ocrResult

    fun runOcr(imageUri: Uri) {
        viewModelScope.launch {
            try {
                _ocrResult.value = "Processing..."
                val text = ocrDataSource.extractText(imageUri)
                _ocrResult.value = text
            } catch (e: Exception) {
                _ocrResult.value = "OCR failed : "+e.message
            }
        }
    }
}
