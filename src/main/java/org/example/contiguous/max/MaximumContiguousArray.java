package org.example.contiguous.max;

import java.util.List;

public class MaximumContiguousArray {


    public static void main(String[] args) {
        MaximumContiguousArray maximumContiguousArray = new MaximumContiguousArray();
        List<Integer> input = List.of(1, 2, 3, 4, -10);
        int maxSubArray = maximumContiguousArray.maxSubArray(input);
        System.out.println(maxSubArray);
    }


    public int maxSubArray(final List<Integer> A) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;

        for (Integer integer : A) {
            maxEndingHere += integer;

            // Use Math.max to find the maximum
            // of maxSoFar and maxEndingHere
            maxSoFar = Math.max(maxSoFar, maxEndingHere);

            // Use Math.max to reset maxEndingHere
            // to 0 if it becomes negative
            maxEndingHere = Math.max(maxEndingHere, 0);
        }
        return maxSoFar;
    }

}
