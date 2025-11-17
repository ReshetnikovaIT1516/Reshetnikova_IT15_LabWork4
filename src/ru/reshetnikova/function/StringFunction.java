package ru.reshetnikova.function;

import ru.reshetnikova.validator.*;
import java.util.List;

public class StringFunction implements Function<String, Integer> {
    private List<String> input;
    private List<Integer> resultFunction;

    public List<String> getInput() {
        return input;
    }

    public List<Integer> getResultFunction() {
        return resultFunction;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    public StringFunction(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    @Override
    public String toString() {
        return "Входные строки: " + input + "\n"
                + "Длины строк: " + resultFunction;
    }

    @Override
    public Integer apply(String obj) {
        return obj.length();
    }
}