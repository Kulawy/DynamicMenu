package com.jgeron.dynamicrecyclerviewmenu.common.utils

import kotlinx.coroutines.flow.MutableStateFlow

fun<T> MutableStateFlow<T>.updateValue(block: T.() -> T) {
    value = value.block()
}