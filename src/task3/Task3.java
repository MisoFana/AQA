package task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        try {
            //Основа
            Scanner scanner = new Scanner(System.in);

            System.out.print("Довжина масиву: ");
            int arrLength = scanner.nextInt();

            int[] arr = new int[arrLength];
            for (int i = 0; i < arrLength; i++) {
                System.out.print("Під індексом " + i + " буде: ");
                arr[i] = scanner.nextInt();
            }

            //Перша частина
            int[] reversedArr = reverse(arr);
            System.out.println("Реверсований масив:");
            for (int j : reversedArr) {
                System.out.print(j + " ");
            }
            System.out.println();

            //Друга частина
            ArrayList<Integer> list = new ArrayList<>();
            for (int j : arr) {
                list.add(j);
            }
            System.out.println("Це новостворений список: " + list);

            System.out.println("Добавляю число 999 вкінець списку");
            list.add(999);
            System.out.println("Ось,аби видно зміни було: " + list);

            System.out.println("Видаляю, щойно доданий елемент за його індексом");
            list.remove(Integer.valueOf(999));
            System.out.println("Ось,аби видно зміни було: " + list);

            System.out.println("Заміняю значення першого елементу");
            if (!list.isEmpty()) {
                list.set(0, 888);
                System.out.println("Ось,аби видно зміни було: " + list);
            }

            System.out.println("Сортую...");
            Collections.sort(list);
            System.out.println("Ось,аби видно зміни було: " + list);

            ArrayList<Integer> noneList = null;
            noneList.add(1);
        } catch (NullPointerException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public static int[] reverse(int[] arr) {
        int[] payload = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            payload[i] = arr[arr.length - 1 - i];
        }
        return payload;

    }
}
