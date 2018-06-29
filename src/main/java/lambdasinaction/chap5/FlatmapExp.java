package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatmapExp {
    public static void main(String[] args) {
//        String[] words = {"Hello","World"};
        List<String> words = Arrays.asList("Heello", "Heello");
        List<String> words1 = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(words1);
//        String hello = "Hello";
//        String[] a = hello.split("");
//        for (String s : a) {
//            System.out.println(s);
//        }

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<String> words3 = streamOfwords.distinct().collect(Collectors.toList());
        System.out.println(words3);
    }
}
