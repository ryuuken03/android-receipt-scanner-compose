package android.receipt.scanner.ui.dashboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    // nanti ExpenseRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow("Belum ada data")
    val uiState: StateFlow<String> = _uiState
}
