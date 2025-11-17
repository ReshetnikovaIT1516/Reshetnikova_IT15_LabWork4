package ru.reshetnikova.comparable;

public class ComparableNumber implements Comparable<Number> {
    private Number value;

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public ComparableNumber(Number value) {
        this.value = value;
    }

    @Override
    public int compare(Number number) {
        double thisValue = this.value.doubleValue();
        double numberValue = number.doubleValue();

        if (thisValue > numberValue) {
            return 1;
        } else if (thisValue < numberValue) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (value == null) {
            return "Число = null";
        }
        return "Число = " + value;
    }
}