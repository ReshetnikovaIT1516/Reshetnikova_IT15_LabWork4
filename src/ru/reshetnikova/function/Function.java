package ru.reshetnikova.function;

public interface Function<T, P> {
    P apply(T value);
}
