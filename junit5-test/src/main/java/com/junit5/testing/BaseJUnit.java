package com.junit5.testing;

// JUnit: testing framework
// Use software to test software
// Common solutions to common problems
public class BaseJUnit {

    // Run test from command:
    // > mvn clean test

    // Require all the test pass before building the jar file
    // > mvn package 构建项目的jar文件，需要所有的测试通过

    // The common Structure of Tests
    // 1. Given: precondition of test ?
    // 2. When: what is being tested ? The behavior
    // 3. Then: assert, verification

    // Assert断言
    // 一种常用的调试方式, 断言用于保证程序最基本、关键的正确性
    // TODO. 启动JVM时使用-enableassertions或者-ea标记, 否则断言不会起作用

    // Failure: 和程序代码的异常有关
    // An assertion failed
    // Suggests the code is broken

    // Error: 断言的错误，没有达到预期的结果
    // At any point in the test
    // An exception was thrown
    // Suggests the test is broken

    // JUnit Reading References 单元测试的补充文档
    // https://junit.org/junit5/docs/current/user-guide/#writing-tests
}
