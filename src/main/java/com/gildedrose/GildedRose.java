package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateQuality();

        }

        for (Item item : items) {

            item.decreaseSellIn();

            if (item.sellIn < 0) {
                if (item.isAgedBrie()) {
                    if (item.quality < Item.DAY_50) {
                        item.quality = item.quality + 1;
                    }
                } else {
                    if (item.isBackstagePasses()) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            if (!item.isSulfuras()) {
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                }
            }
        }
    }

}
