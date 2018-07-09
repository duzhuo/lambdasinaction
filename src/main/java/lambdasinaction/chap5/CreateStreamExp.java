package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStreamExp {
    public static void main(String[] args) {
        // 创建字符流
        Stream<String> s1 = Stream.of("Java", "a", "b", "c");
        s1.forEach(System.out::println);

        // 创建空流
        Stream<String> s2 = Stream.empty();
        System.out.println("s2 count is : " + s2.count());

        // 由数组创建流
        int[] numbers = {2, 3, 5, 6, 7, 8};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("sum is :" + sum);


    }
}
