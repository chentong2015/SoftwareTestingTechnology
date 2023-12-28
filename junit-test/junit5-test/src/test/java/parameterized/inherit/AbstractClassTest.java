package parameterized.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AbstractClassTest {

    @BeforeEach
    public void setUp() {
        System.out.println("set up super");
    }

    // 由于这个是抽象类，getData()方法必须在子类中实现
    @ParameterizedTest
    @MethodSource("getData")
    public void testSuper() {
        System.out.println("test super");
        Assertions.assertTrue(true);
    }
}
