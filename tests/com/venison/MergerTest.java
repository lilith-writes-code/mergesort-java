package com.venison;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergerTest {

    @Test
    public void sort_EmptyReturnsEmpty() throws Exception {
        Merger testObj = new Merger();

        int[] actual = testObj.sort(null);

        assertEquals(null, actual);
    }


}