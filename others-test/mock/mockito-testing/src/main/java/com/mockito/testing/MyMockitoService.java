package com.mockito.testing;

public class MyMockitoService {

    private MyMockitoInterface myMockitoInterface;

    public MyMockitoService(MyMockitoInterface myService) {
        this.myMockitoInterface = myService;
    }

    public String getServiceValue() {
        return "Value is: " + myMockitoInterface.test();
    }

    // 原始方法直接抛出checked exception
    public String getServiceValueWithException() throws Exception {
        return "Value is: " + myMockitoInterface.testWithException();
    }

    // 内部处理异常，然后返回默认的值
    public String getValueWithoutThrowException() {
        try {
            int returnInteger = myMockitoInterface.testWithException();
            return "My Integer is: " + returnInteger;
        } catch (Exception e) {
            System.out.println("-- exception thrown in MyProcess --");
            return "default-value";
        }
    }
}
