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

    boolean isSulfuras() {
        return name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    void updateQuality() {
        preUpdateQuality();

        decreaseSellIn();

        postUpdateQuality();
    }

    void decreaseSellIn() {
        sellIn = sellIn - (isSulfuras() ? 0 : 1);
    }

    void preUpdateQuality() {
        switch (name) {
            case AGED_BRIE:
                if (quality < DAY_50) {
                    quality = quality + 1;
                }
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                if (quality < DAY_50) {
                    quality = quality + 1;

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
                break;
            default:
                if (quality > 0) {
                    quality = quality - (isSulfuras() ? 0 : 1);
                }
                break;
        }
    }

    void postUpdateQuality() {
        if (sellIn < 0) {
            switch (name) {
                case AGED_BRIE:
                    if (quality < DAY_50) {
                        quality = quality + 1;
                    }
                    break;
                case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                    quality = 0;
                    break;
                default:
                    if (quality > 0) {
                        if (!isSulfuras()) {
                            quality = quality - 1;
                        }
                    }
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
