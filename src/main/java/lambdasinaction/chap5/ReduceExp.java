package lambdasinaction.chap5;

import lambdasinaction.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExp {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> b = Arrays.asList();

        int sum1 = a.stream().reduce(0, (a1, b1) -> a1 + b1);
        System.out.println("sum1 is " + sum1);

        Optional<Integer> sum2 = a.stream().reduce(Integer::sum);
        System.out.println("sum2 is " + sum2.get());

        Optional<Integer> sum3 = b.stream().reduce(Integer::sum);
        System.out.println("sum3 is " + (sum3.isPresent() ? sum3.get() : "empty"));

        int sum4 = a.stream().reduce(0, Integer::sum);
        System.out.println("sum4 is " + sum4);

        Optional<Integer> sum5 = a.stream().reduce((a1, b1) -> a1 + b1);
        System.out.println("sum5 is " + sum5.get());

        Optional<Integer> max1 = a.stream().reduce(Integer::max);
        System.out.println("max1 is " + max1.get());

        Optional<Integer> max2 = b.stream().reduce(Integer::max);
        System.out.println("max2 is " + (max2.isPresent() ? max2.get() : "empty"));

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

        int result = menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);
        System.out.println("一共有 " + result + " 个菜");
    }
}
