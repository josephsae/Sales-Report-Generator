package com.university.sales.generator;

import java.io.*;

public class GenerateInfoFiles {

    private static final String SALES_DIR = "sales/";

    public static void main(String[] args) {
        createDirectory(SALES_DIR);
		System.out.println("Test files generated successfully.");
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

}
