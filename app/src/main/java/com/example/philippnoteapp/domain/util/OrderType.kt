package com.example.philippnoteapp.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
