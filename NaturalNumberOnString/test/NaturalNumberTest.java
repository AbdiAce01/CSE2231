import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Alexis Martinez
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    // TODO - add test cases for four constructors, multiplyBy10, divideBy10, isZero

    /*
     * Test cases for no argument constructor
     */

    @Test
    public final void testNoArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest();
        NaturalNumber sExpected = this.constructorRef();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for int constructor with 0
     */

    @Test
    public final void testIntConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(0);
        NaturalNumber sExpected = this.constructorRef(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for String constructor
     */

    @Test
    public final void testStringConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for NatNum constructor
     */

    @Test
    public final void testNatNumConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest());
        NaturalNumber sExpected = this.constructorRef(this.constructorRef());
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /**
     * TEST CASES FOR multiplyBy10
     */

    /*
     * Test case for multiplyBy10 in empty Constructor. 0 and add 0
     */

    @Test
    public final void testmultiplyBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest();
        NaturalNumber sExpected = this.constructorRef();

        /*
         * Call method under test
         */
        s.multiplyBy10(0);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 in Integer Constructor. 0 and add 0
     */

    @Test
    public final void testIntMultiplyBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(0);
        NaturalNumber sExpected = this.constructorRef(0);

        /*
         * Call method under test
         */
        s.multiplyBy10(0);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 in String Constructor. 0 and add 0
     */

    @Test
    public final void testStringMultiplyBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("0");

        /*
         * Call method under test
         */
        s.multiplyBy10(0);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 in NaturalNumber Constructor. 0 and add 0
     */

    @Test
    public final void testNatNumMultiplyBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest());
        NaturalNumber sExpected = this.constructorRef(this.constructorRef());

        /*
         * Call method under test
         */
        s.multiplyBy10(0);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on empty constructor. 0 and add 9
     */

    @Test
    public final void testEmptyZeromultiplyBy10Add9() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest();
        NaturalNumber sExpected = this.constructorRef(9);
        /*
         * Call method under test
         */
        s.multiplyBy10(9);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on Integer Constructor. 0 and add 9
     */

    @Test
    public final void testIntZeromultiplyBy10Add9() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(0);
        NaturalNumber sExpected = this.constructorRef(9);
        /*
         * Call method under test
         */
        s.multiplyBy10(9);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on String Constructor. 0 and add 9
     */

    @Test
    public final void testStringZeromultiplyBy10Add9() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("9");
        /*
         * Call method under test
         */
        s.multiplyBy10(9);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on NaturalNumber constructor. 0 and add 9
     */

    @Test
    public final void testNatNumZeromultiplyBy10Add9() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest());
        NaturalNumber sExpected = this.constructorRef(this.constructorRef(9));
        /*
         * Call method under test
         */
        s.multiplyBy10(9);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /*
     * Test case for multiplyBy10 on empty constructor. 0 and add 1
     */

    @Test
    public final void testEmptyZeromultiplyBy10Add1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest();
        NaturalNumber sExpected = this.constructorRef(1);
        /*
         * Call method under test
         */
        s.multiplyBy10(1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on Integer Constructor. 0 and add 1
     */

    @Test
    public final void testIntZeromultiplyBy10Add1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(0);
        NaturalNumber sExpected = this.constructorRef(1);
        /*
         * Call method under test
         */
        s.multiplyBy10(1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on String constructor. 0 and add 1
     */

    @Test
    public final void testStringZeromultiplyBy10Add1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("1");
        /*
         * Call method under test
         */
        s.multiplyBy10(1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on NaturalNumber constructor. 0 and add 1
     */

    @Test
    public final void testNatNumZeromultiplyBy10Add1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest());
        NaturalNumber sExpected = this.constructorRef(this.constructorRef(1));
        /*
         * Call method under test
         */
        s.multiplyBy10(1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /*
     * Test case for multiplyBy10 on Integer Constructor. 9 and add 9
     */

    @Test
    public final void testIntNinemultiplyBy10Add9() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(9);
        NaturalNumber sExpected = this.constructorRef(99);
        /*
         * Call method under test
         */
        s.multiplyBy10(9);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on String constructor. 9 and add 9
     */

    @Test
    public final void testStringNinemultiplyBy10Add9() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("9");
        NaturalNumber sExpected = this.constructorRef("99");
        /*
         * Call method under test
         */
        s.multiplyBy10(9);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on NaturalNumber constructor. 9 and add 9
     */

    @Test
    public final void testNatNumNinemultiplyBy10Add9() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(9));
        NaturalNumber sExpected = this.constructorRef(this.constructorRef(99));
        /*
         * Call method under test
         */
        s.multiplyBy10(9);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /*
     * Test case for multiplyBy10 on Integer Constructor. 100010 and add 0
     */

    @Test
    public final void testIntManyZeroesmultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(100010);
        NaturalNumber sExpected = this.constructorRef(1000100);
        /*
         * Call method under test
         */
        s.multiplyBy10(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on String constructor. 100010 and add 0
     */

    @Test
    public final void testStringManyZeroesmultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("100010");
        NaturalNumber sExpected = this.constructorRef("1000100");
        /*
         * Call method under test
         */
        s.multiplyBy10(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on NaturalNumber constructor. 100010 and add 0
     */

    @Test
    public final void testNatNumManyZeroesmultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(100010));
        NaturalNumber sExpected = this
                .constructorRef(this.constructorRef(1000100));
        /*
         * Call method under test
         */
        s.multiplyBy10(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /*
     * Test case for multiplyBy10 on Integer Constructor. 84746453 and add 0
     */

    @Test
    public final void testIntLargemultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(84746453);
        NaturalNumber sExpected = this.constructorRef(847464530);
        /*
         * Call method under test
         */
        s.multiplyBy10(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on String constructor. 84746453 and add 0
     */

    @Test
    public final void testStringLargemultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("84746453");
        NaturalNumber sExpected = this.constructorRef("847464530");
        /*
         * Call method under test
         */
        s.multiplyBy10(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on NaturalNumber constructor. 84746453 and add
     * 0
     */

    @Test
    public final void testNatNumLargemultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(84746453));
        NaturalNumber sExpected = this
                .constructorRef(this.constructorRef(847464530));
        /*
         * Call method under test
         */
        s.multiplyBy10(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /*
     * Test case for multiplyBy10 on Integer Constructor. Max Integer and add 0
     */

    @Test
    public final void testIntMaxmultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(214748364);
        NaturalNumber sExpected = this.constructorRef(Integer.MAX_VALUE);
        /*
         * Call method under test
         */
        s.multiplyBy10(7);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on String constructor. Max Integer and add 0
     */

    @Test
    public final void testStringMaxmultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("214748364");
        NaturalNumber sExpected = this.constructorRef("2147483647");
        /*
         * Call method under test
         */
        s.multiplyBy10(7);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);

    }

    /*
     * Test case for multiplyBy10 on NaturalNumber constructor. Max Integer and
     * add 0
     */

    @Test
    public final void testNatNumMaxmultiplyBy10Add0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(214748364));
        NaturalNumber sExpected = this
                .constructorRef(this.constructorRef(Integer.MAX_VALUE));
        /*
         * Call method under test
         */
        s.multiplyBy10(7);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * TEST CASES FOR divideBy10
     */

    /*
     * Test case for divideBy10 in empty Constructor. 0
     */

    @Test
    public final void testDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest();
        NaturalNumber sExpected = this.constructorRef();
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int zero = 0;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, zero);

    }

    /*
     * Test case for divideBy10 in Integer Constructor. 0
     */

    @Test
    public final void testIntDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(0);
        NaturalNumber sExpected = this.constructorRef(0);
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int zero = 0;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, zero);

    }

    /*
     * Test case for divideBy10 in String Constructor. 0
     */

    @Test
    public final void testStringDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int zero = 0;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, zero);

    }

    /*
     * Test case for divideBy10 in NaturalNumber Constructor. 0
     */

    @Test
    public final void testNatNumDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest());
        NaturalNumber sExpected = this.constructorRef(this.constructorRef());
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int zero = 0;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, zero);

    }

    /*
     * Test case for divideBy10 in empty Constructor. 1
     */

    @Test
    public final void testOneDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(1);
        NaturalNumber sExpected = this.constructorRef();
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int one = 1;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, one);

    }

    /*
     * Test case for divideBy10 in Integer Constructor. 1
     */

    @Test
    public final void testIntOneDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(1);
        NaturalNumber sExpected = this.constructorRef(0);
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int one = 1;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, one);

    }

    /*
     * Test case for divideBy10 in String Constructor. 1
     */

    @Test
    public final void testStringOneDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("1");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int one = 1;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, one);

    }

    /*
     * Test case for divideBy10 in NaturalNumber Constructor. 1
     */

    @Test
    public final void testNatNumOneDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(1));
        NaturalNumber sExpected = this.constructorRef(this.constructorRef());
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int one = 1;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, one);

    }

    /*
     * Test case for divideBy10 in empty Constructor. 9
     */

    @Test
    public final void testNineDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(9);
        NaturalNumber sExpected = this.constructorRef();
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int nine = 9;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, nine);

    }

    /*
     * Test case for divideBy10 in Integer Constructor. 9
     */

    @Test
    public final void testIntNineDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(9);
        NaturalNumber sExpected = this.constructorRef(0);
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int nine = 9;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, nine);

    }

    /*
     * Test case for divideBy10 in String Constructor. 9
     */

    @Test
    public final void testStringNineDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("9");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int nine = 9;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, nine);

    }

    /*
     * Test case for divideBy10 in NaturalNumber Constructor. 9
     */

    @Test
    public final void testNatNumNineDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(9));
        NaturalNumber sExpected = this.constructorRef(this.constructorRef());
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int nine = 9;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, nine);

    }

    /*
     * Test case for divideBy10 in Integer Constructor. 10
     */

    @Test
    public final void testIntTenDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(10);
        NaturalNumber sExpected = this.constructorRef(1);
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int zero = 0;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, zero);

    }

    /*
     * Test case for divideBy10 in String Constructor. 10
     */

    @Test
    public final void testStringTenDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("10");
        NaturalNumber sExpected = this.constructorRef("1");
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int zero = 0;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, zero);

    }

    /*
     * Test case for divideBy10 in NaturalNumber Constructor. 10
     */

    @Test
    public final void testNatNumTenDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(10));
        NaturalNumber sExpected = this.constructorRef(this.constructorRef(1));
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int zero = 0;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, zero);

    }

    /*
     * Test case for divideBy10 in Integer Constructor. 6758493
     */

    @Test
    public final void testIntLargeDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(6758493);
        NaturalNumber sExpected = this.constructorRef(675849);
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int three = 3;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, three);

    }

    /*
     * Test case for divideBy10 in String Constructor. 6758493
     */

    @Test
    public final void testStringLargeDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("6758493");
        NaturalNumber sExpected = this.constructorRef("675849");
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int three = 3;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, three);

    }

    /*
     * Test case for divideBy10 in NaturalNumber Constructor. 6758493
     */

    @Test
    public final void testNatNumLargeDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(6758493));
        NaturalNumber sExpected = this
                .constructorRef(this.constructorRef(675849));
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int three = 3;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, three);

    }

    /*
     * Test case for divideBy10 in Integer Constructor. 101010101
     */

    @Test
    public final void testIntManyZeroesDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(101010101);
        NaturalNumber sExpected = this.constructorRef(10101010);
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int one = 1;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, one);

    }

    /*
     * Test case for divideBy10 in String Constructor. 101010101
     */

    @Test
    public final void testStringManyZeroesDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("101010101");
        NaturalNumber sExpected = this.constructorRef("10101010");
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int one = 1;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, one);

    }

    /*
     * Test case for divideBy10 in NaturalNumber Constructor. 101010101
     */

    @Test
    public final void testNatNumManyZeroesDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(101010101));
        NaturalNumber sExpected = this
                .constructorRef(this.constructorRef(10101010));
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int one = 1;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, one);

    }

    /*
     * Test case for divideBy10 in Integer Constructor. Integer.MAX_VALUE
     */

    @Test
    public final void testIntMaxDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(Integer.MAX_VALUE);
        NaturalNumber sExpected = this.constructorRef(214748364);
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int seven = 7;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, seven);

    }

    /*
     * Test case for divideBy10 in String Constructor. Integer.MAX_VALUE
     */

    @Test
    public final void testStringMaxDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("2147483647");
        NaturalNumber sExpected = this.constructorRef("214748364");
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int seven = 7;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, seven);

    }

    /*
     * Test case for divideBy10 in NaturalNumber Constructor. Integer.MAX_VALUE
     */

    @Test
    public final void testNatNumMaxDivideBy10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this
                .constructorTest(this.constructorTest(Integer.MAX_VALUE));
        NaturalNumber sExpected = this
                .constructorRef(this.constructorRef(214748364));
        /*
         * Call method under test
         */
        int remainder = s.divideBy10();
        int seven = 7;
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(remainder, seven);

    }

    /**
     * TEST CASES FOR divideBy10
     */

    /*
     * Test case for isZero on empty constructor. Checking empty
     */

    @Test
    public final void testEmptyisZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest();
        NaturalNumber sExpected = this.constructorRef();
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, true);
        assertEquals(sExpectedCheck, true);

    }

    /*
     * Test case for isZero on NaturalNumber constructor. Checking empty
     */

    @Test
    public final void testNatNumisZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest());
        NaturalNumber sExpected = this.constructorRef(this.constructorRef());
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, true);
        assertEquals(sExpectedCheck, true);
    }

    /*
     * Test case for isZero on Integer constructor. Checking 0
     */

    @Test
    public final void testIntisZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(0);
        NaturalNumber sExpected = this.constructorRef(0);
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, true);
        assertEquals(sExpectedCheck, true);

    }

    /*
     * Test case for isZero on String constructor. Checking 0
     */

    @Test
    public final void testStringisZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, true);
        assertEquals(sExpectedCheck, true);
    }

    /*
     * Test case for isZero on NaturalNumber constructor. Checking 0
     */

    @Test
    public final void testNatNumisZeroInt() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(0));
        NaturalNumber sExpected = this.constructorRef(this.constructorRef(0));
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, true);
        assertEquals(sExpectedCheck, true);
    }

    /*
     * Test case for isZero on Integer constructor. Checking 1
     */

    @Test
    public final void testIntisZeroNonZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(1);
        NaturalNumber sExpected = this.constructorRef(1);
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, false);
        assertEquals(sExpectedCheck, false);

    }

    /*
     * Test case for isZero on String constructor. Checking 1
     */

    @Test
    public final void testStringisZeroNonZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("1");
        NaturalNumber sExpected = this.constructorRef("1");
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, false);
        assertEquals(sExpectedCheck, false);
    }

    /*
     * Test case for isZero on NaturalNumber constructor. Checking 1
     */

    @Test
    public final void testNatNumisZeroNonZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(1));
        NaturalNumber sExpected = this.constructorRef(this.constructorRef(1));
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, false);
        assertEquals(sExpectedCheck, false);
    }

    /*
     * Test case for isZero on Integer constructor. Checking 10100
     */

    @Test
    public final void testIntisZeroEndingZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(10100);
        NaturalNumber sExpected = this.constructorRef(10100);
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, false);
        assertEquals(sExpectedCheck, false);

    }

    /*
     * Test case for isZero on String constructor. Checking 10100
     */

    @Test
    public final void testStringisZeroEndingZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("10100");
        NaturalNumber sExpected = this.constructorRef("10100");
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, false);
        assertEquals(sExpectedCheck, false);
    }

    /*
     * Test case for isZero on NaturalNumber constructor. Checking 10100
     */

    @Test
    public final void testNatNumisZeroEndingZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorTest(10100));
        NaturalNumber sExpected = this
                .constructorRef(this.constructorRef(10100));
        /*
         * Call method under test
         */
        boolean sCheck = s.isZero();
        boolean sExpectedCheck = s.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(sCheck, false);
        assertEquals(sExpectedCheck, false);
    }
}
