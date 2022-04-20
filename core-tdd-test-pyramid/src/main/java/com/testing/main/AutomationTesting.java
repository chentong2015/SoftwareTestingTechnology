package com.testing.main;

// Why do automate test ?
// 1. Find problems before it's too big
// 2. Performance, reliable
// 3. Usability
// 4. Easy to test and monitor, no fear changes

// Testing Hierarchy
// 1. System: End to end, check the application meets its requirements, run the app, slow
// 2. Aggregate: Slower, less brittle, whole component, set of classes
// 3. Unit: Single unit functionality, one method, class or small module, fast to run
public class AutomationTesting {

    // 1. Types of tests
    //   Unit tests:
    //      low level, highly focused, quick 只测试单一的功能, 没有使用额外的资源
    //   Integration tests:
    //      higher level, things work together, may use other dependencies
    //      integration tests focus on integrating different layers of the application
    //      keep the integration tests separated from the unit tests and should not run along with the unit tests
    //   Subcutaneous tests
    //      involve a large portion of system
    //      just below surface of UI, can test all the UI components together
    //   Functional user interface tests
    //      test UI components
    //      UI element as end user
    //      Full stack testing
    //      Slow to execute

    // 2. Test breadth versus depth: How the above types fit in the test breadth or depth
    //   Unit test
    //           Integration
    //                    Subcutaneous
    // 深                            UI Test
    // 度   广度

    // 3. The logical phases of an automated test 测试的三个阶段
    //    Arrange
    //    Act
    //    Assert

    // 4. Mock testing: How to use mock objects to isolate the code to be tested
    //    在单元测试的时候，使用Mock Object去模拟和隔离依赖性的问题
    //    Mocks Mock只用于测试，替代依赖
    //    Stubs
    //    Test Doubles
    //    Fakes

    // 5. Data-driven: 数据驱动测试：使用不同的数据执行同一个单一的测试多次
    //       @a placeholder -> row
    //    Business-readable tests
    //       document application, no technical 在开发团队和业务团队之间更好的沟通
    //       Scenario: number addition 可以阅读的，用于描述软件的行为
    //    The testing pyramid

    // 6. Exploratory testing
    //    It involves the simultaneous design of the test and execution
    //    https://www.atlassian.com/continuous-delivery/software-testing/exploratory-testing
}
