package task4.Parts;


import java.util.ArrayList;
import java.util.List;

public class PartC<T> {

    private final List<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }

    public void printElements() {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        PartC<String> stringList = new PartC<>();
        stringList.add("Богдан");
        stringList.add("Рогів");

        System.out.println("Список стрінгів:");
        stringList.printElements();

        PartC<Integer> intList = new PartC<>();
        intList.add(999);
        intList.add(888);

        System.out.println("Список інтеджерів:");
        intList.printElements();
    }
}
