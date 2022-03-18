package com.testing.basic;

// Good Practices
// 1. Well named: executable documentation, maintenance, readability
//    测试的名称需要足够的清楚，表明要测试的内容
//    使用domain terminology + natural language + be descriptive
// 2. Behavior not implementation
//    测试的是行为，而不是类型的实现方式: 只考虑public API，不测试private的内容，不做更改
// 3. DRY: not repeat code
//    提供共同的的代码
//    定义测试的数据成constant
// 4. Diagnostics: check output, debug and fix it
//    AssertTure(order.size() == 1)  => 如果出错，之会显示AssertionError
//    AssertEquals(1, order.size()); => 断言能够显示具体的信息，方便测试
//    AssertEquals("Wrong quantity of coffee", 1, order.size()); => 自定义提示信息
public class BaseGoodTest {

    // Hamcrest: A compositional matcher library
    // 1. 避免测试中的重复
    // 2. 提高测试中的Diagnostics, 从错误中找到原因
    // Matcher: A simple or general blob of logic used in Assertions
    // Matchers can combine multiple matchers
}
