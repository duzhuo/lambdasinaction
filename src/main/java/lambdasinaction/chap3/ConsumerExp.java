package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExp {

    public static void main(String[] args) {
        foreach(Arrays.asList("1","2","3","4"), (String t) -> System.out.println(t));
        foreach(Arrays.asList(1,2,3,4), (Integer t) -> System.out.println(t+1));
        foreach(Arrays.asList(1,2,3,4), t -> System.out.println(t+1));
    }

    private static <T> void foreach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
