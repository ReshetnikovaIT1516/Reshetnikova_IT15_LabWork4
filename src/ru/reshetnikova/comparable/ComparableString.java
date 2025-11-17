package ru.reshetnikova.comparable;

public class ComparableString implements Comparable<String> {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public ComparableString(String str) {
        this.str = str;
    }

    @Override
    public int compare (String string) {
        int result = this.str.compareTo(string);
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (str == null) {
            return "Строка: null";
        }
        return "Строка: " + str;
    }
}