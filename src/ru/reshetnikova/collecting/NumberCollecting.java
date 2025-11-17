package ru.reshetnikova.collecting;
import ru.reshetnikova.validator.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class NumberCollecting implements Collecting<Integer, Map<String, List<Integer>>> {
    private List<Integer> input;
    private Map<String, List<Integer>> resultCollection;

    public List<Integer> getInput() {
        return input;
    }

    public Map<String, List<Integer>> getResultCollection() {
        return resultCollection;
    }

    public void setInput(List<Integer> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultCollection = Collecting3_4.collectCollecting(input, new HashMap<>(), this);
    }

    public NumberCollecting(List<Integer> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultCollection = Collecting3_4.collectCollecting(input, new HashMap<>(), this);
    }

    @Override
    public String toString() {
        return "Входные числа: " + input + "\n" +
                "Разбиение на положительные и отрицательные: " + resultCollection;
    }

    @Override
    public void collect(Map<String, List<Integer>> collection, Integer element) {
        String key;
        if (element > 0) {
            key = "положительные";
        } else if (element < 0) {
            key = "отрицательные";
        } else {
            key = "нули";
        }

        collection.computeIfAbsent(key, k -> new ArrayList<>()).add(element);
    }
}