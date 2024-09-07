package org.example.meeting.rooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinimumMeetingRooms {

    public static void main(String[] args) {
        List<List<Integer>> meetings = List.of(
                List.of(7, 10),
                List.of(4, 19),
                List.of(19, 26),
                List.of(14, 16),
                List.of(13, 18),
                List.of(16, 21));
        /*List<List<Integer>> meetings =  List.of(
                List.of(0,30),
                List.of(5,10),
                List.of(15,20));*/
       /* List<List<Integer>> meetings =  List.of(
                List.of(1,18),
                List.of(18,23),
                List.of(15,29),
                List.of(4,15),
                List.of(2,11),
                List.of(5,13));*/
/*        List<List<Integer>> meetings = List.of(
                List.of(0, 14),
                List.of(6, 25),
                List.of(12, 19),
                List.of(13, 19),
                List.of(5, 9)
        );*/
        ArrayList<ArrayList<Integer>> meetingsArrayList = meetings.stream()
                .map(ArrayList::new).collect(Collectors.toCollection(ArrayList::new));
        MinimumMeetingRooms minimumMeetingRooms = new MinimumMeetingRooms();
        System.out.println(minimumMeetingRooms.solve(meetingsArrayList));
    }


    public int solve(ArrayList<ArrayList<Integer>> A) {
        PriorityQueue<Integer> minEndDates = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        A.sort(Comparator.comparingInt(value -> value.get(0)));
        for (ArrayList<Integer> meeting : A) {
            int startTime = meeting.get(0);
            int endTime = meeting.get(1);
            if (!minEndDates.isEmpty() && startTime >= minEndDates.peek()) {
                minEndDates.poll();
            }

            minEndDates.offer(endTime);


        }
        return minEndDates.size();
    }
}
