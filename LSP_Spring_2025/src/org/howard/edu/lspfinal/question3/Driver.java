package org.howard.edu.lspfinal.question3;

/**
 * Demonstrates generating different types of reports using the Template Method pattern.
 */
public class Driver {
    public static void main(String[] args) {
        Report salesReport = new SalesReport();
        salesReport.generateReport();

        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}
