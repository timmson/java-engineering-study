package com.gildedrose;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlidedRoseShould {

    private Item item;
    private GildedRose gildedRose;

    @Given("Item {string} with SellIn {int} and Quality {int}")
    public void itemWithSellInAndQuality(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
        gildedRose = new GildedRose(new Item[]{item});
    }

    @When("End of day occurs")
    public void endOfDayOccurs() {
        gildedRose.updateQuality();
    }

    @Then("Item get SellIn {int} and Quality {int}")
    public void itemGetSellInAndQuality(int sellIn, int quality) {
        assertEquals(sellIn, gildedRose.items[0].sellIn);
        assertEquals(quality, gildedRose.items[0].quality);
    }
}
