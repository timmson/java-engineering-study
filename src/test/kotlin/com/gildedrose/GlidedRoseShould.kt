package com.gildedrose

import io.cucumber.java8.En
import kotlin.test.assertEquals

class GlidedRoseShould : En {

    private var gildedRose: GildedRose? = null

    init {
        Given("Item {string} with SellIn {int} and Quality {int}") { name: String, sellIn: Int, quality: Int ->
            gildedRose = GildedRose(arrayOf(Item(name, sellIn, quality)))
        }

        When("End of day occurs") { gildedRose!!.dayEnds() }

        Then("Item get SellIn {int} and Quality {int}") { sellIn: Int, quality: Int ->
            assertEquals(sellIn, gildedRose!!.items[0].sellIn)
            assertEquals(quality, gildedRose!!.items[0].quality)
        }
    }
}
