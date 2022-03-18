package com.testing.mockito;

public class MyProcessor {

    private MyService myService;

    public MyProcessor(MyService myService) {
        this.myService = myService;
    }

    public String process() {
        int returnInteger = myService.doSomething();
        return "My Integer is: " + returnInteger;
    }

    public String process2() throws Exception {
        int returnInteger = myService.doSomething2();
        return "My Integer is: " + returnInteger;
    }

    // 内部处理异常，然后返回默认的值
    public String process3() {
        try {
            int returnInteger = myService.doSomething2();
            return "My Integer is: " + returnInteger;
        } catch (Exception e) {
            System.out.println("-- exception thrown in MyProcess --");
            return "default-value";
        }
    }
}
