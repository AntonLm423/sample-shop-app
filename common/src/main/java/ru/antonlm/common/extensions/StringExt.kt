package ru.antonlm.common.extensions

fun String.ifNotEmpty( block: () -> Unit) {
    if (this.isNotEmpty()) {
        block.invoke()
    }
}
