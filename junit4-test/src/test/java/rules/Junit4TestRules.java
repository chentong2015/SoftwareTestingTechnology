package rules;

import com.junit4.testing.MyServiceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

// Junit4提供的预定义规则，作为类库的一部分
// Rules: a number of useful, predefined rules as part of the library.
public class Junit4TestRules {

    // 1. 测试测试获取方法的名称
    @Rule
    public TestName name = new TestName();

    @Test
    public void testMethodName() {
        assertEquals("test Method Name", name.getMethodName());
    }

    // 2. 测试异常输出的Rule
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throw_exception_with_expected() throws MyServiceException {
        exception.expect(MyServiceException.class);

        // mock the method called to throw exception
        throw new MyServiceException();
    }

}
