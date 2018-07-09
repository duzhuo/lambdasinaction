package lambdasinaction.chap5;

import java.util.stream.Stream;

public class FunctionStreamExp {

    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 2)
                .limit(100)
                .forEach(System.out::println);

        // 斐波纳契元组序列 (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21) ...
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0]+n[1]})
           .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
