package com.example.demo.service.helper;

import com.example.demo.general.GetTestValues;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class TestFlattenTheArrayServiceHelper {

    @InjectMocks
    private FlattenTheArrayServiceHelper flattenTheArrayServiceHelper = new FlattenTheArrayServiceHelperImpl();

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFlattenTheList() {
        List input = GetTestValues.getInputList();

        List<Integer> output = flattenTheArrayServiceHelper.flattenTheArray(input);

        Assert.assertEquals(output.size(), 4);
        Assert.assertEquals(output.get(0), Integer.valueOf(1));
        Assert.assertEquals(output.get(3), Integer.valueOf(5));
    }
}
