package com.mockito.testing.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class FacOptionTest {

    // TODO. 适用mockStatic来Mock单列类型的.getInstance()方法
    @Test
    public void mockFacOptionTest(){
        MockedStatic<FacOption> facOptionMockedStatic = Mockito.mockStatic(FacOption.class);

        FacOption mockInstance = Mockito.mock(FacOption.class);
        Mockito.when(FacOption.getInstance()).thenReturn(mockInstance);
        Mockito.when(mockInstance.getTypeSCO()).thenReturn("Test Type");

        FacOption instance = FacOption.getInstance();
        Assertions.assertEquals("Test Type", instance.getTypeSCO());

        facOptionMockedStatic.close();
    }
}
