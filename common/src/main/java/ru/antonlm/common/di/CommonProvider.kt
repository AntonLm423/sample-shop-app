package ru.antonlm.common.di

import android.content.Context
import androidx.compose.runtime.compositionLocalOf
import kotlinx.coroutines.CoroutineDispatcher
import ru.antonlm.common.di.CommonModule.IO
import javax.inject.Named

interface CommonProvider {

    val context: Context

    @get:Named(IO)
    val ioDispatcher: CoroutineDispatcher
}

val LocalCommonProvider = compositionLocalOf<CommonProvider> { error("No common provider found!") }
