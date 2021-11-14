package com.example.demo.requesthandling.handler;

import com.example.demo.requesthandling.config.SpringFrameworkConfig;
import com.example.demo.requesthandling.dto.APIGatewayRequestDTO;
import com.example.demo.requesthandling.dto.APIGatewayResponseDTO;
import com.example.demo.requesthandling.dto.ArrayOutputDTO;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.demo.service.ArrayFlattenService;

import java.util.Collections;

@SuppressWarnings("unused")
public class StreamHandler extends AbstractStreamHandler<SpringFrameworkConfig> implements RequestHandler<APIGatewayRequestDTO, APIGatewayResponseDTO> {
    public StreamHandler() {
        this.exampleEvent = "{\"input\" : [1, [2, [3]], [[6]], 5, [7]]}";
    }

    @Override
    public APIGatewayResponseDTO handleRequest(APIGatewayRequestDTO request, Context context) throws RuntimeException {
        System.out.println("Request received -> " + request.getBody());
        ArrayFlattenService arrayFlattenService = getApplicationContext().getBean(ArrayFlattenService.class);
        try {
            ArrayOutputDTO arrayOutputDTO = arrayFlattenService.flatten(request.createInputDTO().getInput());
            return createResponse(arrayOutputDTO);
        } catch (IllegalArgumentException e) {
            return new APIGatewayResponseDTO(e.getMessage(), 400, Collections.singletonMap("Content-Type", "application/json"));
        }
    }

    private APIGatewayResponseDTO createResponse(ArrayOutputDTO arrayOutputDTO) {
        return new APIGatewayResponseDTO(
                arrayOutputDTO.toString(),
                200,
                Collections.singletonMap("Content-Type", "application/json")
        );
    }
}
