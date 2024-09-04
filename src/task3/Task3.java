package task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Довжина масиву: ");
        int arrLength = scanner.nextInt();

        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            System.out.print("Під індексом " + i + " буде: ");
            arr[i] = scanner.nextInt();
        }

        int[] reversedArr = reverse(arr);
        System.out.println("Реверсований масив:");
        for (int num : reversedArr) {
            System.out.print(num + " ");
        }
        System.out.println();

    }

    public static int[] reverse(int[] arr) {
        int[] payload = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            payload[i] =  arr[arr.length - 1 - i];
        }
        return payload;

    }
}
