package com.example.demo.requesthandling.dto;

import java.io.Serializable;
import java.util.List;

public class ArrayOutputDTO implements Serializable {

    private List<Integer> output;

    public ArrayOutputDTO(List<Integer> output) {
        this.output = output;
    }

    public List<Integer> getOutput() {
        return output;
    }

    public void setOutput(List<Integer> output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "output : " + output.toString();
    }
}
