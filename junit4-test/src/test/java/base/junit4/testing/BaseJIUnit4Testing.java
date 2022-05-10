package base.junit4.testing;

import org.junit.Assert;
import org.junit.Test;

public class BaseJIUnit4Testing {

    @Test
    public void test() {
        MyJUnit4Class instance = new MyJUnit4Class();
        Assert.assertEquals(1, instance.calculate(2));
    }
}
