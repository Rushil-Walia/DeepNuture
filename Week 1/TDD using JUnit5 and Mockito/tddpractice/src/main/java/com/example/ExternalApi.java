package com.example;
public interface ExternalApi {
    String getData();
    String getDataById(int id);
    void performAction();
    void startProcess();
    void endProcess();
}