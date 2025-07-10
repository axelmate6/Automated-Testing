import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @Test
    void testFactorialPositive() {
        assertEquals(120, Factorial.factorial(5));
        assertEquals(1, Factorial.factorial(0));
        assertEquals(1, Factorial.factorial(1));
    }

    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }

    @Test
    void testFactorialLargeNumber() {
        assertEquals(3628800, Factorial.factorial(10));
    }
}
