package pact;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class PactConsumerTest {

    @Rule
    public PactProviderRule mockProvider =
            new PactProviderRule("test_provider", "localhost", 8080, this);

    // 声明的PACT协议：关于请求的Contract约定，发送的路径以及返回的结果
    @Pact(provider = "test_provider", consumer = "test_consumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("test state")
                .uponReceiving("ExampleJavaConsumerPactRuleTest test interaction")
                .path("/")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("{\"response_test\": true}")  // 可以匹配结果成HashMap的结构
                .toPact();
    }

    @Pact(consumer = "test_consumer") // will default to the provider name from mockProvider
    public RequestResponsePact createFragment(PactDslWithProvider builder) {
        return builder
                .given("test state")
                .uponReceiving("ExampleJavaConsumerPactRuleTest test interaction")
                .path("/")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("{\"response_test\": true}")
                .toPact();
    }

    // TODO. 向MockProvider发送请求，测试获得协议中约定的返回数据
    // 自定义使用Http Client端发送请求
    @Test
    @PactVerification("test_provider")
    public void runTest() throws IOException {
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder("http://localhost:8080").setPath("/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        Content response = Request.Get(uriBuilder.toString()).execute().returnContent();
        Assert.assertEquals("{\"response_test\": true}", response.toString());
    }
}
