package com.gildedrose;

public class Item {

    static final String AGED_BRIE = "Aged Brie";
    static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    static final int DAY_50 = 50;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    boolean isAgedBrie() {
        return name.equals(AGED_BRIE);
    }

    boolean isBackstagePasses() {
        return name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
    }

    boolean isSulfuras() {
        return name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    void decreaseSellIn() {
        if (isSulfuras()) {
        } else {
            sellIn = sellIn - 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void updateQuality() {
        if (isAgedBrie() || isBackstagePasses()) {
            if (quality < DAY_50) {
                quality = quality + 1;

                if (isBackstagePasses()) {
                    if (sellIn < 11) {
                        if (quality < DAY_50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < DAY_50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        } else {
            if (quality > 0) {
                if (isSulfuras()) {
                } else {
                    quality = quality - 1;
                }
            }
        }
    }
}
