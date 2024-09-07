package org.example.majorityElt;

import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement mjr = new MajorityElement();
        System.out.println(mjr.majorityElement(List.of(2,1,2)));
    }


    public int majorityElement(final List<Integer> A) {
        double floor = (double) A.size() / 2;
        OptionalInt majorityElt = IntStream.range(0, A.size()).filter(i -> {
            int occ = A.stream().reduce(0, (acc,val) -> {
                if (Objects.equals(val, A.get(i))){
                    acc++;
                }
                return acc;
            });
            return occ > floor;
        }).map(A::get).findFirst();
        return majorityElt.orElse(0);
    }
}
