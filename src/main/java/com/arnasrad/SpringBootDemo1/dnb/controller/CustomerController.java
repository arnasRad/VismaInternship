package com.arnasrad.SpringBootDemo1.dnb.controller;

import com.amazonaws.*;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpMethodName;
import com.arnasrad.SpringBootDemo1.dnb.handlers.ResponseHandlerJSONArray;
import com.arnasrad.SpringBootDemo1.dnb.handlers.ResponseHandlerJSONObject;
import com.arnasrad.SpringBootDemo1.dnb.model.Customer;
import com.arnasrad.SpringBootDemo1.dnb.model.CustomerInfo;
import com.arnasrad.SpringBootDemo1.dnb.utils.Utils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping
public class CustomerController {

    @Value("${dnb.awsservice}")
    private String awsService;

    @Value("${dnb.openbanking.endpoint}")
    private String openBankingEndpoint;

    @Value("${dnb.api.keyHeader}")
    private String apiKeyHeader;

    @Value("${dnb.jwt.tokenHeader}")
    private String jwtTokenHeader;

    @Value("${dnb.apikey}")
    private String apiKey;


    private Request createRequest(final HttpMethodName httpMethodName, final String path) {
        final Request request = new DefaultRequest(awsService);
        request.setHttpMethod(httpMethodName);
        request.setEndpoint(URI.create(openBankingEndpoint));
        request.setResourcePath(path);
        request.addHeader("Accept", "application/json");
        request.addHeader("Content-type", "application/json");
        request.addHeader(apiKeyHeader, apiKey);
        return request;
    }

    private AmazonHttpClient.RequestExecutionBuilder buildRequest(final Request request) {
        try {
            return new AmazonHttpClient(new ClientConfiguration())
                    .requestExecutionBuilder()
                    .executionContext(new ExecutionContext(true))
                    .request(request);
        } catch (AmazonServiceException exception) {
            System.out.println("Unexpected status code in response: " + exception.getStatusCode());
            System.out.println("Content: " + exception.getRawResponseContent());
            throw new RuntimeException("Failed request. Aborting.");
        }
    }

    @GetMapping("/dnb/api-token")
    public String getApiToken() {
        final Request apiTokenRequest = createRequest(HttpMethodName.POST, "/tokens/v0");
        String content = "{\"ssn\": \"29105573083\"}";
        apiTokenRequest.setContent(new ByteArrayInputStream(content.getBytes(Charset.forName("UTF-8"))));

        final JSONObject apiTokenResponse = buildRequest(apiTokenRequest).execute(new ResponseHandlerJSONObject(false))
                .getAwsResponse();
        return (String) (apiTokenResponse.get("jwtToken"));
    }

    @GetMapping("/dnb/test-customers")
    public List<Customer> getTestCustomers() throws IOException {
        final Request customerRequest = createRequest(HttpMethodName.GET, "/test-customers/v0");

        Response<JSONArray> response = buildRequest(customerRequest).execute(new ResponseHandlerJSONArray(false));

        return Utils.getCustomerListFromJsonString(response.getAwsResponse().toString());
    }

    @GetMapping("/dnb/customer-info")
    public CustomerInfo getCustomerInfo(final String jwtToken) throws IOException {
        final Request customerRequest = createRequest(HttpMethodName.GET, "/customers/v0/current");
        customerRequest.addHeader(jwtTokenHeader, jwtToken);

        Response<JSONObject> response = buildRequest(customerRequest).execute(new ResponseHandlerJSONObject(false));

        return Utils.getCustomerInfoFromJsonString(response.getAwsResponse().toString());
    }
}
