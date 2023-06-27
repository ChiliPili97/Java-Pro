package math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {
    @Test
    void whenMathAbsThenResultCorrect() {
        assertEquals(5, MathUtils.abs(-5));
    }

    @Test
    void whenMathMaxThenResultCorrect() {
        assertEquals(10, MathUtils.max(10, 3));
    }

    @Test
    void whenMathMinThenResultCorrect() {
        assertEquals(3, MathUtils.min(7, 3));
    }

}
