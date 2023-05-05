import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTree1;

/**
 * JUnit test fixture for {@code BinarySearchTreeMethods}'s static methods
 * isInTree (and removeSmallest).
 */
public final class BinarySearchTreeMethodsTest {

    /**
     * Constructs and return a BST created by inserting the given {@code args}
     * into an empty tree in the order in which they are provided.
     *
     * @param args
     *            the {@code String}s to be inserted in the tree
     * @return the BST with the given {@code String}s
     * @requires [the Strings in args are all distinct]
     * @ensures createBSTFromArgs = [the BST with the given Strings]
     */
    private static BinaryTree<String> createBSTFromArgs(String... args) {
        BinaryTree<String> t = new BinaryTree1<String>();
        for (String s : args) {
            BinaryTreeUtility.insertInTree(t, s);
        }
        return t;
    }

    /*
     * Test SampleTest
     */
    @Test
    public void sampleTest() {
        /*
         * Set up variables
         */
        BinaryTree<String> t1 = createBSTFromArgs("b", "a", "c");
        BinaryTree<String> t2 = createBSTFromArgs("b", "a", "c");
        /*
         * Call method under test
         */
        boolean inTree = BinarySearchTreeMethods.isInTree(t1, "a");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, inTree);
        assertEquals(t2, t1);
    }

    /**
     * Test isInTree *Routine*.
     */
    @Test
    public final void TestisInTreeRoutine() {
        BinaryTree<String> t1 = createBSTFromArgs("C", "S", "E");
        BinaryTree<String> t2 = createBSTFromArgs("C", "S", "E");

        boolean isintree = BinarySearchTreeMethods.isInTree(t1, "S");
        assertEquals(true, isintree);
        assertEquals(t2, t1);
    }

    /**
     * Test isInTree *boundary*.
     */
    @Test
    public final void TestisInTreeBoundary() {
        BinaryTree<String> t1 = createBSTFromArgs("C");
        BinaryTree<String> t2 = createBSTFromArgs("C");

        boolean isintree = BinarySearchTreeMethods.isInTree(t1, "C");
        assertEquals(true, isintree);
        assertEquals(t2, t1);
    }

    /**
     * Test isInTree *Challenging*.
     */
    @Test
    public final void TestisInTreeChallege() {
        BinaryTree<String> t1 = createBSTFromArgs("S", "O", "F", "T", "W", "A",
                "R", "E");
        BinaryTree<String> t2 = createBSTFromArgs("S", "O", "F", "T", "W", "A",
                "R", "E");

        boolean isintree = BinarySearchTreeMethods.isInTree(t1, "W");
        assertEquals(true, isintree);
        assertEquals(t2, t1);
    }

    /**
     * Test RemoveSmallest *Routine*.
     */
    @Test
    public final void TestremoveSmallestRoutine() {
        BinaryTree<String> t1 = createBSTFromArgs("C", "S", "E");
        BinaryTree<String> t2 = createBSTFromArgs("C", "S", "E");

        boolean isintree = BinarySearchTreeMethods.isInTree(t1, "E");
        assertEquals(true, isintree);
        assertEquals(t2, t1);
    }

    /**
     * RemoveSmallest *Boundary*.
     */
    @Test
    public final void TestremoveSmallestBoundary() {
        BinaryTree<String> t1 = createBSTFromArgs("A");
        BinaryTree<String> t2 = createBSTFromArgs("A");

        boolean isintree = BinarySearchTreeMethods.isInTree(t1, "A");
        assertEquals(true, isintree);
        assertEquals(t2, t1);
    }

    /**
     * RemoveSmallest *Challegeing*.
     */
    @Test
    public final void TestremoveSmallestChallege() {
        BinaryTree<String> t1 = createBSTFromArgs("S", "O", "F", "T", "W", "A",
                "R", "E");
        BinaryTree<String> t2 = createBSTFromArgs("S", "O", "F", "T", "W", "A",
                "R", "E");

        boolean isintree = BinarySearchTreeMethods.isInTree(t1, "R");
        assertEquals(true, isintree);
        assertEquals(t2, t1);
    }

}
