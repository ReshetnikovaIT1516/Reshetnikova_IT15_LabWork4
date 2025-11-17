package ru.reshetnikova.collecting;
import java.util.List;

public class Collecting3_4 {
    public static <T, P> P collectCollecting(List<T> list, P collection, Collecting<T, P> collecting) {
        if (list == null || collection == null || collecting == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null");
        }
        for (T element : list) {
            collecting.collect(collection, element);
        }
        return collection;
    }
}