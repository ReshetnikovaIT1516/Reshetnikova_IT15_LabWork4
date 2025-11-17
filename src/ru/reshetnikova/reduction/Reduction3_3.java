package ru.reshetnikova.reduction;

import java.util.List;
import ru.reshetnikova.validator.Validator;

public class Reduction3_3 {

    public static <T> T reduce(List<T> list, T initial, Reduction<T> reduction) {
        Validator.validateNull(list);
        if (reduction == null) {
            throw new IllegalArgumentException("Функция сокращения не может быть null");
        }

        T result = initial;
        for (T item : list) {
            result = reduction.reduc(result, item);
        }
        return result;
    }
}