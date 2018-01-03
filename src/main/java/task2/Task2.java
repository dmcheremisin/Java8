package task2;

/**
 * Created by Dmitrii on 03.01.2018.
 */
public class Task2 {

    static class A {
        A (int one, String two, Double three){
        }
    }

    public interface ThreeArg<ONE, TWO, THREE, V> {
        V apply(ONE one, TWO two, THREE three);
    }

    public static void main(String[] args) {
        ThreeArg<Integer, String, Double, A> function = A::new;
        A a = function.apply(1, "2", 3.0);
    }
}
