package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

    @Test
    @DisplayName("Test adding valid item")
    void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.50);
        assertEquals(1.50, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test adding item with 0 price (expect exception)")
    void testAddItemWithZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Banana", 0.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test adding item with negative price (expect exception)")
    void testAddItemWithNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Orange", -2.00);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test removing existing item")
    void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Milk", 3.00);
        boolean removed = cart.removeItem("Milk");
        assertTrue(removed);
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test removing non-existent item")
    void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Bread", 2.50);
        boolean removed = cart.removeItem("Eggs");  // Eggs not in cart
        assertFalse(removed);
        assertEquals(1, cart.getCartSize());
    }

    @Test
    @DisplayName("Test applying 'SAVE10'")
    void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying 'SAVE20'")
    void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying invalid code (expect exception)")
    void testApplyInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Milk", 3.00);
        cart.addItem("Bread", 2.50);
        assertEquals(5.50, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shirt", 50.00);
        cart.applyDiscountCode("SAVE20");
        assertEquals(40.00, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostWithEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test cart size updates correctly after adding and removing items")
    void testCartSizeUpdates() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 1.00);
        cart.addItem("Notebook", 5.00);
        assertEquals(2, cart.getCartSize());
        
        cart.removeItem("Pen");
        assertEquals(1, cart.getCartSize());
    }
}