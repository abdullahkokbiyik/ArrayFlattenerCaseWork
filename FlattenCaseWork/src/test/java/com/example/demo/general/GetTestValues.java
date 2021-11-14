package com.example.demo.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class GetTestValues {
    public static List getInputList() {
        List input = new ArrayList();
        input.add(5);
        input.add(Collections.singletonList(1));
        input.add(Collections.singletonList(Collections.singletonList(3)));
        input.add(4);
        return input;
    }

    public static List<Integer> getOutputList() {
        List<Integer> output = new ArrayList<>();
        output.add(4);
        output.add(3);
        output.add(1);
        output.add(5);
        output.sort(Comparator.naturalOrder());
        return output;
    }
}
