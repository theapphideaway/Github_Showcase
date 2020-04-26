package com.ianschoenrock.networking.models

data class Repository(
    var incomplete_results: Boolean,
    var items: List<Item>,
    var total_count: Int
)