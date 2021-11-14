package com.example.demo.requesthandling.dto;

import org.junit.Assert;
import org.junit.Test;

public class TestAPIGatewayRequestDTO {

    @Test
    public void testCreateInputDTO() {
        APIGatewayRequestDTO apiGatewayRequestDTO = new APIGatewayRequestDTO();
        apiGatewayRequestDTO.setBody("{\"input\" : [1, [2, [3]], [[6]], 5, [7]]}");

        ArrayInputDTO arrayInputDTO = apiGatewayRequestDTO.createInputDTO();

        Assert.assertNotNull(arrayInputDTO);
        Assert.assertNotNull(arrayInputDTO.getInput());
        Assert.assertEquals(5, arrayInputDTO.getInput().size());
    }

    @Test
    public void testCreateInputDTOInvalidRequest() {
        APIGatewayRequestDTO apiGatewayRequestDTO = new APIGatewayRequestDTO();
        apiGatewayRequestDTO.setBody("{\"input\" : }");

        boolean exceptionThrown = false;

        try {
            ArrayInputDTO arrayInputDTO = apiGatewayRequestDTO.createInputDTO();
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }
}
