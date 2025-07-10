import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberCompareTest {
    @Test
    void testIsGreater(){
        String result = NumberCompare.compare(10 ,5 );
        assertTrue(result.contains("больше"));
    }

    @Test
    void testIsLess(){
        String result = NumberCompare.compare(-5 , -3 );
        assertTrue(result.contains("меньше"));
    }

    @Test
    void testEqualNumbers(){
        String result = NumberCompare.compare(7 ,7 );
        assertTrue(result.contains("равно"));
    }
}
