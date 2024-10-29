package base.junit4.testing;

public class MyJUnit4Class {

    // 1. For JUnit4 Test Assertions
    public void throwException() throws Exception {
        System.out.println("check throw exception");
        throw new Exception();
    }

    // 2. For JUnit4 Parameterized Test
    public int compute(int value) {
        if (value <= 1) {
            return value;
        } else {
            return compute(value - 1) + compute(value - 2);
        }
    }
}
