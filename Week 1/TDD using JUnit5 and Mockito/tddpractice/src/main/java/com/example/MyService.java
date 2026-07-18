package com.example;
public class MyService {
    
    private final ExternalApi externalApi;

    // The dependency is injected here
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        // The service relies on the external API to get its data
        return externalApi.getData();
    }
    // ADDED: New method to satisfy the test and call the API
    public String fetchDataById(int id) {
        return externalApi.getDataById(id);
    }
}
