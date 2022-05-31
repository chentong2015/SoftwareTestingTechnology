// The common Structure of Tests 测试的基本三个步骤
// 1. Given: precondition of test ?
// 2. When: what is being tested ? The behavior
// 3. Then: assert, verification
public class BasicTest {

    // 每个测试只能测试一个行为
    // Note: the name of the method is the behaviors

    // TODO: 什么是好的测试Unit Test
    // 1. 单元测试一定要相互独立, 没有任何依赖
    // 2. 如果涉及到配置文件或者源文件的读取，需要分离开每个单独的文件
    // 3. 如果Unit Test需要测试Server的启动和关闭，则每一个测试都需要单独的开闭
    // 4. 注意可以提取公共的重复代码
}
