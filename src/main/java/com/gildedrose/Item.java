package com.gildedrose;

public class Item {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    private String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void updateQuality() {
        switch (name) {
            case AGED_BRIE:
                increaseQuality();
                decreaseSellIn();
                if (sellIn < 0) increaseQuality();
                break;

            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                increaseQuality();
                if (sellIn < 11) increaseQuality();
                if (sellIn < 6) increaseQuality();
                decreaseSellIn();
                if (sellIn < 0) quality = 0;
                break;

            case SULFURAS_HAND_OF_RAGNAROS:

                break;

            default:
                decreaseQuality();
                decreaseSellIn();
                if (sellIn < 0) decreaseQuality();
                break;
        }

    }

    private void decreaseSellIn() {
        sellIn--;
    }

    private void increaseQuality() {
        if (quality < 50) {
            quality++;
        }
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
