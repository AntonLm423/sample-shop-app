package ru.antonlm.common.domain

import java.util.UUID

data class Product(
    val category: String?,
    val description: String?,
    val id: Int,
    val image: String?,
    val price: Double?,
    val title: String?
) {

    companion object {

        fun createStub() = Product(
            category = "Electronics",
            description = "A high-quality smartphone with advanced features.",
            id = 777,
            image = "https://example.com/image.jpg",
            price = 999.99,
            title = "SuperPhone X"
        )
    }
}
