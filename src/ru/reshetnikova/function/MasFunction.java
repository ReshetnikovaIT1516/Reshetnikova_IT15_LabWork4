package ru.reshetnikova.function;

import ru.reshetnikova.validator.*;
import java.util.List;
import java.util.Arrays;

public class MasFunction implements Function<int[], Integer> {
    private List<int[]> input;
    private List<Integer> resultFunction;

    public List<int[]> getInput() {
        return input;
    }

    public List<Integer> getResultFunction() {
        return resultFunction;
    }

    public void setInput(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    public MasFunction(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    @Override
    public String toString() {
        return "Список входных массивов: " + arraysToString(input) + "\n"
                + "Максимальные значения массивов: " + resultFunction;
    }

    private String arraysToString(List<int[]> arrays) {
        if (arrays == null) return "null";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arrays.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(Arrays.toString(arrays.get(i)));
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Integer apply(int[] obj) {
        if (obj == null || obj.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }

        int max = obj[0];
        for (int i = 1; i < obj.length; i++) {
            if (obj[i] > max) {
                max = obj[i];
            }
        }
        return max;
    }
}