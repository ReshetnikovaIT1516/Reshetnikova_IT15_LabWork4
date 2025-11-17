package ru.reshetnikova.reduction;

public interface Reduction <T>{
    T reduc(T res, T obj);
}