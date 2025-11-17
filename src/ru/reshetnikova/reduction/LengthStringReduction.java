package ru.reshetnikova.reduction;
import ru.reshetnikova.validator.Validator;
import ru.reshetnikova.function.Function3_1;
import ru.reshetnikova.function.Function;
import java.util.List;
import java.util.Arrays;

public class LengthStringReduction {
    private List<int[]> input;
    private Integer resultReduction;

    public List<int[]> getInput() {
        return input;
    }

    public Integer getResultReduction() {
        return resultReduction;
    }

    public void setInput(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = calculateElements();
    }

    public LengthStringReduction(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = calculateElements();
    }

    @Override
    public String toString() {
        return "Список входных массивов: " + arraysToString(input) + "\n"
                + "Общее количество элементов во всех массивах: " + resultReduction;
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

    private Integer calculateElements() {
        // Используем Function3_1 для получения длин массивов
        List<Integer> sizes = Function3_1.applyFunction(input, new Function<int[], Integer>() {
            @Override
            public Integer apply(int[] array) {
                if (array == null) return 0;
                return array.length;
            }
        });

        // Используем Reduction3_3 для суммирования длин
        return Reduction3_3.reduce(sizes, 0, new Reduction<Integer>() {
            @Override
            public Integer reduc(Integer res, Integer obj) {
                if (res == null) res = 0;
                if (obj == null) obj = 0;
                return res + obj;
            }
        });
    }
}