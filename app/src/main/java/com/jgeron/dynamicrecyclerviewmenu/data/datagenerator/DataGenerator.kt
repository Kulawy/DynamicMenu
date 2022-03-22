package com.jgeron.dynamicrecyclerviewmenu.data.datagenerator

import java.lang.IllegalArgumentException

interface DataGenerator<T> {

    @Throws(IllegalArgumentException::class)
    fun generateElements(count: Int): List<T>

}