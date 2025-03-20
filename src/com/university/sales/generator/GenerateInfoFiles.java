package com.university.sales.generator;

import java.io.*;
import java.util.Random;

public class GenerateInfoFiles {

    private static final String SALES_DIR = "sales/";
    private static final String PRODUCTS_FILE = "products.txt";
    private static final String[] FIRST_NAMES = {"Carlos", "Maria", "Luis", "Andrea", "Pedro"};
    private static final String[] LAST_NAMES = {"Gomez", "Rodriguez", "Lopez", "Fernandez", "Martinez"};
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try {
            createDirectory(SALES_DIR);
            createProductsFile(10);
            createSalesManInfoFile(5);

            System.out.println("Test files generated successfully.");
        } catch (IOException e) {
            System.err.println("Error generating test files: " + e.getMessage());
        }
    }

    private static void createDirectory(String dirPath) {
        File directory = new File(dirPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + dirPath);
            } else {
                System.err.println("Failed to create directory: " + dirPath);
            }
        }
    }


    public static void createProductsFile(int productsCount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {
            for (int i = 1; i <= productsCount; i++) {
                writer.write(i + ";Product" + i + ";" + (RANDOM.nextInt(50) + 1) * 100 + "\n");
            }
        }
    }
    
    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(VENDORS_FILE))) {
            for (int i = 0; i < salesmanCount; i++) {
                long id = 1000 + i;
                String name = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
                String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
                writer.write("CC;" + id + ";" + name + ";" + lastName + "\n");
            }
        }
    }
}
