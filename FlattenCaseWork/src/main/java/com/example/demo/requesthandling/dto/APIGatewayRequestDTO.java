package com.example.demo.requesthandling.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIGatewayRequestDTO implements Serializable {

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArrayInputDTO createInputDTO() throws IllegalArgumentException {
        String arrayInsideInput = body.split(":")[1].replace('}', '\0');
        ObjectMapper jsonMapper = new ObjectMapper();
        try{
            List input =  jsonMapper.readValue(arrayInsideInput, List.class);
            return new ArrayInputDTO(input);
        } catch (JsonProcessingException j) {
            throw new IllegalArgumentException("Invalid request received");
        }
    }
}
