package com.example.api;

public interface ExternalApi {

    String getData();
    String getDataById(String id);
    boolean isAvailable();
}
