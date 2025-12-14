package android.receipt.scanner.data.local

import android.receipt.scanner.data.local.dao.ExpenseDao
import android.receipt.scanner.data.local.entity.ExpenseEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ExpenseEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}