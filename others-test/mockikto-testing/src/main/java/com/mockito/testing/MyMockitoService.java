package com.mockito.testing;

public class MyMockitoService {

    private MyMockitoInterface myService;

    public MyMockitoService(MyMockitoInterface myService) {
        this.myService = myService;
    }

    public String getServiceValue() {
        return "Value is: " + myService.doSomething();
    }

    public String getServiceValueWithException() throws Exception {
        return "Value is: " + myService.doSomething2();
    }

    // 内部处理异常，然后返回默认的值
    public String getValueWithoutThrowException() {
        try {
            int returnInteger = myService.doSomething2();
            return "My Integer is: " + returnInteger;
        } catch (Exception e) {
            System.out.println("-- exception thrown in MyProcess --");
            return "default-value";
        }
    }
}
