package com.gildedrose.refactor;

import com.gildedrose.Item;
import com.gildedrose.TextTestFixture;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenMasterTest {

	@Test
	public void compare_both_outputs() {
		ByteArrayOutputStream originalOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(originalOutputStream));
		TextTestFixture.main(new String[]{});

		ByteArrayOutputStream refactorOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(refactorOutputStream));
		mockMain(new String[]{"10"});

		assertEquals(originalOutputStream.toString(), refactorOutputStream().toString());
//		GildedRoseRefactoredTest.main(new String[]{}); // <-- Passing the method empty string // Checking for the stored output of both consoles Assertions.assertEquals(originalOutputStream.toString(), refactorOutputStream.toString()); }
	}

	void mockMain(String[] args) {
		System.out.println("OMGHAI!");

		Item[] items = new Item[]{
				new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6)};

		GildedRose app = new GildedRose(items);

		int days = 15;
		if (args.length > 0) {
			days = Integer.parseInt(String.valueOf(args[0])) + 1;
		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items) {
				System.out.println(item);
			}
			System.out.println();
			app.updateQuality();
		}
	}
}
