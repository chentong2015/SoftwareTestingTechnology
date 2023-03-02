package parameterized.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

public class SubClassTest extends AbstractClassTest {

    public static List<String> getData() {
        return Arrays.asList("item1", "item2");
    }
    
    @ParameterizedTest
    @MethodSource("getData")
    public void testSubClass(String value) {
        System.out.println("value = " + value);
        Assertions.assertTrue(true);
    }
}
