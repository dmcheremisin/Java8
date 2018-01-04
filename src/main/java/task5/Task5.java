package task5;

import library.Book;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Dmitrii on 04.01.2018.
 */
public class Task5 {

    public static void main(String[] args) {
        List<Book> library = Book.library;

        // book -> getTitle
        List<String> titles = library.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        titles.forEach(System.out::println);

        // book -> authors -> list of authors
        List<String> authors = library.stream()
                .flatMap(b -> b.getAuthors().stream())
                .distinct()
                .collect(Collectors.toList());
        authors.forEach(System.out::println);

        // collection of pages: book -> pages int[] -> list of all pages
        List<Integer> pages = library.stream()
                .flatMap(b -> Arrays.stream(b.getPageCounts()).boxed())
                .collect(Collectors.toList());
        pages.forEach(System.out::println);

        // count all pages
        int total = library.stream()
                .flatMapToInt(b -> IntStream.of(b.getPageCounts()))
                .sum();
        System.out.println(total);

    }
}
