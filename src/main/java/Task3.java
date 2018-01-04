import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Created by Dmitrii on 04.01.2018.
 */
public class Task3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // Predicate
        Predicate<String> p1 = (s) ->  list.add(s);
        Predicate<String> p2 = list::add;

        // Consumer
        Consumer<String> c1 = (s) -> list.add(s);
        Consumer<String> c2 = list::add;

        // Funstion
        Function<Integer, String> f1 = (Integer i) -> i.toString();
        Function<Integer, String> f2 = Object::toString;

        // Supplier
        Supplier<String> s1 = () -> "new supplier";
        Supplier<String> s2 = String::new;

        // UnaryOperator
        UnaryOperator<Integer> u1 = (i) -> ++i;
        UnaryOperator<Integer> u2 = Integer::bitCount;

        // BinaryOperator
        BinaryOperator<Integer> b = (i, j) -> i+j;

        // BiPredicate
        BiPredicate<Integer, Double> bp = (i, d) -> d.intValue() > i;

        // BiConsumer
        BiConsumer<String, Float> bc = (s, f) -> f = f + s.length();

        // BiFunction
        BiFunction<Integer, Float, Double> bf = (i, f) -> i.doubleValue() + f.doubleValue();







    }
}
