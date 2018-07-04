package lambdasinaction.chap5;

import java.util.stream.IntStream;

/**
 * 打印出1~100范围内的所有勾股数，如下
 * 3， 4， 5
 * 5， 12， 13
 * 6， 8， 10
 * ..........
 * ..........
 */
public class GouguNumberExp {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                ).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));


    }
}
