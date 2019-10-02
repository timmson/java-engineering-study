package com.gildedrose;

public class Item {

    static final String AGED_BRIE = "Aged Brie";
    static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    boolean isSulfuras() {
        return name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    void updateQuality() {
        switch (name) {
            case AGED_BRIE:
                increaseQuality();

                sellIn--;

                if (sellIn < 0) {
                    increaseQuality();
                }

                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                increaseQuality();

                if (sellIn < 11) {
                    increaseQuality();
                }

                if (sellIn < 6) {
                    increaseQuality();
                }

                sellIn--;

                if (sellIn < 0) {
                    quality = 0;
                }

                break;
            case SULFURAS_HAND_OF_RAGNAROS:

                break;
            default:
                decreaseQuality();
                sellIn--;

                if (sellIn < 0) {
                    decreaseQuality();
                }

                break;
        }

    }

    private void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - (isSulfuras() ? 0 : 1);
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
