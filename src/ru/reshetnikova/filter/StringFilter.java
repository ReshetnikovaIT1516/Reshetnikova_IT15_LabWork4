package ru.reshetnikova.filter;
import ru.reshetnikova.validator.*;
import java.util.List;

public class StringFilter implements Filter<String> {
    private List<String> input;
    private List<String> resultFilter;

    public List<String> getInput() {
        return input;
    }

    public List<String> getResultFilter() {
        return resultFilter;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    public StringFilter(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    @Override
    public String toString() {
        return "Входные строки: " + input + "\n"
                + "Отфильтрованные строки (длина которых больше или равна 3): " + resultFilter;
    }

    @Override
    public boolean test(String obj) {
        return obj.length() >= 3;
    }
}