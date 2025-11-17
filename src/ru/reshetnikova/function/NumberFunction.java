package ru.reshetnikova.function;

import ru.reshetnikova.validator.*;
import java.util.List;

public class NumberFunction implements Function<Integer, Integer> {
    private List<Integer> input;
    private List<Integer> resultFunction;

    public List<Integer> getInput() {
        return input;
    }

    public List<Integer> getResultFunction() {
        return resultFunction;
    }

    public void setInput(List<Integer> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
}

public NumberFunction(List<Integer> input) {
    Validator.validateNull(input);
    this.input = input;
    this.resultFunction = Function3_1.applyFunction(input, this);
}

    @Override
    public String toString() {
        return "Входные числа: " + input + "\n"
                + "Список положительных чисел: " + resultFunction;
    }

    @Override
    public Integer apply(Integer obj) {
        return Math.abs(obj);
    }
}