package com.mockito.testing.enumm;

public class ReportActionListener {

    public void testActions(String actionName) {
        ReportAction action = ReportAction.valueOf(actionName);
        switch (action) {
            case MANUAL:
                System.out.println("manual");
            case AUTO:
                System.out.println("Auto");
            default:
                // throw new RuntimeException("Error enum type");
                System.out.println("unknown report action !");
                System.out.println(action.name());
                System.out.println(action.ordinal());
        }
    }
}
