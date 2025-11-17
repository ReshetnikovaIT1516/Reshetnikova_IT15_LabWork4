package ru.reshetnikova.function;

import java.util.ArrayList;
import java.util.List;

public class Function3_1 {

    public static <T, R> List<R> apply(List<T> list, Function<T, R> function) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }
        if (function == null) {
            throw new IllegalArgumentException("Функция не может быть null");
        }

        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
    public static <T, R> List<R> applyFunction(List<T> list, Function<T, R> function) {
        return apply(list, function);
    }
}