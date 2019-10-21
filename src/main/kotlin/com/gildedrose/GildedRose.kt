package com.gildedrose

internal class GildedRose(var items: Array<Item>) {

    fun dayEnds() = this.items.forEach(Item::dayEnds)

}
