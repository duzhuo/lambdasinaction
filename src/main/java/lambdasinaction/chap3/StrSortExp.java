package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;

public class StrSortExp {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a","b","A","B");
        // 这里走的是String::compareToIgnoreCase的排序实现，而不是List.sort的默认实现
        str.sort((a,b) -> a.compareToIgnoreCase(b));
        System.out.println(str);

        List<String> str2 = Arrays.asList("a","b","C","A","c","B");
        str2.sort(String::compareToIgnoreCase);
        System.out.println(str2);
    }
}
