import org.example.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberCompareTest {

    @Test
    public void testAIsGreater(){
        String result = NumberCompare.compare(10 ,5 );
        Assert.assertTrue(result.contains("больше"));
    }

    @Test
    public void testAIsLess(){
        String result = NumberCompare.compare(-5 , -3 );
        Assert.assertTrue(result.contains("меньше"));
    }

    @Test
    public void testEqualNumbers(){
        String result = NumberCompare.compare(7 ,7 );
        Assert.assertTrue(result.contains("равно"));
    }
}
