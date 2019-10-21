package com.gildedrose

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions

import org.junit.jupiter.api.Assertions.assertEquals

class GlidedRoseShould {

    private var item: Item? = null
    private var gildedRose: GildedRose? = null

    @Given("Item {string} with SellIn {int} and Quality {int}")
    fun itemWithSellInAndQuality(name: String, sellIn: Int, quality: Int) {
        item = Item(name, sellIn, quality)
        gildedRose = GildedRose(arrayOf(item!!))
    }

    @When("End of day occurs")
    fun endOfDayOccurs() {
        gildedRose!!.updateQuality()
    }

    @Then("Item get SellIn {int} and Quality {int}")
    fun itemGetSellInAndQuality(sellIn: Int, quality: Int) {
        assertEquals(sellIn, gildedRose!!.items[0].sellIn)
        assertEquals(quality, gildedRose!!.items[0].quality)
    }
}
