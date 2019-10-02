package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    private static final  int DAY_50 = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            final boolean isAgedBrie = items[i].name.equals(AGED_BRIE);
            final boolean isBackstagePasses = items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);

            if (isAgedBrie || isBackstagePasses) {
                if (items[i].quality < DAY_50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < DAY_50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < DAY_50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            } else {
                if (items[i].quality > 0) {
                    if (items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    } else {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }

            if (items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            } else {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (isAgedBrie) {
                    if (items[i].quality < DAY_50) {
                        items[i].quality = items[i].quality + 1;
                    }
                } else {
                    if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        items[i].quality = items[i].quality - items[i].quality;
                    } else {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
