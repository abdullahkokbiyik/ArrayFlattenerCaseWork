package com.example.demo.service.helper;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FlattenTheArrayServiceHelperImpl implements FlattenTheArrayServiceHelper {

    @Override
    public List<Integer> flattenTheArray(List input) {
        List<Integer> output = new ArrayList<>();
        for (Object element : input) {
            if(element instanceof List) {
                List<Integer> flattened = flattenTheArray((List)element);
                output.addAll(flattened);
            } else {
                output.add((Integer)element);
            }
        }
        output.sort(Comparator.naturalOrder());
        return output;
    }

}
