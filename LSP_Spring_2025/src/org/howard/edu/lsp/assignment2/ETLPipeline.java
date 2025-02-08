package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLPipeline {

	public static void main(String[] args) {
		String inputFile = "data/products.csv"; // Input file path
        String outputFile = "data/transformed_products.csv"; // Output file path
        
        // Step 1: Read data from the file
        List<String[]> products = readData(inputFile);

        if (products != null) {
            // Step 2: Modify the data
            List<String[]> transformedProducts = modifyData(products);
            
            // Step 3: Save the modified data to a new file
            saveData(outputFile, transformedProducts);
        }

	}
	
	// Reads data from the CSV file and stores it in a list
    public static List<String[]> readData(String filePath) {
        List<String[]> data = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            boolean firstLine = true; // Skip the header row
            
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                
                // Ignore empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                String[] values = line.split(",");
                
                // Ensure the row has exactly 4 columns before adding
                if (values.length == 4) {
                    data.add(values);
                } else {
                    System.out.println("Warning: Skipping invalid row -> " + line);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Oops! The file could not be read. Make sure it exists.");
            return null;
        }
        return data;
    }
    
 // Modifies the data (applies discounts, adjusts categories, etc.)
    public static List<String[]> modifyData(List<String[]> data) {
        List<String[]> modifiedData = new ArrayList<>();
        for (String[] product : data) {
            // Ensure the product has exactly 4 columns before processing
            if (product.length < 4) {
                System.out.println("Skipping invalid product data: " + Arrays.toString(product));
                continue;
            }

            String productId = product[0]; // ID
            String name = product[1].toUpperCase(); // Uppercase name
            double price;
            try {
                price = Double.parseDouble(product[2]); // Convert price to number
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid price value: " + product[2]);
                continue;
            }
            String category = product[3]; // Category

            // Apply 10% discount if it's in the Electronics category
            if (category.equalsIgnoreCase("Electronics")) {
                price *= 0.90;
            }
            
            // If the price is above 500, change category to "Premium Electronics"
            if (price > 500) {
                category = "Premium Electronics";
            }
            
            // Assign price range based on price value
            String priceRange;
            if (price <= 10) {
                priceRange = "Low";
            } else if (price <= 100) {
                priceRange = "Medium";
            } else if (price <= 500) {
                priceRange = "High";
            } else {
                priceRange = "Premium";
            }
            
            // Round the price to two decimal places
            price = Math.round(price * 100.0) / 100.0;
            
            modifiedData.add(new String[]{productId, name, String.format("%.2f", price), category, priceRange});
        }
        return modifiedData;
    }
    
 // Saves the modified data to a new CSV file
    public static void saveData(String filePath, List<String[]> data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("ProductID,Name,Price,Category,PriceRange"); // Write header
            writer.newLine();
            
            for (String[] product : data) {
                writer.write(String.join(",", product));
                writer.newLine();
            }
            writer.close();
            System.out.println("Success! The transformed data has been saved.");
        } catch (IOException e) {
            System.out.println("Error! Could not save the file. Please check your directory.");
        }
    }
}
