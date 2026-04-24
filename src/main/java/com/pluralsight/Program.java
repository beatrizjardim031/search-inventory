package com.pluralsight;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        System.out.println("We carry the following inventory: ");

        for(Product product : inventory) {
            System.out.printf("id: %d %s | Price: $%.2f%n", product.getId(), product.getName(), product.getPrice());
        }

    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        inventory.add(new Product(1,"Pencil", 1.99));
        inventory.add(new Product(2,"Eraser", 5.99));
        inventory.add(new Product(3,"Notebook", 8.99));
        inventory.add(new Product(4,"Pen", 2.99));
        inventory.add(new Product(5,"Glue", 6.99));


        return inventory;
    }
}
