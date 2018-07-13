package lambdasinaction.chap6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 对一个交易列表按货币分组，获得该货币的所有交易额总和(返回一个Map<Currency,
 * Integer>)。
 */
public class GroupByExp {
    public static void main(String[] args) {
        List<Transaction> transactionList = Arrays.asList(new Transaction("CNY", 100),
                new Transaction("CNY", 200),
                new Transaction("CNY", 300),
                new Transaction("USD", 100),
                new Transaction("USD", 200),
                new Transaction("USD", 300) );

        Map<String, List<Transaction>> map = transactionList.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        map.forEach((key, value) -> System.out.println(key + " -> " + value));

    }
}
