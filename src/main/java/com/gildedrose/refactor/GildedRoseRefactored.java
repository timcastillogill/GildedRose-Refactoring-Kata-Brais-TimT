package com.gildedrose.refactor;

import com.gildedrose.Item;

public class GildedRoseRefactored{
    Item[] items;

    public GildedRoseRefactored(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    decreaseQuality(item);
                }
            } else {
                    upgradeItem(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            upgradeItem(item);
                        }

                        if (item.sellIn < 6) {
                            upgradeItem(item);
                        }
                    }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseSellin(item);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            decreaseQuality(item);
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    upgradeItem(item);
                }
            }
        }
    }

    private void upgradeItem(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseSellin(Item item) {
        item.sellIn -= 1;
    }

    private void decreaseQuality(Item item) {
        item.quality -= 1;
    }
}