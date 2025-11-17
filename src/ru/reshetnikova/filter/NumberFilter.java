package ru.reshetnikova.filter;
import ru.reshetnikova.validator.*;
import java.util.List;

public class NumberFilter implements Filter<Integer> {
    private List<Integer> input;
    private List<Integer> resultFilter;

    public List<Integer> getInput() {
        return input;
    }

    public List<Integer> getResultFilter() {
        return resultFilter;
    }

    public void setInput(List<Integer> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    public NumberFilter(List<Integer> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    @Override
    public String toString() {
        return "Входные числа: " + input + "\n"
                + "Отфильтрованные числа (отрицательные): " + resultFilter;
    }

    @Override
    public boolean test(Integer obj) {
        return obj <= 0;
    }
}