package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test // 1) le sellin baisse de 1
    public void testSellInMoinsUn() {
        Item[] items = { new Item("bouclier", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test // 2) la qualité baisse de 1
    public void testQualiteMoinsUn() {
        Item[] items = { new Item("bouclier", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test // 3) qualité toujours positive
    public void testQualitéPositif() {
        Item[] items = { new Item("bouclier", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test // 4) qualité maximum 50
    public void testQualitéMax() {
        Item[] items = { new Item("bouclier", 1, 55) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test // 5) Aged Brie qualité augmente
    public void testAgedBrieQualite() {
        Item[] items = { new Item("Aged Brie", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test // 6) Une fois que la date de péremption est passée, la qualité se dégrade deux
          // fois plus rapidement
    public void testQualiteMoinsDeux() {
        Item[] items = { new Item("bouclier", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test // 7) Sulfuras Quality
    public void testSulfurasQuality() {
        Item[] items = { new Item("Sulfuras", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test // 8) Sulfuras SellIn
    public void testSulfurasSellIn() {
        Item[] items = { new Item("Sulfuras", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }

    @Test // 9) Conjured Sell In Positif
    public void testConjuredSellInPositif() {
        Item[] items = { new Item("Conjured", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test // 10) Conjured Sell In Négatif
    public void testConjuredSellInNegatif() {
        Item[] items = { new Item("Conjured", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test // 11) Backstage Passes Qualité +2
    public void testBackstagePassesPlusDeux() {
        Item[] item = { new Item("Backstage Passes", 11, 40) };
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }

    @Test // 12) Backstage Passes Qualité +3
    public void testBackstagePassesPlusTrois() {
        Item[] item = { new Item("Backstage Passes", 5, 35) };
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(38, app.items[0].quality);
    }

    @Test // 13) Backstage Passes Qualité +1
    public void testBackstagePassesPlusUn() {
        Item[] item = { new Item("Backstage Passes", 12, 35) };
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(36, app.items[0].quality);
    }

    @Test // 14) Backstage Passes Qualité Zéro
    public void testBackstagePassesQualiteZero() {
        Item[] item = { new Item("Backstage Passes", 0, 35) };
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test // 15) 9) Brie qualité +2 si sellIn négatif (facultatif)
    public void testBrieQualitePlusDeux() {
        Item[] item = { new Item("Aged Brie", 0, 30) };
        GildedRose app = new GildedRose(item);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }
}
