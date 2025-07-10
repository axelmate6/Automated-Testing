import org.example.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(ArithmeticOperations.add(3, 4), 7.0);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(ArithmeticOperations.subtract(3, 4), -1.0);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(ArithmeticOperations.multiply(3, 4), 12.0);
    }

    @Test
    public void testDivideValid() {
        Assert.assertEquals(ArithmeticOperations.divide(3, 4), 0.75);
    }

    @Test
    public void testDivideInvalid() {
        Assert.assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(3, 0));
    }
}
