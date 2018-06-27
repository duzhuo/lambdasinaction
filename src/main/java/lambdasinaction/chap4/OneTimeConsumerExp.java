package lambdasinaction.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OneTimeConsumerExp {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }
}
