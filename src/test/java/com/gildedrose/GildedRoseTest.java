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

    @Test
    void back_stage_pass_with_sellin_value_10_or_less_increases_quality_by_2(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12,app.items[0].quality);
    }

    @Test
    void backstage_passes_quality_drop_to_0_when_sellin_less_than_0(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void item_is_an_apple_quality_decreases_by_one(){
        Item[] items = new Item[]{ new Item("apple", 15, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9,app.items[0].quality);
    }

    @Test
    void backstage_passes_5_days_or_less_to_concert_increases_by_3(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5,app.items[0].quality);
    }

    @Test
    void apple_quality_decrements_by_2_when_sellin_less_than_0(){
        Item[] items = new Item[]{ new Item("apple", -1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void aged_brie_increases_quality_when_sellin_less_than_0(){
        Item[] items = new Item[]{ new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3,app.items[0].quality);
    }

    @Test
    void decreases_sellin_aged_(){
        Item[] items = new Item[]{ new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3,app.items[0].quality);
    }


}
