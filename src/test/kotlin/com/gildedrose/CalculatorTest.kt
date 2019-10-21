package com.gildedrose

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class CalculatorTest() {

    @Test
    @DisplayName("return multiplication when 2 numbers given")
    fun returnMultiplication_whenTwoNumbersGiven() {
        val a = 2
        val b = 2

        val result = Calculator.multiply(a, b)

        assertEquals(4, result)
    }
}