package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;
import ua.opnu.MyOptional;
import ua.opnu.BookData;
import ua.opnu.Printer;

// --- Завдання 6: Кортежі ---
class GenericTwoTuple<T, V> {
    public final T first;
    public final V second;

    public GenericTwoTuple(T f, V s) {
        first = f;
        second = s;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class GenericThreeTuple<T, V, S> {
    public final GenericTwoTuple<T, V> twoTuple;
    public final S three;

    public GenericThreeTuple(T f, V s, S t) {
        twoTuple = new GenericTwoTuple<>(f, s);
        three = t;
    }

    public String toString() {
        return "(" + twoTuple.first + ", " + twoTuple.second + ", " + three + ")";
    }
}

public class Main {

    // --- Завдання 4: Узагальнений метод filter() ---
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) new Object[input.length];
        int counter = 0;
        for (T i : input) {
            if (p.test(i)) {
                result[counter] = i;
                counter++;
            }
        }
        return Arrays.copyOfRange(result, 0, counter);
    }

    // --- Завдання 5: Узагальнений метод contains() ---
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // --- Завдання 1 ---
        System.out.println("--- Завдання 1 ---");
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("guest"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволило створити: " + ex.getMessage());
        }

        // --- Завдання 2 ---
        System.out.println("\n--- Завдання 2 ---");
        BookData[] books = {
                new BookData("Clean Code", "Martin", 200, 1000),
                new BookData("Java 8", "Schildt", 100, 480)
        };
        Arrays.sort(books);
        for (BookData b : books) {
            System.out.println(b);
        }

        // --- Завдання 3 ---
        System.out.println("\n--- Завдання 3 ---");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // --- Завдання 4 ---
        System.out.println("\n--- Завдання 4 ---");
        String[] words = {"Одеса", "Київ", "Львів", "Дніпро"};
        System.out.println("Слова довше 4 букв: " + Arrays.toString(filter(words, s -> s.length() > 4)));

        // --- Завдання 5 ---
        System.out.println("\n--- Завдання 5 ---");
        Integer[] nums = {10, 20, 30};
        System.out.println("Чи містить 20? " + contains(nums, 20));

        // --- Завдання 6 ---
        System.out.println("\n--- Завдання 6 ---");
        GenericThreeTuple<String, Integer, String> fullInfo = new GenericThreeTuple<>("Глухова Анна", 95, "АІ-252");
        System.out.println("ThreeTuple: " + fullInfo);
    }
}