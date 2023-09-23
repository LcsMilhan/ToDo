package com.lcsmilhan.todo.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
