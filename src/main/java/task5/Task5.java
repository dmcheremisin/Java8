package task5;

import library.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static library.Book.Topic.FICTION;

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

        // any fiction book
        Optional<Book> any = library.stream().filter(b -> FICTION.equals(b.getTopic())).findAny();
        System.out.println(any.orElse(new Book()).getTitle());

    }
}
