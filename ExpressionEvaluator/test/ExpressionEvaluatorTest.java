import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code ExpressionEvaluator}'s {@code valueOfExpr}
 * static method.
 *
 * @author Put your name here
 *
 */
public final class ExpressionEvaluatorTest {

    @Test
    public void testExample() {
        StringBuilder exp = new StringBuilder(
                "281/7/2-1-5*(15-(14-1))+((1))+20=30!");
        int value = ExpressionEvaluator.valueOfExpr(exp);
        assertEquals(30, value);
        assertEquals("=30!", exp.toString());
    }

    // TODO - add other (simpler) test cases to help with debugging

    /*
     * Boundary case: single digit expression
     */
    @Test
    public void testSingleDigit() {
        StringBuilder exp = new StringBuilder("4=4!");
        int value = ExpressionEvaluator.valueOfExpr(exp);
        assertEquals(4, value);
        assertEquals("=4!", exp.toString());
    }

    /*
     * Routine case: single digit in parenthesis
     */
    @Test
    public void testParenthesisSingleDigit() {
        StringBuilder exp = new StringBuilder("(10)=10!");
        int value = ExpressionEvaluator.valueOfExpr(exp);
        assertEquals(10, value);
        assertEquals("=10!", exp.toString());
    }

    /*
     * Routine case: parenthesis with multop
     */
    @Test
    public void testParenthesisMultop() {
        StringBuilder exp = new StringBuilder("(7*3)/3=7!");
        int value = ExpressionEvaluator.valueOfExpr(exp);
        assertEquals(7, value);
        assertEquals("=7!", exp.toString());
    }

    @Test
    public void testParenthesisMultop1() {
        StringBuilder exp = new StringBuilder("10*5-11+70*(20-2)=1299!");
        int value = ExpressionEvaluator.valueOfExpr(exp);
        assertEquals(1299, value);
        assertEquals("=1299!", exp.toString());
    }

}
