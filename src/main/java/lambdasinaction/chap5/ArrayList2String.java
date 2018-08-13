package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;

public class ArrayList2String {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123,","3435,","4544,");
        System.out.println(list.toString());

        StringBuilder ss = new StringBuilder();
        list.forEach(ss::append);
        System.out.println(ss);
    }
}
