package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class implements a set of integers using an ArrayList.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor initializes an empty set.
     */
    public IntegerSet() {
    }

    /**
     * Constructor initializes the set with a given list of integers.
     * @param set The list of integers to initialize the set with.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set);
    }

    /**
     * Returns a copy of the set.
     * @return A new list containing the elements of the set.
     */
    public List<Integer> getSet() {
        return new ArrayList<>(set);
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     * @return The number of elements in the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal.
     * @param o The object to compare with.
     * @return True if both sets contain the same elements, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntegerSet)) {
            return false;
        }
        IntegerSet otherSet = (IntegerSet) o;
        return set.containsAll(otherSet.set) && otherSet.set.containsAll(set);
    }

    /**
     * Checks if the set contains a specific value.
     * @param value The value to check.
     * @return True if the set contains the value, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * @return The largest integer in the set.
     */
    public int largest() {
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     * @return The smallest integer in the set.
     */
    public int smallest() {
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if not already present.
     * @param item The item to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if present.
     * @param item The item to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Computes the union of this set with another set.
     * @param intSetb The other set.
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            if (!set.contains(item)) {
                set.add(item);
            }
        }
    }

    /**
     * Computes the intersection of this set with another set.
     * @param intSetb The other set.
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Computes the difference between this set and another set.
     * @param intSetb The other set.
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Computes the complement of this set.
     * @param intSetb The universal set.
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>(intSetb.set);
        complementSet.removeAll(set);
        set = complementSet;
    }

    /**
     * Checks if the set is empty.
     * @return True if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * @return The string representation of the set.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}