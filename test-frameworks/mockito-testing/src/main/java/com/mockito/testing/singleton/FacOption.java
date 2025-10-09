package com.mockito.testing.singleton;

public class FacOption {

    private String typeSCO;
    private static FacOption instance;

    private FacOption() {
        this.typeSCO = "SCO";
    }

    // 该static方法将被mock之后再测试
    public static FacOption getInstance() {
        if (instance == null) {
            instance = new FacOption();
        }
        return instance;
    }

    public String getTypeSCO() {
        return typeSCO;
    }
}
