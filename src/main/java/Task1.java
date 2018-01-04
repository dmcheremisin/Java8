import java.util.Arrays;

/**
 * Created by Dmitrii on 03.01.2018.
 */
public class Task1 {

    public static void main(String[] args) {

        String[] strings = {"one", "two", "three", "four", "five", "six", "seven", "eight"};

        // 1. sort by length descendant
        Arrays.sort(strings, (s1, s2) -> s2.length() - s1.length());
        printArray(strings);

        // 2. sort alphabetically by second letter
        Arrays.sort(strings, (s1, s2) -> s1.toUpperCase().charAt(1) - s2.toUpperCase().charAt(1));
        printArray(strings);

        // 3. sort by second letter only words that start with "t"
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.toLowerCase().charAt(0) == 't' || s2.toLowerCase().charAt(0) == 't') {
                return s1.toUpperCase().charAt(1) - s2.toUpperCase().charAt(1);
            } else {
                return 0;
            }
        });
        printArray(strings);

    }

    private static void printArray(String[] strings) {
        Arrays.asList(strings).forEach(System.out::println);
        System.out.println(" ============================== ");
    }
}
