package com.example.demo.requesthandling.dto;

import java.util.Map;

public class APIGatewayResponseDTO {

    private String body;
    private int statusCode;
    private Map<String, String> headers;

    public APIGatewayResponseDTO(String body, int statusCode, Map<String, String> headers) {//, boolean isBase64Encoded) {
        this.body = body;
        this.statusCode = statusCode;
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
