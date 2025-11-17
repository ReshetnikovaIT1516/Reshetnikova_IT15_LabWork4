package ru.reshetnikova.reduction;
import ru.reshetnikova.validator.*;
import java.util.List;

public class StringReduction implements Reduction<String> {
    private List<String> input;
    private String resultReduction;

    public List<String> getInput() {
        return input;
    }

    public String getResultReduction() {
        return resultReduction;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = Reduction3_3.reduce(input, "", this);
    }

    public StringReduction(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = Reduction3_3.reduce(input, "", this);
    }

    @Override
    public String toString() {
        return "Входные строки: " + input + "\n"
                + "Сформированная строка: " + resultReduction;
    }


    @Override
    public String reduc(String res, String obj) {
        // Гарантируем, что не будет null
        if (res == null) res = "";
        if (obj == null) obj = "";
        return res + obj;
    }
}