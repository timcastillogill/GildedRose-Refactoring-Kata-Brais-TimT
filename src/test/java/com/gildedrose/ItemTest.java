package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    void sulfuras_to_string(){
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Assertions.assertEquals("Sulfuras, Hand of Ragnaros, -1, 80",item.toString());
    }
}
