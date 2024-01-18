package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private List<Product> menu;
    private HashMap<String, Integer> inventory;

    public Inventory() {
        this.menu = new ArrayList<>();
        this.inventory = new HashMap<>();
    }

    public Integer getInventory(String sku) {
        return inventory.get(sku);
    }

    public void addToMenu(Product item, int stock){
        menu.add(item);
        inventory.put(item.getSku(), stock);
    }

    public boolean isInStock(String sku){
        return inventory.containsKey(sku) && inventory.get(sku) > 0;
    }
    /*
    public Product getProduct(String sku){
        for (Product item: menu){
            if (item.getSku().equals(sku)){
                return item;
            }
        }return null;
    }

     */

    public void decreaseStock(String sku){
        if (inventory.containsKey(sku)){
            int inStock = inventory.get(sku);
            if (inStock > 0){
                inventory.put(sku, inStock -1 );
            }
            else {
                System.out.println("Item out of stock");
            }

        }else {
            System.out.println("Item Not Found");
        }
    }
}
