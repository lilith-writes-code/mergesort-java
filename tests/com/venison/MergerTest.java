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

    @Test
    public void sort_SingleItemReturnsSingleItem() throws Exception {
        Merger testObj = new Merger();

        int[] actual = testObj.sort(new int[]{5});

        assertEquals(5, actual[0]);
    }

    @Test
    public void sort_AlreadyTwoItemReturnsSortedSet() throws Exception {
        Merger testObj = new Merger();

        int[] actual = testObj.sort(new int[]{5, 6});

        assertEquals(5, actual[0]);
        assertEquals(6, actual[1]);
    }

    @Test
    public void sort_unsortedTwoItemReturnsSortedSet() throws Exception {
        Merger testObj = new Merger();

        int[] actual = testObj.sort(new int[]{6, 5});

        assertEquals(5, actual[0]);
        assertEquals(6, actual[1]);
    }




}