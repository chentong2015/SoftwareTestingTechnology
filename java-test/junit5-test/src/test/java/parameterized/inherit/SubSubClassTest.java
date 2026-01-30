package parameterized.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SubSubClassTest extends SubClassTest {

    @ParameterizedTest
    @MethodSource("getData")
    void testSubSubClass() {
        System.out.println("sub sub test");
        Assertions.assertTrue(true);
    }
}
