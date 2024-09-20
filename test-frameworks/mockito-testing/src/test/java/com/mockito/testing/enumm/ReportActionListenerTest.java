package com.mockito.testing.enumm;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ReportActionListenerTest {

    @Test
    public void testActionMock() {
        ReportActionListener listener = new ReportActionListener();
        try(MockedStatic<ReportAction> actionMockedStatic = Mockito.mockStatic(ReportAction.class)) {
            // TODO. Mock枚举类型本身的实例方法
            ReportAction unmanagedAction = Mockito.mock(ReportAction.class);
            Mockito.when(unmanagedAction.name()).thenReturn("This is unmanaged action");
            Mockito.when(unmanagedAction.ordinal()).thenReturn(2);

            ReportAction[] patchReportActions = {ReportAction.AUTO, ReportAction.MANUAL, unmanagedAction};

            // TODO. Mock枚举类型本身的static静态方法
            actionMockedStatic.when(ReportAction::values).thenReturn(patchReportActions);
            actionMockedStatic.when(() -> ReportAction.valueOf("unknown")).thenReturn(unmanagedAction);

            listener.testActions("unknown");
        }
    }
}