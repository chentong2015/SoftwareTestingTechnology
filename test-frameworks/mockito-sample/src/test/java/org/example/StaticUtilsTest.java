package org.example;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// TODO. add -Xshare:off for JVM Warning
public class StaticUtilsTest {

    @Test
    public void mockStaticUtils() {
        assertEquals("test", StaticUtils.name());

        // mock static 方法会导致任何位置的调用都是同样的行为 !!
        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            utilities.when(StaticUtils::name).thenReturn("chen");
            assertEquals("chen", StaticUtils.name());
        }

        // 在Mock Static Scope之外将回复成原来的类型
        assertEquals("test", StaticUtils.name());
    }
}
