package com.example.demo.service;

import com.example.demo.requesthandling.dto.ArrayOutputDTO;
import com.example.demo.service.helper.FlattenTheArrayServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrayFlattenServiceImpl implements ArrayFlattenService {

    @Autowired
    private FlattenTheArrayServiceHelper flattenTheArrayServiceHelper;

    @Override
    public ArrayOutputDTO flatten(List input) {
        List<Integer> output = flattenTheArrayServiceHelper.flattenTheArray(input);
        return new ArrayOutputDTO(output);
    }

}
