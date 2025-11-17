package ru.reshetnikova.function;

public interface Function<T, R> {
    R apply(T value);
}
