package lambdasinaction.chap6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DescSortExp {
    public static void main(String[] args) {
        List<String> date = Arrays.asList("2018-07-01","2018-07-02","2018-06-01","2018-07-11","2018-07-21");
        List<String> newDate = date.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(1);

        List<DateDto> date1 = Arrays.asList(new DateDto("2018-07-01"),
                new DateDto("2018-07-02"), new DateDto("2018-06-01"),
                new DateDto("2018-07-11"), new DateDto("2018-07-21"));

        List<DateDto> newDate1 = date1.stream().sorted((a,b) -> b.getDate().compareTo(a.getDate())).collect(Collectors.toList());
        newDate1.forEach(System.out::println);
    }
}

class DateDto {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DateDto(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DateDto{" +
                "date='" + date + '\'' +
                '}';
    }
}
