package pact;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.target.Target;
import au.com.dius.pact.provider.junitsupport.target.TestTarget;
import org.junit.runner.RunWith;

import java.util.Map;

// TODO. Pact Source 设置指定的PACT协议的来源
// 1. Download pacts from a pact-broker (File server)
// 2. The pact broker will be queried for all pacts with the same name as the provider annotation.
@RunWith(PactRunner.class)
@Provider("test_pact_provider")
@PactBroker(host = "localhost", port = "8080")
public class PactBrokerSource {

    @TestTarget
    public final Target target = new HttpTarget(5050);

    // Method will be run before testing interactions that require "default" or "no-data" state
    @State({"default", "no-data"})
    public void toDefaultState() {
        // Prepare service before interaction that require "default" state
        System.out.println("Now service in default state");
    }

    @State("with-data") // Method will be run before testing interactions that require "with-data" state
    public void toStateWithData(Map data) {
        // Prepare service before interaction that require "with-data" state.
        // The provider state data will be passed in the data parameter
        System.out.println("Now service in state using data " + data);
    }
}
