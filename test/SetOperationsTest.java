import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SetOperationsTest {
    static String[] universalSet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}; //keeping it simple using letters

    //Create our sets for part 1
    //set A = {a, c, e, g, i}
    static boolean[] setA = {true, false, true, false, true, false, true, false, true, false};
    //set B = {b, c, f, g, j}
    static boolean[] setB = {false, true, true, false, false, true, true, false, false, true};
    //set C = {a, d, e, h, i}
    static boolean[] setC = {true, false, false, true, true, false, false, true, true, false};

    static boolean[] emptySet = {false, false, false, false, false, false, false, false, false, false};

    //Create our bags for part 2
    //Each Bag has multiple values with count > 1
    //Bag A = {a×2, c×3, e, g×2}
    static int[] bagA = {2, 0, 3, 0, 1, 0, 2, 0, 0, 0};
    //Bag B = {a, c×4, d×2, j×3}
    static int[] bagB = {1, 0, 4, 2, 0, 0, 0, 0, 0, 3};
    //Bag C = {b×3, e×2, g, i×4}
    static int[] bagC = {0, 3, 0, 0, 2, 0, 1, 0, 4, 0};

    static int[] emptyBag = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // ---------------------------------------------------------
    // Representative Case Tests
    // ---------------------------------------------------------

    @Test
    void testUnionWithNormalSets() {
        // Set A: {true, false, true, false, true, false, true, false, true, false}
        // Set B: {false, true, true, false, false, true, true, false, false, true}
        // A ∪ B Expected: {true, true, true, false, true, true, true, false, true, true}

        boolean[] expectedUnion = {true, true, true, false, true, true, true, false, true, true};
        assertArrayEquals(expectedUnion, SetOperations.union(setA, setB));
    }

    @Test
    void testComplementNormalSet() {
        // NOT A Expected: {false, true, false, true, false, true, false, true, false, true}
        boolean[] expectedComplement = {false, true, false, true, false, true, false, true, false, true};
        assertArrayEquals(expectedComplement, SetOperations.complement(setA));
    }

    @Test
    void testIntersectionWithNormalSets() {
        // A ∩ B Expected: {false, false, true, false, false, false, true, false, false, false}
        boolean[] expectedIntersection = {false, false, true, false, false, false, true, false, false, false};
        assertArrayEquals(expectedIntersection, SetOperations.intersection(setA, setB));
    }

    @Test
    void testDifferenceWithNormalSets() {
        // A - B Expected: {true, false, false, false, true, false, false, false, true, false}
        boolean[] expectedDifference = {true, false, false, false, true, false, false, false, true, false};
        assertArrayEquals(expectedDifference, SetOperations.difference(setA, setB));
    }

    @Test
    void testSymmetricDifferenceWithNormalSets() {
        // A ⊕ B Expected: {true, true, false, false, true, true, false, false, true, true}
        boolean[] expectedSymDiff = {true, true, false, false, true, true, false, false, true, true};
        assertArrayEquals(expectedSymDiff, SetOperations.symmetricDifference(setA, setB));
    }

    @Test
    void testMultisetSumWithNormalBags() {
        // Bag A: {2, 0, 3, 0, 1, 0, 2, 0, 0, 0}
        // Bag B: {1, 0, 4, 2, 0, 0, 0, 0, 0, 3}
        // A + B Expected: {3, 0, 7, 2, 1, 0, 2, 0, 0, 3}

        int[] expectedSum = {3, 0, 7, 2, 1, 0, 2, 0, 0, 3};
        assertArrayEquals(expectedSum, SetOperations.bagSum(bagA, bagB));
    }

    @Test
    void testMultisetUnionWithNormalBags() {
        // Bag A ∪ Bag B (Max) Expected: {2, 0, 4, 2, 1, 0, 2, 0, 0, 3}
        int[] expectedUnion = {2, 0, 4, 2, 1, 0, 2, 0, 0, 3};
        assertArrayEquals(expectedUnion, SetOperations.bagUnion(bagA, bagB));
    }

    @Test
    void testMultisetIntersectionWithNormalBags() {
        // Bag A ∩ Bag B (Min) Expected: {1, 0, 3, 0, 0, 0, 0, 0, 0, 0}
        int[] expectedIntersection = {1, 0, 3, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expectedIntersection, SetOperations.bagIntersection(bagA, bagB));
    }

    @Test
    void testMultisetDifferenceWithNormalBags() {
        // Bag A - Bag B Expected: {1, 0, 0, 0, 1, 0, 2, 0, 0, 0}
        int[] expectedDifference = {1, 0, 0, 0, 1, 0, 2, 0, 0, 0};
        assertArrayEquals(expectedDifference, SetOperations.bagDifference(bagA, bagB));
    }

    // ---------------------------------------------------------
    // Edge Case Tests
    // ---------------------------------------------------------

    @Test
    void testUnionWithEmptySet() {
        // A ∪ ∅ = A
        assertArrayEquals(setA, SetOperations.union(setA, emptySet));
    }

    @Test
    void testIntersectionWithEmptySet() {
        // A ∩ ∅ = ∅
        assertArrayEquals(emptySet, SetOperations.intersection(setA, emptySet));
    }

    @Test
    void testDifferenceWithEmptySet() {
        // A - ∅ = A
        assertArrayEquals(setA, SetOperations.difference(setA, emptySet));
    }

    @Test
    void testSymmetricDifferenceWithEmptySet() {
        // A ⊕ ∅ = A
        assertArrayEquals(setA, SetOperations.symmetricDifference(setA, emptySet));
    }

    @Test
    void testMultisetUnionWithEmptySet() {
        // Bag A ∪ ∅ = Bag A (Max counts)
        assertArrayEquals(bagA, SetOperations.bagUnion(bagA, emptyBag));
    }

    @Test
    void testMultisetIntersectionWithEmptySet() {
        // Bag A ∩ ∅ = ∅ (Min counts)
        assertArrayEquals(emptyBag, SetOperations.bagIntersection(bagA, emptyBag));
    }

    @Test
    void testMultisetDifferenceWithEmptySet() {
        // Bag A - ∅ = Bag A
        assertArrayEquals(bagA, SetOperations.bagDifference(bagA, emptyBag));
    }

    @Test
    void testMultisetSumWithEmptySet() {
        // Bag A + ∅ = Bag A
        assertArrayEquals(bagA, SetOperations.bagSum(bagA, emptyBag));
    }

    @Test
    void testUnionEmptyVsEmpty() {
        // ∅ ∪ ∅ = ∅
        assertArrayEquals(emptySet, SetOperations.union(emptySet, emptySet));
    }

    @Test
    void testMultisetSumEmptyVsEmpty() {
        // ∅ + ∅ = ∅
        assertArrayEquals(emptyBag, SetOperations.bagSum(emptyBag, emptyBag));
    }
}