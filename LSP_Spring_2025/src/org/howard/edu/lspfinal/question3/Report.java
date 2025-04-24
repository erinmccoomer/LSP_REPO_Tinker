package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class representing a generic report.
 * Implements the Template Method design pattern.
 */
public abstract class Report {

    /**
     * Template method that defines the workflow of generating a report.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Step 1: Load the data (to be implemented by subclasses).
     */
    protected abstract void loadData();

    /**
     * Step 2: Format the data (to be implemented by subclasses).
     */
    protected abstract void formatData();

    /**
     * Step 3: Print the final report (to be implemented by subclasses).
     */
    protected abstract void printReport();
}
