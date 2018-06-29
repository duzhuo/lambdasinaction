package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢?例如，给定[1, 2, 3, 4,
 * 5]，应该返回[1, 4, 9, 16, 25]。
 */
public class Exp {
    public static void main(String[] args) {
        List<Integer> words = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> b = words.stream()
                .map(a -> a*a)
                .collect(Collectors.toList());
        System.out.println(b);
    }
}
