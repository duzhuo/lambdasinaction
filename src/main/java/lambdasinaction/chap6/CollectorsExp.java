package lambdasinaction.chap6;

import lambdasinaction.chap4.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExp {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 620, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        Long count = menu.stream().collect(Collectors.counting());
        System.out.println(count);

        Long count1 = menu.stream().count();
        System.out.println(count1);

        System.out.println("===============================================");

        Optional<Dish> optionalDish = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println("dish is " + optionalDish.get());

        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("total calories is :" + totalCalories);

        double avgCalories = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println("average calories is : " + avgCalories);

        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("intSummaryStatistics is " + intSummaryStatistics);

        String menuName = menu.stream().map(Dish::getName).collect(Collectors.joining(" | "));
        System.out.println("menuName is " + menuName);
    }
}
