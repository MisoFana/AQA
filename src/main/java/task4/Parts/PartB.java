package task4.Parts;

import java.lang.reflect.Constructor;

class Bohdan {
    private String lastName;
    private int age;

    public Bohdan() {
    }

    public Bohdan(String lastName) {
        this.lastName = lastName;
    }

    public Bohdan(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }
}

public class PartB {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Bohdan.class;

            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Всі доступні конструктори: " + constructor);
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getName());
                    if (i < parameterTypes.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }

            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Bohdan myObject = (Bohdan) constructor.newInstance("Рогів", 20);
            System.out.println("Створення обєкта: " + myObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
