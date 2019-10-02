package com.gildedrose;

class GildedRose {

    private static final int DAY_50 = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.isAgedBrie() || item.isBackstagePasses()) {
                if (item.quality < DAY_50) {
                    item.quality = item.quality + 1;

                    if (item.isBackstagePasses()) {
                        if (item.sellIn < 11) {
                            if (item.quality < DAY_50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < DAY_50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            } else {
                if (item.quality > 0) {
                    if (item.isSulfuras()) {
                    } else {
                        item.quality = item.quality - 1;
                    }
                }
            }

        }

        for (Item item : items) {

            if (item.isSulfuras()) {
            } else {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (item.isAgedBrie()) {
                    if (item.quality < DAY_50) {
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
