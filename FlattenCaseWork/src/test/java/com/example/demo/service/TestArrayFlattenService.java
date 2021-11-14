package com.example.demo.service;

import com.example.demo.requesthandling.dto.ArrayOutputDTO;
import com.example.demo.general.GetTestValues;
import com.example.demo.service.helper.FlattenTheArrayServiceHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class TestArrayFlattenService {

    @InjectMocks
    private ArrayFlattenService arrayFlattenService = new ArrayFlattenServiceImpl();

    @Mock
    private FlattenTheArrayServiceHelper flattenTheArrayServiceHelper;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFlattenNestedList() {
        List input = GetTestValues.getInputList();
        List<Integer> output = GetTestValues.getOutputList();

        Mockito.when(flattenTheArrayServiceHelper.flattenTheArray(input)).thenReturn(output);

        ArrayOutputDTO arrayOutputDTO = arrayFlattenService.flatten(input);

        Assert.assertNotNull(arrayOutputDTO);
        Assert.assertEquals(output.size(), 4);
        Assert.assertEquals(output.get(0), Integer.valueOf(1));
        Assert.assertEquals(output.get(3), Integer.valueOf(5));

        Mockito.verify(flattenTheArrayServiceHelper).flattenTheArray(input);
    }
}
