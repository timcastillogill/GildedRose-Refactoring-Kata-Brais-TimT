package com.gildedrose.refactor;

import com.gildedrose.Item;

public class GildedRoseRefactored {
    Item[] items;

    public GildedRoseRefactored(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                upgradeItem(item);
            } else if (isBackstageTicket(item)) {
                upgradeItem(item);
                handleBackstageTicket(item);
            } else {
                decreaseQuality(item);
            }
                decreaseSellin(item);

            if (item.sellIn < 0) {
                if (isAgedBrie(item)) {
                    upgradeItem(item);
                } else {
                    if (isBackstageTicket(item)) {
                        item.quality = 0;
                    } else {
                            decreaseQuality(item);
                    }
                }
            }
        }
    }

    private void handleBackstageTicket(Item item) {
        if (isBackstageTicket(item)) {
            if (item.sellIn < 11) {
                upgradeItem(item);
            }

            if (item.sellIn < 6) {
                upgradeItem(item);
            }
        }
    }

    private static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private static boolean isBackstageTicket(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void upgradeItem(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseSellin(Item item) {
        if(!isSulfuras(item)){
            item.sellIn -= 1;
        }
    }

    private void decreaseQuality(Item item) {
        if(item.quality > 0 && !isSulfuras(item)){
            item.quality -= 1;
        }
    }
}