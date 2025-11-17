package ru.reshetnikova.reduction;
import ru.reshetnikova.validator.*;
import java.util.List;

public class NumberReduction implements Reduction<Integer> {
    private List<Integer> input;
    private Integer resultReduction;

    public List<Integer> getInput() {
        return input;
    }

    public Integer getResultReduction() {
        return resultReduction;
    }

    public void setInput(List<Integer> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = Reduction3_3.reduce(input, 0, this);
    }

    public NumberReduction(List<Integer> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = Reduction3_3.reduce(input, 0, this);
    }

    @Override
    public String toString() {
        return "Входные числа: " + input + "\n"
                + "Результат сокращения (сумма всех чисел): " + resultReduction;
    }

    @Override
    public Integer reduc(Integer res, Integer obj) {
        // Гарантируем, что не будет null
        if (res == null) res = 0;
        if (obj == null) obj = 0;
        return res + obj;
    }
}