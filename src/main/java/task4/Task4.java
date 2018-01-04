package task4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 04.01.2018.
 */
public class Task4 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        // collecting stream
        List<String> filteredList = list.stream().filter((s) -> s.startsWith("s")).collect(Collectors.toList());

        // iteration over stream
        list.stream().filter((s) -> s.startsWith("s")).forEachOrdered(System.out::println);

        // add a value to each element
        list.stream().map(s -> "Number: " + s).forEach(System.out::println);

    }
}
