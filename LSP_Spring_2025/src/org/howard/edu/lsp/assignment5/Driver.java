package org.howard.edu.lsp.assignment5;

/**
 * This class tests the IntegerSet implementation.
 */
public class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());
        System.out.println("Length of Set1 is: " + set1.length());

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("\nValue of Set2 is: " + set2.toString());
        System.out.println("Set1 equals Set2? " + set1.equals(set2));

        System.out.println("\nUnion of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2: " + set1.toString());

        System.out.println("\nIntersection of Set1 and Set2");
        IntegerSet set1CopyForIntersect = new IntegerSet(new java.util.ArrayList<>());
        set1CopyForIntersect.add(1);
        set1CopyForIntersect.add(2);
        set1CopyForIntersect.add(3);
        set1CopyForIntersect.intersect(set2);
        System.out.println("Result of intersection: " + set1CopyForIntersect.toString());

        System.out.println("\nDifference of Set1 and Set2");
        IntegerSet set1CopyForDiff = new IntegerSet(new java.util.ArrayList<>());
        set1CopyForDiff.add(1);
        set1CopyForDiff.add(2);
        set1CopyForDiff.add(3);
        set1CopyForDiff.diff(set2);
        System.out.println("Result of difference: " + set1CopyForDiff.toString());

        System.out.println("\nComplement of Set2 with respect to Set1");
        IntegerSet set2CopyForComplement = new IntegerSet(new java.util.ArrayList<>(set2.getSet()));
        set2CopyForComplement.complement(set1);
        System.out.println("Result of complement (Set2 - Set1): " + set2CopyForComplement.toString());

        System.out.println("\nChecking if Set1 contains 2: " + set1.contains(2));
        System.out.println("Checking if Set1 contains 5: " + set1.contains(5));

        System.out.println("\nRemoving 3 from Set2");
        set2.remove(3);
        System.out.println("Value of Set2 after removal: " + set2.toString());

        System.out.println("\nClearing Set1");
        set1.clear();
        System.out.println("Is Set1 empty? " + set1.isEmpty());
    }
}