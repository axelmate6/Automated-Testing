import org.example.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaTest {

    @Test
    public void testValidTriangle() {
        Double area = TriangleArea.calculateArea(3, 4, 5);
        Assert.assertNotNull(area);
        Assert.assertEquals(area, 6.0, 0.0001);
    }

    @Test
    public void testInvalidTriangle() {
        Double area = TriangleArea.calculateArea(1, 2, 10);
        Assert.assertNull(area);
    }

    @Test
    public void testEquilateralTriangle() {
        Double area = TriangleArea.calculateArea(2, 2, 2);
        Assert.assertNotNull(area);
        double expectedArea = Math.sqrt(3) * Math.pow(2, 2) / 4;
        Assert.assertEquals(area, expectedArea, 0.0001);
    }
}
