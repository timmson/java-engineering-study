package com.gildedrose

class Item(private val name: String, var sellIn: Int, var quality: Int) {

    internal fun dayEnds() {
        when (name) {
            AGED_BRIE -> {
                increaseQuality()
                decreaseSellIn()
                if (sellIn < 0) increaseQuality()
            }

            BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT -> {
                increaseQuality()
                if (sellIn < 11) increaseQuality()
                if (sellIn < 6) increaseQuality()
                decreaseSellIn()
                if (sellIn < 0) quality = 0
            }

            SULFURAS_HAND_OF_RAGNAROS -> {
            }

            else -> {
                decreaseQuality()
                decreaseSellIn()
                if (sellIn < 0) decreaseQuality()
            }
        }

    }

    private fun decreaseSellIn() {
        sellIn--
    }

    private fun increaseQuality() {
        if (quality < 50) {
            quality++
        }
    }

    private fun decreaseQuality() {
        if (quality > 0) {
            quality--
        }
    }

    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    companion object {

        private const val AGED_BRIE = "Aged Brie"
        private const val SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros"
        private const val BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"
    }
}
