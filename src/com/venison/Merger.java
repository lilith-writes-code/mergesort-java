package com.venison;

public class Merger {
    public int[] sort(int[] unsorted){
        if(unsorted == null) {
            return null;
        }

        int upperBounds  = unsorted.length-1;
        int lowerBounds = 0;

        if(upperBounds == 0){
            return unsorted;
        }

        if(unsorted[lowerBounds] > unsorted[upperBounds]){
            int tmp = unsorted[lowerBounds];
            unsorted[lowerBounds] = unsorted[upperBounds];
            unsorted[upperBounds] = tmp;
        }
        return unsorted;
    }
}
