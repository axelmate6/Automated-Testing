import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {
    @Test
    void testValidTriangle() {
        Double area = TriangleArea.calculateArea(3, 4, 5);
        assertNotNull(area);
        assertEquals(6.0, area, 0.0001);
    }

    @Test
    void testInvalidTriangle() {
        Double area = TriangleArea.calculateArea(1, 2, 10);
        assertNull(area);
    }

    @Test
    void testEquilateralTriangle() {
        Double area = TriangleArea.calculateArea(2, 2, 2);
        assertNotNull(area);
        double expectedArea = Math.sqrt(3) * Math.pow(2, 2) / 4;
        assertEquals(expectedArea, area, 0.0001);
    }
}
