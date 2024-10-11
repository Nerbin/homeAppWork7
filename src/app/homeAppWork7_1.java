package app;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class homeAppWork7_1 {

    public static void main(String[] args) {

        int[] array = new int[20];
        Random random = new SecureRandom();
        int negativeSum = 0;
        int evenCount = 0;
        int oddCount = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = 0;
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = 0;
        double avgAfterFirstNegative = 0;
        int countAfterFirstNegative = 0;
        int sumAfterFirstNegative = 0;
        boolean firstNegativeFound = false;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201) - 100;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negativeSum += array[i];
            }

            if (array[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            if (array[i] > maxValue) {
                maxValue = array[i];
                maxValueIndex = i;
            }

            if (array[i] < minValue) {
                minValue = array[i];
                minValueIndex = i;
            }

            if (!firstNegativeFound && array[i] < 0) {
                firstNegativeFound = true;
            } else if (firstNegativeFound) {
                sumAfterFirstNegative += array[i];
                countAfterFirstNegative++;
                avgAfterFirstNegative = (double) sumAfterFirstNegative / countAfterFirstNegative;
            }
        }
        System.out.println("Елементи масиву: " + Arrays.toString(array));
        System.out.println("Сума від'ємних чисел: " + negativeSum);
        System.out.println("Кількість парних чисел: " + evenCount);
        System.out.println("Кількість непарних чисел: " + oddCount);
        System.out.println("Найменший елемент: " + minValue + " (індекс " + minValueIndex + ")");
        System.out.println("Найбільший елемент: " + maxValue + " (індекс " + maxValueIndex + ")");

        if (!firstNegativeFound) {
            System.out.println("Не має негативних значень");
        } else {
            System.out.println("Середнє арифметичне чисел після першого від'ємного числа: " + avgAfterFirstNegative);
        }


    }

}
