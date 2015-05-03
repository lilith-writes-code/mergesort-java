package com.venison;

public class Merger {

    public int[] sort(int[] unsorted){
        if(unsorted == null) {
            return null;
        }

        int upperBounds  = unsorted.length-1;
        int lowerBounds = 0;

        return internalSort(unsorted, lowerBounds, upperBounds);

    }

    private int[] internalSort(int[] unsorted, int lowerBounds, int upperBounds) {
        if(upperBounds == 0){
            return unsorted;
        }

        //more than 1 element difference.  need to split up more.
        int mid = (int)Math.floor(upperBounds/2);
        if(mid < lowerBounds){
            mid = lowerBounds;
        }
        if(upperBounds - lowerBounds > 1){
            int[] left = internalSort(unsorted, lowerBounds, mid);
            int[] right = internalSort(unsorted, mid + 1, upperBounds);
            return merge(left, right);
        }else if(upperBounds - lowerBounds == 1) {
            //exactly 2 elements
            if (unsorted[lowerBounds] > unsorted[upperBounds]) {
                return new int[]{unsorted[upperBounds], unsorted[lowerBounds]};
            } else {
                return new int[]{unsorted[lowerBounds], unsorted[upperBounds]};
            }
        }else if (lowerBounds == upperBounds){
            return new int[]{unsorted[lowerBounds]};
        }
        return null;
    }

    private int[] merge(int[] left, int[] right){
        int[] merged = new int[left.length+right.length];
        int leftIndex = 0;
        int rightIndex = 0;

        for(int totalIndex=0;totalIndex<merged.length;totalIndex++){
            if(left[leftIndex] > right[rightIndex]){
                merged[totalIndex] = right[rightIndex];
                rightIndex++;
                if(rightIndex >= right.length){
                    //exhausted right array
                    while(leftIndex < left.length){
                        totalIndex++;
                        merged[totalIndex] = left[leftIndex];
                        leftIndex++;
                    }
                    return merged;
                }
            }else{
                merged[totalIndex] = left[leftIndex];
                leftIndex++;
                if(leftIndex >= left.length){
                    //exhausted left array
                    while(rightIndex < right.length){
                        totalIndex++;
                        merged[totalIndex] = right[rightIndex];
                        rightIndex++;
                    }
                    return merged;
                }
            }
        }
        return merged;
    }




}
