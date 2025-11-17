package ru.reshetnikova.filter;

import ru.reshetnikova.validator.*;
import java.util.List;
import java.util.Arrays;

public class MasFilter implements Filter<int[]> {
    private List<int[]> input;
    private List<int[]> resultFilter;

    public List<int[]> getInput() {
        return input;
    }

    public List<int[]> getResultFilter() {
        return resultFilter;
    }

    public void setInput(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    public MasFilter(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    @Override
    public String toString() {
        return "Список входных массивов: " + arraysToString(input) + "\n"
                + "Отфильтрованные массивы (без положительных элементов): " + arraysToString(resultFilter);
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
    public boolean test(int[] obj) {
        for (int num : obj) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}