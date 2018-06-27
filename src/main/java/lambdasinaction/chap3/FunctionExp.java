package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExp {

    private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> rList = new ArrayList<>();
        for (T t : list) {
            rList.add(f.apply(t));
        }
        return rList;
    }

    public static void main(String[] args) {
       List<Integer> rList = map(Arrays.asList("a","bb","cccc","ddddddd","eeeeeeeee"), (String t) -> t.length());
       rList.forEach((Integer length) -> System.out.println(length));
    }
}
