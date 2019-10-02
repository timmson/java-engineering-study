package com.gildedrose;

class GildedRose {

    private static final int DAY_50 = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            final boolean isAgedBrie = item.isAgedBrie();
            final boolean isBackstagePasses = item.name.equals(Item.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
            final boolean isSulfuras = item.name.equals(Item.SULFURAS_HAND_OF_RAGNAROS);

            if (isAgedBrie || isBackstagePasses) {
                if (item.quality < DAY_50) {
                    item.quality = item.quality + 1;

                    if (isBackstagePasses) {
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
                    if (isSulfuras) {
                    } else {
                        item.quality = item.quality - 1;
                    }
                }
            }

            if (isSulfuras) {
            } else {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (isAgedBrie) {
                    if (item.quality < DAY_50) {
                        item.quality = item.quality + 1;
                    }
                } else {
                    if (isBackstagePasses) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            if (!isSulfuras) {
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                }
            }
        }
    }

}
