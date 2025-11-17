package ru.reshetnikova.filter;

public interface Filter<T> {
    boolean test(T obj);
}