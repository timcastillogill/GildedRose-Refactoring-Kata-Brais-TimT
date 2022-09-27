package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void increases_quality_aged_brie(){
        Item[] items = new Item[]{ new Item("Aged Brie", 2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].quality);
    }

    @Test
    void decreases_sellin_aged_brie(){
        Item[] items = new Item[]{ new Item("Aged Brie", 2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1,app.items[0].sellIn);
    }
    @Test
    void backstage_pass_increases_in_quality_and_decreases_in_sell_when_older_than_10_days(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 25, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(24,app.items[0].sellIn);
        assertEquals(2,app.items[0].quality);
    }

    @Test
    void sulfuras_quality_and_sellin_does_not_change(){
        Item[] items = new Item[]{ new Item("Sulfuras, Hand of Ragnaros", 25, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(25,app.items[0].sellIn);
        assertEquals(10,app.items[0].quality);
    }

    @Test
    void back_stage_pass_with_sellin_greater_than_10_increase_quality_by_1(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11,app.items[0].quality);
    }

}
