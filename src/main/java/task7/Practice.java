package task7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 05.01.2018.
 */
public class Practice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> query1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        printQuery(query1);

        // Query 2: What are all the unique cities where the traders work?
        List<String> query2 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        printQuery(query2);

        // Query 3: Find all traders from Cambridge and sort them by name.
        List<Trader> query3 = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> "Cambridge".equals(t.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        printQuery(query3);


        // Query 4: Return a string of all traders’ names sorted alphabetically.
        String query4 = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .reduce("", (name1, name2) -> name1 + ", " + name2);
        System.out.println(query4);
        System.out.println(" ========================================= ");

        // Query 5: Are there any trader based in Milan?
        boolean query5 = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(t -> "Milan".equals(t.getCity()));
        System.out.println(query5);
        System.out.println(" ========================================= ");

        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> "Milan".equals(t.getCity()))
                .forEach(t -> t.setCity("Cambridge"));
        List<Trader> query6 = transactions.stream()
                .map(Transaction::getTrader)
                .collect(Collectors.toList());
        printQuery(query6);

        // Query 7: What's the highest value in all the transactions?
        Optional<Integer> first = transactions.stream().map(Transaction::getValue).sorted((t1, t2) -> t2 - t1).findFirst();
        System.out.println(first.orElse(0));
    }

    private static void printQuery(List list) {
        list.forEach(System.out::println);
        System.out.println(" ========================================= ");
    }
}
