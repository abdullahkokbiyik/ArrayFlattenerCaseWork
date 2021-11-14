package com.example.demo.requesthandling.dto;

import java.util.List;

public class ArrayInputDTO {

    private List input;

    public ArrayInputDTO(List input) {
        this.input = input;
    }

    public List getInput() {
        return input;
    }

    public void setInput(List input) {
        this.input = input;
    }
}
