package org.example.bounded.slice;

import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoundedSlice {

    public static void main(String[] args) {
        BoundedSlice boundedSlice = new BoundedSlice();
        int[] A = new int[]{3, 5, 7, 6, 3};
        int K = 2;
        int size = boundedSlice.solution(K, A);
        System.out.println(size);
    }

    public int solution(int K, int[] A) {
        // Implement your solution here
        Set<Point> points = new HashSet<Point>();
        List<Integer> entries = IntStream.of(A).boxed().collect(Collectors.toList());
        for (int p = 0; p < A.length; p++) {
            boolean isLesserThanK = true;
            for (int q = p; q < A.length && isLesserThanK; q++) {
                List<Integer> tempList = entries.subList(p, q + 1);
                OptionalInt max = tempList.stream().mapToInt(Integer::intValue).max();
                OptionalInt min = tempList.stream().mapToInt(Integer::intValue).min();
                if (max.isPresent()) {
                    if (max.getAsInt() - min.getAsInt() <= K) {
                        points.add(new Point(p, q));
                    }
                    else
                        isLesserThanK = false;
                }

            }
        }
        return points.size();
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

}
