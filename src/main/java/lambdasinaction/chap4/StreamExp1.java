package lambdasinaction.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExp1 {

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

        List<String> nameList = menu.stream()
                .filter(dish -> dish.getCalories() > 400)
                .limit(3)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);


        System.out.println("==================================");
        List<String> nameList1 = menu.stream()
                .limit(3)
                .filter(
                        dish -> {
                            System.out.println("filter " + dish.getName());
                            return dish.getCalories() > 600;
                        }
                )
                .map(dish -> {
                    System.out.println("map " + dish.getName());
                    return dish.getName();
                })
                .collect(Collectors.toList());
        System.out.println(nameList1);

        System.out.println("==================================");
        menu.stream().forEach(System.out::println);
    }


}
