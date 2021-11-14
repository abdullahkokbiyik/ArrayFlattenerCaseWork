package com.example.demo.service;

import com.example.demo.requesthandling.dto.ArrayOutputDTO;

import java.util.List;

public interface ArrayFlattenService {
    ArrayOutputDTO flatten(List input);
}
