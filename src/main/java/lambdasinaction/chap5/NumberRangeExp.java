package lambdasinaction.chap5;

import java.util.stream.IntStream;

/**
 * 和数字打交道时，有一个常用的东西就是数值范围。比如，假设你想要生成1和100之间的所有数字。
 * Java 8引入了两个可以用于IntStream和LongStream的静态方法，帮助生成这种范围: range和rangeClosed。
 * 这两个方法都是第一个参数接受起始值，第二个参数接受结束值。但 range是不包含结束值的，而rangeClosed则包含结束值。
 */
public class NumberRangeExp {
    public static void main(String[] args) {
        // 生成从1到99的数值流，不含100
        System.out.println("生成从1到99的数值流，不含100");
        IntStream.range(1, 100).forEach(System.out::println);

        // 生成从1到100的数值流，含100
        System.out.println("生成从1到100的数值流，含100");
        IntStream.rangeClosed(1, 100).forEach(System.out::println);

        // 一个从1到 100的偶数 流
        System.out.println("一个从1到 100的偶数 流");
        IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).forEach(System.out::println);

    }
}
