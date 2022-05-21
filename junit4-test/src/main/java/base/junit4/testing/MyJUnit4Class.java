package base.junit4.testing;

public class MyJUnit4Class {

    // 1. For JUnit4 Test Assertions
    public void throwException() throws Exception {
        System.out.println("check throw exception");
        throw new Exception();
    }

    // 2. For JUnit4 Test Lifecycles
    public int calculate(int value) {
        int result;
        if (value <= 1) {
            result = value;
        } else {
            result = calculate(value - 1) + calculate(value - 2);
        }
        return result;
    }

    // 3. For Junit4 Parameterized Test
    public static int compute(int value) {
        if (value <= 1) {
            return value;
        } else {
            return compute(value - 1) + compute(value - 2);
        }
    }
}
