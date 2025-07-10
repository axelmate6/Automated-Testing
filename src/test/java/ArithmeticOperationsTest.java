import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {
    @Test
    void testAdd() {
        assertEquals(7.0, ArithmeticOperations.add(3,4));
    }
    @Test
    void testSubtract() {
        assertEquals(-1.0, ArithmeticOperations.subtract(3,4));
    }
    @Test
    void testMultiply() {
        assertEquals(12.0, ArithmeticOperations.multiply(3,4));
    }
    @Test
    void testDivideValid() {
        assertEquals(0.75, ArithmeticOperations.divide(3,4));
    }
    @Test
    void testDivideInvalid() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(3,0));
    }
}
