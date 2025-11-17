package ru.reshetnikova.box;
import java.util.List;

public class MaxFinder {

    public static double findMax(List<? extends GeneralizedBox<? extends Number>> boxes) {
        if (boxes == null) {
            throw new IllegalArgumentException("Список коробок не может быть null.");
        }
        if (boxes.isEmpty()) {
            throw new IllegalArgumentException("Список коробок пустой.");
        }

        double maxValue = -Double.MAX_VALUE; // начальное значение
        boolean foundNumber = false; // есть хотя бы одно число


        for (int i = 0; i < boxes.size(); i++) {
            GeneralizedBox<? extends Number> currentBox = boxes.get(i);

            if (!currentBox.isEmpty()) {
                Number number = currentBox.getObj();
                double currentValue = number.doubleValue();

                if (!foundNumber) {
                    maxValue = currentValue;
                    foundNumber = true;
                } else {
                    if (currentValue > maxValue) {
                        maxValue = currentValue;
                    }
                }
            }
        }

        if (!foundNumber) {
            throw new IllegalArgumentException("Все коробки пусты или не содержат чисел.");
        }
        return maxValue;
    }
}
