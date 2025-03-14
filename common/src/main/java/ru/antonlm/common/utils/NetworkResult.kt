@file:Suppress("UNCHECKED_CAST")

package ru.antonlm.common.utils

sealed interface NetworkResult<T : Any> {

    /** Represents a network result that successfully received a response containing body data. */
    class Success<T : Any>(val data: T) : NetworkResult<T>

    /** Represents a network result that successfully received a response containing an error message. */
    class Error<T : Any>(val code: Int, val message: String?) : NetworkResult<T>

    /** Represents a network result that faced an unexpected exception before getting a response from the network
     * such as IOException and UnKnownHostException. */
    class Exception<T : Any>(val e: Throwable) : NetworkResult<T>
}

suspend fun <T : Any> NetworkResult<T>.onSuccess(
    executable: suspend (T) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> NetworkResult<T>.onError(
    executable: suspend (code: Int, message: String?) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Error<T>) {
        executable(code, message)
    }
}

suspend fun <T : Any> NetworkResult<T>.onException(
    executable: suspend (e: Throwable) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Exception<T>) {
        executable(e)
    }
}

suspend fun <T : Any> NetworkResult<T>.onFailure(
    executable: suspend (message: String?) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Error<T>) {
        executable(message)
    }

    if(this is NetworkResult.Exception<T>) {
        executable(e.message)
    }
}

fun <T : Any, R : Any> NetworkResult<T>.map(mapper: (T) -> R): NetworkResult<R> =
    when (this) {
        is NetworkResult.Success -> NetworkResult.Success(mapper(data))
        is NetworkResult.Error -> this as NetworkResult.Error<R>
        is NetworkResult.Exception -> this as NetworkResult.Exception<R>
    }
