package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;

public class DistinctExp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 4, 2);

        numbers.stream()
                .filter(d -> d % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
