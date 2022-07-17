package mock.powermock;

public class MyServiceUtil {

    public String getServiceUrl(String baseUrl) {
        return baseUrl + "/v1/service";
    }

    public static String getStaticServiceUrl(String baseUrl) {
        return baseUrl + "/static/v1/service";
    }
}
