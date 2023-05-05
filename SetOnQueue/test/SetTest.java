import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    // TODO - add test cases for constructor, add, remove, removeAny, contains, and size

    @Test
    public void testConstructor() {
        Set<String> q = this.constructorTest();
        Set<String> qExpected = this.constructorRef();
        assertEquals(qExpected, q);

    }

    @Test
    public final void testAddNonEmpty() {

        Set<String> q = this.createFromArgsTest("red", "blue");
        Set<String> qExpected = this.createFromArgsRef("pink", "red", "blue");
        /*
         * ,* Call method under test ,
         */
        q.add("pink");
        /*
         * ,* Assert that values of variables match expectations ,
         */
        assertEquals(qExpected, q);
    }

    @Test
    public final void testAddEmpty() {
        Set<String> q = this.createFromArgsTest();
        Set<String> qExpected = this.createFromArgsRef("green");
        q.add("green");

        assertEquals(qExpected, q);
    }

    @Test
    public final void testRemoveNonEmpty() {
        /*
         * ,* Set up variables ,
         */
        Set<String> q = this.createFromArgsTest("pink", "red", "blue");
        Set<String> qExpected = this.createFromArgsRef("red", "blue");
        /*
         * ,* Call method under test ,
         */
        q.remove("pink");
        /*
         * ,* Assert that values of variables match expectations ,
         */
        assertEquals(qExpected, q);
    }

    @Test
    public final void testContains() {
        /*
         * ,* Set up variables ,
         */
        Set<String> q = this.createFromArgsTest("pink", "red", "blue");
        Set<String> qExpected = this.createFromArgsRef("pink", "red", "blue");
        /*
         * ,* Call method under test ,
         */
        String color = "blue";
        assertTrue(qExpected.contains(color) && q.contains(color));

    }

    @Test
    public final void testRemoveAny() {
        /*
         * ,* Set up variables ,
         */
        Set<String> q = this.createFromArgsTest("pink", "red", "blue");
        Set<String> qExpected = this.createFromArgsRef("pink", "red", "blue");
        /*
         * ,* Call method under test ,
         */
        String color = q.removeAny();
        qExpected.remove(color);
        assertEquals(qExpected, q);
    }

    @Test
    public final void testSize() {
        /*
         * ,* Set up variables ,
         */
        Set<String> q = this.createFromArgsTest("pink", "red", "blue");
        Set<String> qExpected = this.createFromArgsRef("pink", "red", "blue");
        /*
         * ,* Call method under test ,
         */

        assertEquals(qExpected.size(), q.size());
    }

}
