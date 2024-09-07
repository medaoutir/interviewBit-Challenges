package org.example.stackFromArray;

import java.util.LinkedList;

public class StackFromArray {
    public int solution(int[] A) {
        // Implement your solution here
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int i = 0;
        int cnt = 0;
        while (i < A.length && cnt < A.length){
            if(i==0) {
                stack.addFirst(A[i]);
                if(A[i] == -1){
                    break;
                }
            } else if (A[i]!= -1) {
                stack.add(cnt, A[i]);
            } else {
                stack.addLast(A[i]);
                break;
            }
            i = A[i];
            cnt++;
        }
        return stack.size();
    }
}
