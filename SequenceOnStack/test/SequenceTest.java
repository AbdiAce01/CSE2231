import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    // TODO - add test cases for constructor, add, remove, and length

    @Test
    public void testConstructor() {
        Sequence<String> q = this.constructorTest();
        Sequence<String> qExpected = this.constructorRef();
        assertEquals(qExpected, q);

    }

    @Test
    public final void testAdd() {
        Sequence<String> s = this.createFromArgsTest("S", "E");
        s.add(0, "C");
        assertEquals("<C,S,E>", s.toString());
    }

    @Test
    public final void testAddEmpty() {
        Sequence<String> q = this.createFromArgsTest();
        Sequence<String> qExpected = this.createFromArgsRef("green");
        q.add(0, "green");
        assertEquals(qExpected, q);
    }

    @Test
    public final void testLengthEmpty() {
        /*
         * Set up variables
         */
        Sequence<String> q = this.createFromArgsTest();
        Sequence<String> qExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        int i = q.length();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(qExpected, q);
        assertEquals(0, i);
    }

    @Test
    public final void testLengthNonEmpty() {
        /*
         * Set up variables.
         */
        Sequence<String> q = this.createFromArgsTest("green");
        Sequence<String> qExpected = this.createFromArgsRef("green");
        /*
         * Call method under test
         */
        int i = q.length();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(qExpected, q);
        assertEquals(1, i);
    }

    @Test
    public final void testRemove() {
        Sequence<String> q = this.createFromArgsTest("red", "green", "blue");
        Sequence<String> qExpected = this.createFromArgsRef("green", "blue");
        String digit = q.remove(0);
        assertEquals(qExpected, q);
        assertEquals(digit, "red");
    }

    @Test
    public final void testRemoveEmpty() {
        Sequence<String> q = this.createFromArgsTest("blue");
        Sequence<String> qExpected = this.createFromArgsRef();
        String digit = q.remove(0);
        assertEquals(qExpected, q);
        assertEquals(digit, "blue");
    }

}
