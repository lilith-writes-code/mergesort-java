package com.venison;

import org.junit.Test;

import java.io.Console;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
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

    @Test
    public void sort_unsortedThreeItemReturnsSortedSet() throws Exception {
        Merger testObj = new Merger();

        int[] actual = testObj.sort(new int[]{6, 5, 3});

        assertEquals(3, actual[0]);
        assertEquals(5, actual[1]);
        assertEquals(6, actual[2]);
    }

    @Test
    public void sort_GivenLastElementIsGreatestValue_ItemReturnsSortedSet() throws Exception {
        Merger testObj = new Merger();

        int[] actual = testObj.sort(new int[]{6, 5, 7});

        assertEquals(5, actual[0]);
        assertEquals(6, actual[1]);
        assertEquals(7, actual[2]);
    }

    @Test
    public void sort_unsortedFourItemReturnsSortedSet() throws Exception {
        Merger testObj = new Merger();

        int[] actual = testObj.sort(new int[]{6, 5, 3, 9});

        assertEquals(3, actual[0]);
        assertEquals(5, actual[1]);
        assertEquals(6, actual[2]);
        assertEquals(9, actual[3]);
    }

    @Test
    public void sort_unsortedManyItemReturnsSortedSet() throws Exception {
        Merger testObj = new Merger();
        int[] unsorted = new int[5200];
        Random rando = new Random();
        for(int i=0; i<unsorted.length; i++){
            unsorted[i] = rando.nextInt();
        }
        int[] copy = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(copy);
        int[] actual = testObj.sort(unsorted);

//        printArray("Copy", copy);
//        printArray("Actual", actual);
        assertArrayEquals(copy, actual);

    }

    @Test
    public void normalSortDoesntBlowStack() throws Exception {
        int[] unsorted = new int[100000000];
        Random rando = new Random();
        for(int i=0; i<unsorted.length; i++){
            unsorted[i] = rando.nextInt();
        }
        Arrays.sort(unsorted);
    }

    private void printArray(String name, int[] array) {
        System.out.println(name);
        for (int anArray : array) {
            System.out.println(anArray);
        }
        System.out.println("\n");
    }


}