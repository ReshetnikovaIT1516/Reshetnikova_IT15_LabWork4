package ru.reshetnikova.filter;
import ru.reshetnikova.validator.*;
import java.util.ArrayList;
import java.util.List;

public class Filter3_2 {

    public static <T> List<T> filter(List<T> list, Filter<T> filter) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Фильтр не может быть null");
        }

        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // Добавляем метод testFilter для использования в ваших классах
    public static <T> List<T> testFilter(List<T> list, Filter<T> filter) {
        return filter(list, filter);
    }
}