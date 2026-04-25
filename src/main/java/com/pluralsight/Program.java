package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Product> inventory = loadInventory();


        for(Product product : inventory) {
            System.out.printf("id: %d %s | Price: $%.2f%n", product.getId(), product.getName(), product.getPrice());
        }

    }
    public static ArrayList<Product> loadInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        System.out.print("What inventory would you like to see? ");
        String userChoice = input.nextLine();
        System.out.println("We carry the following inventory: ");


        try {
            FileReader fileReader = new FileReader(userChoice);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while(line != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);


                inventory.add(new Product(id, name, price));
                line = bufferedReader.readLine();


            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong... File could not be loaded.");
        }


        return inventory;
    }
}


