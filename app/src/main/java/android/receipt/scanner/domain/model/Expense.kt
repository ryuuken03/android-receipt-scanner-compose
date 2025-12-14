package android.receipt.scanner.domain.model

data class Expense(
    val id: Long = 0,
    val merchant: String,
    val total: Double,
    val date: Long,
    val note: String? = null
)