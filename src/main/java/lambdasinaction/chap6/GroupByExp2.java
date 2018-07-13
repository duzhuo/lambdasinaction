package lambdasinaction.chap6;

import lambdasinaction.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExp2 {
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

        Map<Dish.Type, List<Dish>> dishMap = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        dishMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("===============================================================");

        Map<CaloriesLevel, List<Dish>> map2 = menu.stream().collect(Collectors.groupingBy(d -> {
            if (d.getCalories() <= 400)
                return CaloriesLevel.DIET;
            else if (d.getCalories() <= 700)
                return CaloriesLevel.NORMAL;
            else
                return CaloriesLevel.FAT;
        }));
        map2.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("===============================================================");

        Map<Dish.Type, Map<Dish.CaloriesLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(Dish::getFatType)));
        dishesByTypeCaloricLevel.forEach((k, v) -> System.out.println(k + " -> " + v));

    }

    public enum CaloriesLevel {DIET, NORMAL, FAT}
}
