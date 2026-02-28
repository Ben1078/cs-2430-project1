/*
 * Team Name - Team Awesome Sauce
 * Team Members - Noah Kolling, Nelson Long, & Ben Paul
 * CS-2430-502-Spring 2026
 * Programming Project 1 - Set Operations
 * @author Noah Kolling (Primary Author)
 * @author Nelson Long (Secondary Author)
 * @author Ben Paul (Secondary Author)
 */

/**
 * This is a class that will allow us to demonstrate proficiency manipulating different kinds of sets
 */
public class SetOperations {

    //Create our universal set
    static String[] universalSet = {"a","b","c","d","e","f","g","h","i","j"}; //keeping it simple using letters

    //Create our sets for part 1
    //set A = {a, c, e, g, i}
    static boolean[] setA = {true,false,true,false,true,false,true,false,true,false};
    //set B = {b, c, f, g, j}
    static boolean[] setB = {false,true,true,false,false,true,true,false,false,true};
    //set C = {a, d, e, h, i}
    static boolean[] setC = {true,false,false,true,true,false,false,true,true,false};

    //Create our bags for part 2
    //Each Bag has multiple values with count > 1
    //Bag A = {a×2, c×3, e, g×2}
    static int[] bagA = {2,0,3,0,1,0,2,0,0,0};
    //Bag B = {a, c×4, d×2, j×3}
    static int[] bagB = {1,0,4,2,0,0,0,0,0,3};
    //Bag C = {b×3, e×2, g, i×4}
    static int[] bagC = {0,3,0,0,2,0,1,0,4,0};

    //-----------------------Main Method-----------------------
    static void main() {

        // Print the universal set once at the top
        System.out.println("==================================================");
        System.out.print("Universal Set U = {");
        for (int i = 0; i < universalSet.length; i++) {
            System.out.print(universalSet[i]);
            if (i < universalSet.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
        System.out.println("==================================================");
        System.out.println();

        //Testing printSet()
//        printSet("SET A:", setA);
//        printSet("SET B:", setB);
//        printSet("SET C:", setC);

        //Testing printBag()
//        printBag("BAG A:", bagA);
//        printBag("BAG B:", bagB);
//        printBag("BAG C:", bagC);

        //Test all sets
        runSetTests("TEST 1: Set A vs Set B", setA, setB);
        runSetTests("TEST 2: Set A vs Set C", setA, setC);
        runSetTests("TEST 3: Set B vs Set C", setB, setC);

        //Test all bags
        runBagTests("TEST 4: Bag A vs Bag B", bagA, bagB);
        runBagTests("TEST 5: Bag A vs Bag C", bagA, bagC);
        runBagTests("TEST 6: Bag B vs Bag C", bagB, bagC);
    }

    //-----------------------Part 1 Methods-----------------------

    /**
     * Computes the complement of a set with respect to the universal set.
     * The complement contains all elements that are not present in set A.
     *
     * @param A a boolean array representing a subset of the universal set.
     * @return a new boolean array representing the complement.
     */
    static boolean[] complement(boolean[] A){
        boolean[] result = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = !A[i];
        }

        return result;
    }

    /**
     * Compute the union of two sets.
     * The union contains elements that are in either set A or B or both.
     *
     * @param A a boolean array representing the first subset of the universal set.
     * @param B a boolean array representing the second subset of the universal set.
     * @return a new boolean array representing the union.
     */
    static boolean[] union(boolean[] A, boolean[] B){
        boolean[] result = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] || B[i];
        }

        return result;
    }

    /**
     * Computes the intersection of two sets.
     * The intersection contains only elements that are in both A & B.
     *
     * @param A a boolean array representing the first subset of the universal set.
     * @param B a boolean array representing the second subset of the universal set.
     * @return a new boolean array representing the intersection.
     */
    static boolean[] intersection(boolean[] A, boolean[] B){
        boolean[] result = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] && B[i];
        }

        return result;
    }

    /**
     * Computes the difference of two sets.
     * The difference contains elements that are in A, but not in B.
     *
     * @param A a boolean array representing the first subset of the universal set.
     * @param B a boolean array representing the second subset of the universal set.
     * @return a new boolean array representing the difference
     */
    static boolean[] difference(boolean[] A, boolean[] B){
        boolean[] result = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] && !B[i];
        }

        return result;
    }

    /**
     * Computes the symmetric difference of two sets.
     * The symmetric difference contains elements that are in exactly one of the two sets.
     *
     * @param A a boolean array representing the first subset of the universal set
     * @param B a boolean array representing the second subset of the universal set
     * @return a new boolean array representing the symmetric difference
     */
    static boolean[] symmetricDifference(boolean[] A, boolean[] B){
        boolean[] result = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] ^ B[i];
        }

        return result;
    }

    //-----------------------Part 2 Methods-----------------------

    /**
     * Computes the union of two bags.
     * In a multiset union, each element is the largest count between its counts in A & B.
     *
     * @param A an integer array representing the first multiset (bag).
     * @param B an integer array representing the second multiset (bag).
     *          Must be the same length as A.
     * @return a new integer array representing the multiset union.
     */
    static int[] bagUnion(int[] A, int[] B) {

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = Math.max(A[i], B[i]);
        }

        return result;
    }

    /**
     * Computes the intersection of two bags.
     * In a multiset intersection, each element is the minimum between its counts in A & B.
     *
     * @param A an integer array representing the first multiset (bag).
     * @param B an integer array representing the second multiset (bag).
     *          Must be the same length as A.
     * @return a new integer array representing the multiset intersection
     */
    static int[] bagIntersection(int[] A, int[] B) {

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = Math.min(A[i], B[i]);
        }

        return result;
    }

    /**
     * Computes the difference of two bags.
     * In a multiset difference, each element is its count in B - its count in A.
     * If the result is negative the value is set to 0.
     *
     * @param A an integer array representing the first multiset (bag).
     * @param B an integer array representing the second multiset (bag).
     *          Must be the same length as A.
     * @return a new integer array representing the multiset difference
     */
    static int[] bagDifference(int[] A, int[] B) {

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int diff = A[i] - B[i];
            result[i] = Math.max(diff, 0);
        }

        return result;
    }

    /**
     * Computes the sum of two bags.
     * In a multiset sum, each element is the sum of its counts in A & B.
     *
     * @param A an integer array representing the first multiset (bag).
     * @param B an integer array representing the second multiset (bag).
     *          Must be the same length as A.
     * @return a new integer array representing the multiset Sum
     */
    static int[] bagSum(int[] A, int[] B) {

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] + B[i];
        }

        return result;
    }

    //-----------------------Helper Methods-----------------------
    /**
     * A method that takes a set and prints the bit string of the set and its corresponding elements
     * @param label what you want the label of the set to be ie: "SET A"
     * @param set the set that is to be printed
     */
    static void printSet(String label, boolean[] set) {

        System.out.println(label);

        //Print bit string of the set
        System.out.print("Bit string: ");
        for (boolean b : set) {
            if (b) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();

        //Print elements of the set
        System.out.print("Elements: {");

        //A variable that is going to help add a comma separator between elements
        boolean first = true;

        for (int i = 0; i < set.length; i++) {
            if (set[i]) {

                //Add a comma separator before the element
                if (!first) {
                    System.out.print(", ");
                }

                System.out.print(universalSet[i]);
                first = false;
            }
        }

        System.out.println("}");
        System.out.println();
    }

    /**
     * A method that takes a bag and prints its elements then prints
     * the corresponding counts of the universal set.
     * @param label what you want the label of the bag to be ie: "BAG A"
     * @param bag the bag that is to be printed
     */
    static void printBag(String label, int[] bag) {

        System.out.println(label);

        //Print raw elements
        System.out.print("Counts: ");
        for (int j : bag) {
            System.out.print(j + " ");
        }
        System.out.println();

        //Print element × count format
        System.out.print("Elements: {");

        //A variable that is going to help add a comma separator between elements
        boolean first = true;

        for (int i = 0; i < bag.length; i++) {

            //If the count of an element is 1 there is no need to format it with ×1
            if (bag[i] == 1){

                //Add a comma separator before the element
                if (!first) {
                    System.out.print(", ");
                }

                //Get the corresponding element from the universal set
                System.out.print(universalSet[i]);
                first = false;
            }
            else if (bag[i] > 0) {

                //Add a comma separator before the element
                if (!first) {
                    System.out.print(", ");
                }

                //Get the corresponding element from the universal set and the counts from the bag
                System.out.print(universalSet[i] + "×" + bag[i]);
                first = false;
            }
        }

        System.out.println("}");
        System.out.println(); // spacing
    }

    /**
     * Takes two sets and runs all the methods from part one on them
     * Crucially complement(boolean[]) only gets ran on set A
     * @param title the label of the tests to be executed ie: "TEST 1: SET A vs SET B"
     * @param A the first of two sets to be tested
     * @param B the second of two sets to be tested
     */
    static void runSetTests(String title, boolean[] A, boolean[] B) {

        System.out.println("==================================================");
        System.out.println(title);
        System.out.println("==================================================");

        //Print original sets
        printSet("Set 1", A);
        printSet("Set 2", B);

        //Required operations
        printSet("NOT(Set 1)", complement(A));
        printSet("Set 1 ∪ Set 2", union(A, B));
        printSet("Set 1 ∩ Set 2", intersection(A, B));
        printSet("Set 1 - Set 2", difference(A, B));
        printSet("Set 1 ⊕ Set 2", symmetricDifference(A, B));
    }

    /**
     * Takes two bags and runs all the methods from part two on them
     * @param title the label of the tests to be executed ie: "TEST 1: BAG A vs BAG B"
     * @param A the first of two bags to be tested
     * @param B the second of two bags to be tested
     */
    static void runBagTests(String title, int[] A, int[] B) {

        System.out.println("==================================================");
        System.out.println(title);
        System.out.println("==================================================");

        // Print original bags
        printBag("Bag 1", A);
        printBag("Bag 2", B);

        // Required multiset operations
        printBag("Bag 1 ∪ Bag 2", bagUnion(A, B));
        printBag("Bag 1 ∩ Bag 2", bagIntersection(A, B));
        printBag("Bag 1 - Bag 2", bagDifference(A, B));
        printBag("Bag 1 + Bag 2", bagSum(A, B));
    }
}
