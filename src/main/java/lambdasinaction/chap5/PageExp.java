package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;

/**
 * 分页的例子
 */
public class PageExp {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1","1","1","1","1","2","2","2","2","2","3","3","3","3","3");

        stringList.stream().limit(5).forEach(System.out::println);

        System.out.println("===================");

        stringList.stream().skip(5).limit(5).forEach(System.out::println);

        System.out.println("===================");

        stringList.stream().skip(10).limit(5).forEach(System.out::println);

    }
}
