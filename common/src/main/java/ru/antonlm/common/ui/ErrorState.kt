package ru.antonlm.common.ui

import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import ru.antonlm.common.R

@Composable
fun ErrorState(
    modifier: Modifier = Modifier,
    @StringRes titleResId: Int? = R.string.error_default_title,
    titleString: String? = null,
    @StringRes messageResId: Int? = R.string.error_default_title,
    messageString: String? = null,
    @StringRes buttonTextResId: Int? = null,
    onButtonClick: (() -> Unit)? = null,
    @RawRes animationResId: Int? = null
) {
    val title = if (titleResId != null) stringResource(titleResId) else titleString
    val message = if (messageResId != null) stringResource(messageResId) else messageString

    Box(contentAlignment = Alignment.Center, modifier = modifier.padding(horizontal = 32.dp)) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            if (animationResId != null) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationResId))
                val progress by animateLottieCompositionAsState(composition)

                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                    modifier = Modifier.size(128.dp)
                )
            }

            val topPaddingForTitle = if (animationResId == null) 0.dp else 16.dp
            val topPaddingForMessage = when {
                title.isNullOrBlank() && animationResId == null -> 0.dp
                title.isNullOrBlank() && animationResId != null -> 16.dp
                else -> 8.dp
            }

            if (!title.isNullOrBlank()) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = topPaddingForTitle)
                )
            }

            if (!message.isNullOrBlank()) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = topPaddingForMessage)
                )
            }

            if (buttonTextResId != null && onButtonClick != null) {
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier.padding(top = min(topPaddingForTitle, topPaddingForMessage))
                ) {
                    Text(
                        text = stringResource(buttonTextResId),
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}

@Composable
fun ErrorStateNoInternet(onButtonClick: (() -> Unit), modifier: Modifier = Modifier) =
    ErrorState(
        modifier = modifier,
        titleResId = R.string.error_no_internet_title,
        messageResId = R.string.error_no_internet_message,
        buttonTextResId = R.string.common_retry,
        animationResId = R.raw.error_no_internet,
        onButtonClick = onButtonClick,
    )