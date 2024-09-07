package org.example.bulbs;

import java.util.ArrayList;
import java.util.List;

public class MinimumSwitch {


    public static void main(String[] args) {
        MinimumSwitch minimumSwitch = new MinimumSwitch();
        System.out.println(minimumSwitch.bulbs(new ArrayList<>(List.of(0,1,0,1))));
    }

    public int bulbs(ArrayList<Integer> A) {
        int count = 0;
        boolean flipState = false;

        for (int bulb : A) {
            if (flipState) {
                bulb = 1 - bulb; // Flip the bulb state if we've flipped an odd number of times
            }

            if (bulb == 0) {
                count++;
                flipState = !flipState; // Toggle the flip state
            }
        }

        return count;
    }
}
