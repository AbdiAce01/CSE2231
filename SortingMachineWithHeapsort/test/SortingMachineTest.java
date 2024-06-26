import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

import components.sortingmachine.SortingMachine;

/**
 * JUnit test fixture for {@code SortingMachine<String>}'s constructor and
 * kernel methods.
 *
 * @author Abdifatah Ashirow
 *
 */
public abstract class SortingMachineTest {

    /**
     * Invokes the appropriate {@code SortingMachine} constructor for the
     * implementation under test and returns the result.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @return the new {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures constructorTest = (true, order, {})
     */
    protected abstract SortingMachine<String> constructorTest(
            Comparator<String> order);

    /**
     * Invokes the appropriate {@code SortingMachine} constructor for the
     * reference implementation and returns the result.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @return the new {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures constructorRef = (true, order, {})
     */
    protected abstract SortingMachine<String> constructorRef(
            Comparator<String> order);

    /**
     *
     * Creates and returns a {@code SortingMachine<String>} of the
     * implementation under test type with the given entries and mode.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @param insertionMode
     *            flag indicating the machine mode
     * @param args
     *            the entries for the {@code SortingMachine}
     * @return the constructed {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * createFromArgsTest = (insertionMode, order, [multiset of entries in args])
     * </pre>
     */
    private SortingMachine<String> createFromArgsTest(Comparator<String> order,
            boolean insertionMode, String... args) {
        SortingMachine<String> sm = this.constructorTest(order);
        for (int i = 0; i < args.length; i++) {
            sm.add(args[i]);
        }
        if (!insertionMode) {
            sm.changeToExtractionMode();
        }
        return sm;
    }

    /**
     *
     * Creates and returns a {@code SortingMachine<String>} of the reference
     * implementation type with the given entries and mode.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @param insertionMode
     *            flag indicating the machine mode
     * @param args
     *            the entries for the {@code SortingMachine}
     * @return the constructed {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * createFromArgsRef = (insertionMode, order, [multiset of entries in args])
     * </pre>
     */
    private SortingMachine<String> createFromArgsRef(Comparator<String> order,
            boolean insertionMode, String... args) {
        SortingMachine<String> sm = this.constructorRef(order);
        for (int i = 0; i < args.length; i++) {
            sm.add(args[i]);
        }
        if (!insertionMode) {
            sm.changeToExtractionMode();
        }
        return sm;
    }

    /**
     * Comparator<String> implementation to be used in all test cases. Compare
     * {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }

    }

    /**
     * Comparator instance to be used in all test cases.
     */
    private static final StringLT ORDER = new StringLT();

    /*
     * Sample test cases.
     */

    @Test
    public final void testConstructor() {
        SortingMachine<String> m = this.constructorTest(ORDER);
        SortingMachine<String> mExpected = this.constructorRef(ORDER);
        assertEquals(mExpected, m);
    }

    @Test
    public final void testAddEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "green");
        m.add("green");
        assertEquals(mExpected, m);
    }

    // TODO - add test cases for add, changeToExtractionMode, removeFirst,
    // isInInsertionMode, order, and size

    /**
     * Tests add: routine case, adding to SortingMachine of odd length.
     */
    @Test
    public final void testAddToNonEmptyOddLength() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true,
                "test1", "test2", "test3");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true,
                "test1", "test2", "test3", "test4");
        /*
         * Call method under test
         */
        test.add("test4");
        /*
         * Assert variable values meet expectations
         */
        assertEquals(ref, test);
    }

    /**
     * Tests add: routine case, adding to SortingMachine of even length.
     */
    @Test
    public final void testAddToNonEmptyEvenLength() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true,
                "test1", "test2");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true,
                "test1", "test2", "test4");
        /*
         * Call method under test
         */
        test.add("test4");
        /*
         * Assert variable values meet expectations
         */
        assertEquals(ref, test);
    }

    /**
     * Tests changeToExtractionMode: boundary case, SortingMachine of length
     * zero.
     */
    @Test
    public final void testChangeToExtractionModeEmpty() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true);
        /*
         * Call method under test
         */
        test.changeToExtractionMode();
        ref.changeToExtractionMode();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(ref, test);
    }

    /**
     * Tests changeToExtractionMode: routine case, SortingMachine of even
     * length.
     */
    @Test
    public final void testChangeToExtractionModeEvenLength() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true,
                "test1", "test2");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true,
                "test1", "test2");
        /*
         * Call method under test
         */
        test.changeToExtractionMode();
        ref.changeToExtractionMode();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(ref, test);
    }

    /**
     * Tests changeToExtractionMode: routine case, SortingMachine of odd length.
     */
    @Test
    public final void testChangeToExtractionModeOddLength() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true,
                "test1", "test2", "test3");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true,
                "test1", "test2", "test3");
        /*
         * Call method under test
         */
        test.changeToExtractionMode();
        ref.changeToExtractionMode();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(ref, test);
    }

    /**
     * Tests removeFirst: boundary case, SortingMachine of length one.
     */
    @Test
    public final void testRemoveFirstToEmpty() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false,
                "test1");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false,
                "test1");

        /*
         * Call method under test
         */
        String removedTest = test.removeFirst();
        String removedRef = ref.removeFirst();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(removedRef, removedTest);
        assertEquals(ref, test);
    }

    /**
     * Tests removeFirst: routine case, SortingMachine of odd length.
     */
    @Test
    public final void testRemoveFirstOddNonEmpty() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false,
                "test1", "test2", "test3");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false,
                "test1", "test2", "test3");

        /*
         * Call method under test
         */
        String removedTest = test.removeFirst();
        String removedRef = ref.removeFirst();

        /*
         * Assert variable values meet expectations
         */
        assertEquals(removedRef, removedTest);
        assertEquals(ref, test);
    }

    /**
     * Tests removeFirst: routine case, SortingMachine of even length.
     */
    @Test
    public final void testRemoveFirstEvenNonEmpty() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false,
                "test1", "test2");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false,
                "test1", "test2");

        /*
         * Call method under test
         */
        String removedTest = test.removeFirst();
        String removedRef = ref.removeFirst();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(removedRef, removedTest);
        assertEquals(ref, test);
    }

    /**
     * Tests isInsertionMode: boundary case, SortingMachine of length zero.
     */
    @Test
    public final void testIsInInsertionModeEmptyFalse() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false);
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false);

        /*
         * Call method under test
         */
        boolean insertionTest = test.isInInsertionMode();
        boolean insertionRef = ref.isInInsertionMode();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(insertionRef, insertionTest);
        assertEquals(ref, test);
    }

    /**
     * Tests isInsertionMode: boundary case, SortingMachine of length zero.
     */
    @Test
    public final void testIsInInsertionModeEmptyTrue() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true);

        /*
         * Call method under test
         */
        boolean insertionTest = test.isInInsertionMode();
        boolean insertionRef = ref.isInInsertionMode();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(insertionRef, insertionTest);
        assertEquals(ref, test);
    }

    /**
     * Tests isInsertionMode: routine case, SortingMachine of length >zero.
     */
    @Test
    public final void testIsInInsertionModeNonEmptyTrue() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true,
                "test1", "test2");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true,
                "test1", "test2");

        /*
         * Call method under test
         */
        boolean insertionTest = test.isInInsertionMode();
        boolean insertionRef = ref.isInInsertionMode();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(insertionRef, insertionTest);
        assertEquals(ref, test);
    }

    /**
     * Tests isInsertionMode: routine case, SortingMachine of length >zero.
     */
    @Test
    public final void testIsInInsertionModeNonEmptyFalse() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false,
                "test1", "test2");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false,
                "test1", "test2");

        /*
         * Call method under test
         */
        boolean insertionTest = test.isInInsertionMode();
        boolean insertionRef = ref.isInInsertionMode();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(insertionRef, insertionTest);
        assertEquals(ref, test);
    }

    /**
     * Tests order: boundary case, SortingMachine of length zero(insertionMode).
     */
    @Test
    public final void testOrderEmptyInsertion() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true);

        /*
         * Call method under test
         */
        Comparator<String> orderTest = test.order();
        Comparator<String> orderRef = ref.order();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(orderRef, orderTest);
        assertTrue(orderRef == orderTest);
        assertEquals(ref, test);
    }

    /**
     * Tests order: boundary case, SortingMachine of length
     * zero(extractionMode).
     */
    @Test
    public final void testOrderEmptyExtraction() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false);
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false);

        /*
         * Call method under test
         */
        Comparator<String> orderTest = test.order();
        Comparator<String> orderRef = ref.order();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(orderRef, orderTest);
        assertTrue(orderRef == orderTest);
        assertEquals(ref, test);
    }

    /**
     * Tests order: routine case, SortingMachine of length >zero (insertion
     * mode).
     */
    @Test
    public final void testOrderNonEmptyInsertion() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true,
                "test1", "test2");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true,
                "test1", "test2");

        /*
         * Call method under test
         */
        Comparator<String> orderTest = test.order();
        Comparator<String> orderRef = ref.order();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(orderRef, orderTest);
        assertTrue(orderRef == orderTest);
        assertEquals(ref, test);
    }

    /**
     * Tests order: routine case, SortingMachine of length >zero (extraction
     * mode).
     */
    @Test
    public final void testOrderNonEmptyExtraction() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false,
                "test1", "test2");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false,
                "test1", "test2");

        /*
         * Call method under test
         */
        Comparator<String> orderTest = test.order();
        Comparator<String> orderRef = ref.order();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(orderRef, orderTest);
        assertTrue(orderRef == orderTest);
        assertEquals(ref, test);
    }

    /**
     * Tests size: boundary case, SortingMachine(insertionMode) of length zero.
     */
    @Test
    public final void testSizeEmptyInsertion() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true);

        /*
         * Call method under test
         */
        int sizeTest = test.size();
        int sizeRef = ref.size();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(sizeRef, sizeTest);
        assertEquals(ref, test);
    }

    /**
     * Tests size: boundary case, SortingMachine(extraction mode) of length
     * zero.
     */
    @Test
    public final void testSizeEmptyExtraction() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false);
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false);

        /*
         * Call method under test
         */
        int sizeTest = test.size();
        int sizeRef = ref.size();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(sizeRef, sizeTest);
        assertEquals(ref, test);
    }

    /**
     * Tests size: routine case, SortingMachine(insertion mode) of length >zero.
     */
    @Test
    public final void testSizeNonEmptyInsertion() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, true,
                "test1", "test2", "test3");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, true,
                "test1", "test2", "test3");
        /*
         * Call method under test
         */
        int sizeTest = test.size();
        int sizeRef = ref.size();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(sizeRef, sizeTest);
        assertEquals(ref, test);
    }

    /**
     * Tests size: routine case, SortingMachine(extraction mode) of length
     * >zero.
     */
    @Test
    public final void testSizeNonEmptyExtraction() {
        /*
         * Set up variables
         *
         */
        SortingMachine<String> test = this.createFromArgsTest(ORDER, false,
                "test1", "test2", "test3");
        SortingMachine<String> ref = this.createFromArgsRef(ORDER, false,
                "test1", "test2", "test3");

        /*
         * Call method under test
         */
        int sizeTest = test.size();
        int sizeRef = ref.size();
        /*
         * Assert variable values meet expectations
         */
        assertEquals(sizeRef, sizeTest);
        assertEquals(ref, test);
    }

}
