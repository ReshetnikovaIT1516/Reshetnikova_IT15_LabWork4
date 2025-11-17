package ru.reshetnikova.validator;
import ru.reshetnikova.box.*;
import java.util.List;

public class Validator {
    public static boolean valIsInt(String value) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean valIsDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean valIsNumber(String value) {
        return valIsInt(value) || valIsDouble(value);
    }

    public static <T> void validateNull(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null.");
        }
    }
}