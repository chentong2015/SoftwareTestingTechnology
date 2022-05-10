package base.junit4.testing;

public class MyJUnit4Class {

    public int calculate(int value) {
        int result;
        if (value <= 1) {
            result = value;
        } else {
            result = calculate(value - 1) + calculate(value - 2);
        }
        return result;
    }

    public static int compute(int value) {
        int result;
        if (value <= 1) {
            result = value;
        } else {
            result = compute(value - 1) + compute(value - 2);
        }
        return result;
    }
}
