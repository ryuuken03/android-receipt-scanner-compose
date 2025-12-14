package android.receipt.scanner.data.repository

import android.receipt.scanner.domain.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    fun getExpenses(): Flow<List<Expense>>
    suspend fun saveExpense(expense: Expense)
}