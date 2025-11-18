package ru.reshetnikova.function;

import java.util.ArrayList;
import java.util.List;

public class Function3_1 {

    public static <T, P> List<P> apply(List<T> list, Function<T, P> function) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }
        if (function == null) {
            throw new IllegalArgumentException("Функция не может быть null");
        }

        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
    public static <T, P> List<P> applyFunction(List<T> list, Function<T, P> function) {
        return apply(list, function);
    }
}