package com.gildedrose

internal class GildedRose(var items: Array<Item>) {

    fun updateQuality() = this.items.forEach(Item::updateQuality)

}
