package com.testing.console;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

// 使用SystemOutRule测试控制台的输出
public class SystemConsoleTesting {
    
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void givenSystemOutRule_whenInvokePrintln_thenLogSuccess() {
        System.out.println("Hello");
        Assert.assertEquals("Hello", systemOutRule.getLog().trim());
    }
}
