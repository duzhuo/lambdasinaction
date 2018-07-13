package lambdasinaction.chap4;

import lambdasinaction.chap6.GroupByExp2;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    public enum CaloriesLevel {DIET, NORMAL, FAT}

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public CaloriesLevel getFatType() {
        if (this.getCalories() <= 400)
            return CaloriesLevel.DIET;
        else if (this.getCalories() <= 700)
            return CaloriesLevel.NORMAL;
        else
            return CaloriesLevel.FAT;
    }
}
