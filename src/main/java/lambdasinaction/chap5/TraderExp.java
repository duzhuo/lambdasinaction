package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TraderExp {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //(1) 找出2011年发生的所有交易，并按交易额排序(从低到高)。
        System.out.println("(1) 找出2011年发生的所有交易，并按交易额排序(从低到高)。");
        transactions.stream()
                .filter(d -> d.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //(2) 交易员都在哪些不同的城市工作过?
        System.out.println("==================================");
        System.out.println("(2) 交易员都在哪些不同的城市工作过?");
        transactions.stream()
                .map(d -> d.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        // 第二种实现方式，存到set集合里
        Set<String> citys = transactions.stream()
                .map(d -> d.getTrader().getCity())
                .collect(Collectors.toSet());

        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
        System.out.println("==================================");
        System.out.println("(3) 查找所有来自于剑桥的交易员，并按姓名排序。");
        transactions.stream()
                .filter(d -> "Cambridge".equals(d.getTrader().getCity()))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);

        //(4) 返回所有交易员的姓名字符串，按字母顺序排序。
        System.out.println("==================================");
        System.out.println("(4) 返回所有交易员的姓名字符串，按字母顺序排序。");
//        transactions.stream()
//                .map(d -> d.getTrader().getName().split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .sorted(String::compareTo)
//                .forEach(System.out::println);

        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println("traderStr : " + traderStr);

        //(5) 有没有交易员是在米兰工作的?
        System.out.println("==================================");
        System.out.println("(5) 有没有交易员是在米兰工作的?");
        boolean isExist = transactions.stream()
                .anyMatch(d -> "Milan".equals(d.getTrader().getCity()));
        System.out.println(isExist);


        //(6) 打印生活在剑桥的交易员的所有交易额。
        System.out.println("==================================");
        System.out.println("(6) 打印生活在剑桥的交易员的所有交易额。");
        transactions.stream()
                .filter(d -> "Cambridge".equals(d.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // (7) 所有交易中，最高的交易额是多少?
        System.out.println("==================================");
        System.out.println("(7) 所有交易中，最高的交易额是多少?");
        Integer maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .get();
        System.out.println(maxValue);

        //(8) 找到交易额最小的交易。
        System.out.println("==================================");
        System.out.println("找到交易额最小的交易。");
        Integer minValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .get();
        System.out.println(minValue);

        Integer minValue1 = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get().getValue();
        System.out.println("minValue1 : " + minValue1);

    }
}
