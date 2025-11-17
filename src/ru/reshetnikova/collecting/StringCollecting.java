package ru.reshetnikova.collecting;
import ru.reshetnikova.validator.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class StringCollecting implements Collecting<String, Map<Integer, List<String>>> {
    private List<String> input;
    private Map<Integer, List<String>> resultCollection;

    public List<String> getInput() {
        return input;
    }

    public Map<Integer, List<String>> getResultCollection() {
        return resultCollection;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultCollection = Collecting3_4.collectCollecting(input, new HashMap<>(), this);
    }

    public StringCollecting(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultCollection = Collecting3_4.collectCollecting(input, new HashMap<>(), this);
    }

    @Override
    public String toString() {
        return "Входные строки: " + input + "\n" +
                "Группировка по длине: " + resultCollection;
    }

    @Override
    public void collect(Map<Integer, List<String>> collection, String element) {
        int length = element.length();
        collection.computeIfAbsent(length, k -> new ArrayList<>()).add(element);
    }
}