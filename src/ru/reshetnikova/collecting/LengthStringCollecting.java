package ru.reshetnikova.collecting;
import ru.reshetnikova.validator.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LengthStringCollecting implements Collecting<String, Map<String, Long>> {
    private List<String> input;
    private Map<String, Long> resultCollection;

    public List<String> getInput() {
        return input;
    }

    public Map<String, Long> getResultCollection() {
        return resultCollection;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultCollection = Collecting3_4.collectCollecting(input, new HashMap<>(), this);
    }

    public LengthStringCollecting(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultCollection = Collecting3_4.collectCollecting(input, new HashMap<>(), this);
    }

    @Override
    public String toString() {
        return "Входные строки: " + input + "\n" +
                "Количество вхождений каждой строки: " + resultCollection;
    }

    @Override
    public void collect(Map<String, Long> collection, String element) {
        collection.put(element, collection.getOrDefault(element, 0L) + 1);
    }
}