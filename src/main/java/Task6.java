import library.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii on 04.01.2018.
 */
public class Task6 {

    public static void main(String[] args) {
        List<Book> library = Book.library;

        Map<Book.Topic, List<Book>> bookByTopic = library.stream().collect(Collectors.groupingBy(Book::getTopic));
        System.out.println(bookByTopic);
    }
}
