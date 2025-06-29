package com.example.service;

import com.example.api.ExternalApi;

public class MyService {
    
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
    
    public String fetchData() {
        return externalApi.getData();
    }
    
    public String fetchDataById(String id) {
        if (!externalApi.isAvailable()) {
            return "Service unavailable";
        }
        return externalApi.getDataById(id);
    }
    
    public String processData() {
        String rawData = externalApi.getData();
        if (rawData == null || rawData.isEmpty()) {
            return "No data available";
        }
        return "Processed: " + rawData.toUpperCase();
    }
    
    public String getServiceStatus() {
        return externalApi.isAvailable() ? "Service is healthy" : "Service is down";
    }
}
