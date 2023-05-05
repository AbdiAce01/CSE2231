import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    @Test
    public final void testDefaultConstructor() {
        Map<String, String> s = this.constructorTest();
        Map<String, String> sExpected = this.constructorRef();
        assertEquals(sExpected, s);
    }

    /**
     * Test for add non-Empty.
     */
    @Test
    public final void testAddNonEmpty() {
        Map<String, String> s = this.createFromArgsTest("red", "blue");
        s.add("green", "pink");
        Map<String, String> s2 = this.createFromArgsRef("red", "blue", "green",
                "pink");
        assertEquals(s, s2);
    }

    /**
     * Test for Remove.
     */
    @Test
    public final void testRemove() {
        Map<String, String> s = this.createFromArgsTest("red", "blue", "green",
                "black");
        Map<String, String> sExpected = this.createFromArgsRef("green",
                "black");

        s.remove("red");
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoveEmpty() {
        Map<String, String> s = this.createFromArgsTest("red", "orange");
        Map<String, String> sExpected = this.createFromArgsTest();
        s.remove("red");
        assertEquals(sExpected, s);
    }

    /**
     * Test for Remove-any.
     */
    @Test
    public final void testRemoveAny() {
        Map<String, String> s = this.createFromArgsTest("red", "blue", "green",
                "pink");
        Map<String, String> sExpected = this.createFromArgsTest("red", "blue",
                "green", "pink");
        Map.Pair<String, String> temp = s.removeAny();
        String tempkey = temp.key();
        sExpected.remove(tempkey);
        assertEquals(sExpected, s);
    }

    /**
     * Test for Value.
     */
    @Test
    public final void testValue() {
        Map<String, String> s = this.createFromArgsTest("green", "blue", "red",
                "pink");
        String x = s.value("green");
        String x2 = s.value("red");
        assertEquals("blue", x);
        assertEquals("pink", x2);
    }
    /*
     * Test has Key
     *
     */

    @Test
    public final void testHasKey() {
        Map<String, String> s = this.createFromArgsTest("green", "blue");
        boolean x = s.hasKey("green");
        assertEquals(true, x);
    }

    @Test
    public final void testHasKeydoublePair() {
        Map<String, String> s = this.createFromArgsTest("green", "blue", "red",
                "pink");
        boolean x = s.hasKey("red");
        assertEquals(true, x);
    }
    /*
     * Test Size
     *
     */

    @Test
    public final void testSizenonEmpty() {
        Map<String, String> s = this.createFromArgsTest("blue", "green");
        int i = s.size();
        assertEquals(1, i);
    }

    @Test
    public final void testSizeEmpty() {
        Map<String, String> s = this.createFromArgsTest();
        int i = s.size();
        assertEquals(0, i);
    }

}
