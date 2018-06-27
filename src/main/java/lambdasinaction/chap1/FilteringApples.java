package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples {


    public static void main(String[] args) {

        List<Apple> appleList = Arrays.asList(new Apple("Green", 100),
                new Apple("Red", 150),
                new Apple("Green", 130));


        List<Apple> resultList1 = filterApples(appleList, FilteringApples::isGreen);
        System.out.println(resultList1);

        List<Apple> resultList2 = filterApples(appleList, FilteringApples::isWeight);
        System.out.println(resultList2);

        List<Apple> resultList3 = filterApples(appleList, (Apple apple) -> "Green".equals(apple.getColor()));
        System.out.println(resultList3);

        List<Apple> resultList4 = filterApples(appleList, (Apple apple) -> apple.getWeight() > 110);
        System.out.println(resultList4);

        List<Apple> resultList5 = filterApples(appleList, (Apple apple) -> apple.getWeight() > 110 && "Red".equals(apple.getColor()));
        System.out.println(resultList5);

        List<Apple> resultList6 = appleList.stream().filter((Apple apple) -> "Green".equals(apple.getColor())).collect(Collectors.toList());
        System.out.println(resultList6);
    }

    static boolean isGreen(Apple apple) {
        return "Green".equals(apple.getColor());
    }

    static boolean isWeight(Apple apple) {
        return apple.getWeight() > 110;
    }

    static List<Apple> filterApples(List<Apple> appleList, Predicate<Apple> p) {
        List<Apple> resultList = new ArrayList<>();
        for (Apple apple : appleList) {
            if (p.test(apple)) {
                resultList.add(apple);
            }
        }
        return resultList;
    }
}
