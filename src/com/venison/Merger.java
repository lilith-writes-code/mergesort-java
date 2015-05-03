package com.venison;

public class Merger {
    public int[] sort(int[] unsorted){
        if(unsorted == null) {
            return null;
        }

        if(unsorted.length == 1){
            return unsorted;
        }

        if(unsorted[0] > unsorted[1]){
            int tmp = unsorted[0];
            unsorted[0] = unsorted[1];
            unsorted[1] = tmp;
        }
        return unsorted;
    }
}
