import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @Test
    public void testFactor() {
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(3628800, Factorial.factorial(10));
    }
}