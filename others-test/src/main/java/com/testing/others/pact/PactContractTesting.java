package com.testing.others.pact;

// PACT https://docs.pact.io/
// 一种Non HTTP协议的测试技术
//
// Contract Test: no http contract for file server
// Provider + Consumer
// Define the contract properties
//
// Consumer(local):
//   使用构造器注入，Mock模拟File Server
//   生成Contract Json文件的信息，然后提交给file Server(mock file server)
//   在文件服务器检查提交的Consumer和Provider, Version的确定
//
// Provider:
//   find the contract from the file server
//   find the version : server端比较两个版本
//   check the properties
//   在provider端使用自身的方式，生成结果，然后和Contract中期待的结果进行比较
//   验证Consumer和Provider在不同的版本下能够协同工作
//   对Provider的版本进行生成，然后发布
public class PactContractTesting {

}
