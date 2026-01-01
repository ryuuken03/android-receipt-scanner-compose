package android.receipt.scanner.di

import android.content.Context
import android.receipt.scanner.data.ocr.MlKitOcrDataSource
import android.receipt.scanner.data.ocr.OcrDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OcrModule {

    @Provides
    fun provideOcrDataSource(
        @ApplicationContext context: Context
    ): OcrDataSource =
        MlKitOcrDataSource(context)
}
