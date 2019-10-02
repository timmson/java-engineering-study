# language: en
Feature:  Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
  prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
  Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
  have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
  Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
  we can begin selling a new category of items. First an introduction to our system:

  - All items have a SellIn value which denotes the number of days we have to sell the item
  - All items have a Quality value which denotes how valuable the item is
  - At the end of each day our system lowers both values for every item

  Scenario: Item goes from SellIn 1 and Quality 1 to 0 and 0 in the end of the day
    Given Item "Item" with SellIn 1 and Quality 1
    When End of day occurs
    Then Item get SellIn 0 and Quality 0

  Scenario: Once the sell by date has passed, Quality degrades twice as fast
    Given Item "Item" with SellIn 0 and Quality 2
    When End of day occurs
    Then Item get SellIn -1 and Quality 0

  Scenario: The Quality of an item is never negative
    Given Item "Item" with SellIn 0 and Quality 0
    When End of day occurs
    Then Item get SellIn -1 and Quality 0

  Scenario: "Aged Brie" actually increases in Quality the older it gets
    Given Item "Aged Brie" with SellIn 1 and Quality 1
    When End of day occurs
    Then Item get SellIn 0 and Quality 2

  Scenario: The Quality of an item is never more than 50
    Given Item "Aged Brie" with SellIn 1 and Quality 50
    When End of day occurs
    Then Item get SellIn 0 and Quality 50

  Scenario: "Sulfuras, Hand of Ragnaros", being a legendary item, never has to be sold or decreases in Quality
    Given Item "Sulfuras, Hand of Ragnaros" with SellIn 1 and Quality 80
    When End of day occurs
    Then Item get SellIn 1 and Quality 80

  Scenario: "Backstage passes to a TAFKAL80ETC concert", actually increases in Quality by 1 the older it gets when SellIn more then 10 days
    Given Item "Backstage passes to a TAFKAL80ETC concert" with SellIn 11 and Quality 1
    When End of day occurs
    Then Item get SellIn 10 and Quality 2

  Scenario: "Backstage passes to a TAFKAL80ETC concert", actually increases in Quality by 1 the older it gets when SellIn more then 10 days
    Given Item "Backstage passes to a TAFKAL80ETC concert" with SellIn 10 and Quality 1
    When End of day occurs
    Then Item get SellIn 9 and Quality 3

  Scenario: "Backstage passes", actually increases in Quality by 1 the older it gets when SellIn more then 10 days
    Given Item "Backstage passes to a TAFKAL80ETC concert" with SellIn 3 and Quality 1
    When End of day occurs
    Then Item get SellIn 2 and Quality 4




