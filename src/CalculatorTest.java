import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        this.calculator = null;
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(100, this.calculator.add(100));
        Assertions.assertEquals(150, this.calculator.add(50));
        Assertions.assertEquals(200, this.calculator.add(50));
    }

    @Test
    void testSub() {
        Assertions.assertEquals(-100, this.calculator.sub(100));
        Assertions.assertEquals(-200, this.calculator.sub(100));
    }
}