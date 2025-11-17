package ru.reshetnikova.collecting;

public interface Collecting <T, P> {
    void collect(P collection, T element);
}