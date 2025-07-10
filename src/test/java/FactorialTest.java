import org.example.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testFactorialPositive() {
        Assert.assertEquals(Factorial.factorial(5), 120);
        Assert.assertEquals(Factorial.factorial(0), 1);
        Assert.assertEquals(Factorial.factorial(1), 1);
    }

    @Test
    public void testFactorialNegative() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {Factorial.factorial(-1);});
    }

    @Test
    public void testFactorialLargeNumber() {
        Assert.assertEquals(Factorial.factorial(10), 3628800);
    }
}
