package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个数字列表，如何返回所有的数对呢?
 * 例如，给定列表[1, 2, 3]和列表[3, 4]，应 该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。
 * 为简单起见，你可以用有两个元素的数组来代表数对。
 */
public class Exp2 {
    public static void main(String[] args) {
        List<Integer> a1 = Arrays.asList(1, 2, 3);
        List<Integer> a2 = Arrays.asList(4, 5);

        List<int[]> a3 = a1.stream()
                .flatMap(a -> a2.stream().map(b -> new int[]{a, b}))
                .collect(Collectors.toList());
        System.out.println(a3);
    }
}
