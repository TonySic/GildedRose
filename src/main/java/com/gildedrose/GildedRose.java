package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) { // = syntaxe améliorée ci-dessous

            // test du Sulfuras

            if (items[i].name != "Sulfuras") {

                // baisse du sellIn

                items[i].sellIn--;

                // cas du brie

                if (items[i].name.equals("Aged Brie")) {
                    items[i].quality++;
                    if (items[i].sellIn < 0) {
                        items[i].quality++;
                    }
                }

                // cas des Conjured

                else if (items[i].name.equals("Conjured")) {
                    if (items[i].sellIn >= 0) {
                        items[i].quality -= 2;
                    } else {
                        items[i].quality -= 4;
                    }
                }

                // cas des places de concert

                else if (items[i].name.equals("Backstage Passes")) {
                    if (items[i].sellIn > 10) {
                        items[i].quality++;
                    } else if (items[i].sellIn > 5) {
                        items[i].quality += 2;
                    } else if (items[i].sellIn >= 0) {
                        items[i].quality += 3;
                    } else {
                        items[i].quality = 0;
                    }
                }

                // cas général

                else {
                    items[i].quality--;
                    if (items[i].sellIn < 0) {
                        items[i].quality--;
                    }
                }

                if (items[i].quality < 0) {
                    items[i].quality = 0;
                }

                if (items[i].quality > 50) {
                    items[i].quality = 50;
                }
            }
        }
    }
}