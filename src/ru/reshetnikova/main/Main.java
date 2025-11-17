package ru.reshetnikova.main;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import ru.reshetnikova.box.*;
import ru.reshetnikova.validator.*;
import ru.reshetnikova.comparable.*;
import ru.reshetnikova.filter.*;
import ru.reshetnikova.function.*;
import ru.reshetnikova.reduction.*;
import ru.reshetnikova.collecting.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1) Задача 1.1: Обобщенная коробка.");
            System.out.println("2) Задача 1.3: Сравнимое.");
            System.out.println("3) Задача 2.2: Поиск максимума. ");
            System.out.println("4) Задача 3.1: Функция.");
            System.out.println("5) Задача 3.2: Фильтр. ");
            System.out.println("6) Задача 3.3: Сокращение.");
            System.out.println("7) Задача 3.4: Коллекционирование. ");
            System.out.println("0) Выход");
            System.out.print("Выберите задачу: ");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    scanner.nextLine();
                    System.out.println("Задача 1.1: Обобщенная коробка.");
                    GeneralizedBox<Integer> box1 = new GeneralizedBox<>();
                    System.out.println("Создана коробка 'BOX' для целых чисел.");
                    int m1;
                    do {
                        System.out.println("Введите номер действия: ");
                        System.out.println("1.Положить объект в коробку. ");
                        System.out.println("2.Взять объект из коробки. ");
                        System.out.println("3.Посмотреть содержимое коробки. ");
                        System.out.println("0.Завершить действия с коробкой. ");
                        m1 = scanner.nextInt();
                        scanner.nextLine();
                        switch (m1) {
                            case 1:
                                try {
                                    setBox(box1);
                                } catch (Exception e) {
                                    System.out.println("Ошибка: " + e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    takeBox(box1);
                                } catch (Exception e) {
                                    System.out.println("Ошибка: " + e.getMessage());
                                }
                                break;
                            case 3:
                                System.out.println(box1);
                                break;
                            case 0:
                                System.out.println("Работа программы завершена.");
                                break;
                            default:
                                System.out.println("Неверный выбор! Попробуйте снова.");
                        }
                    } while (m1 != 0);
                    break;


                case "2":
                    scanner.nextLine();
                    System.out.println("Задача 1.3: Сравнимое.");
                    int m2;
                    do {
                        System.out.println("Введите номер действия: ");
                        System.out.println("1.Сравнить два числа. ");
                        System.out.println("2.Сравнить две строки. ");
                        System.out.println("0.Завершить программу для сравнения. ");

                        m2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (m2) {
                            case 1:
                                ComparableNumber val1, val2;
                                while (true) {
                                    System.out.print("Введите первое число: ");
                                    String str1 = scanner.nextLine();
                                    if (!Validator.valIsNumber(str1)) {
                                        System.out.println("Ошибка: введите корректное число!");
                                    } else {
                                        val1 = new ComparableNumber(parseNumber(str1));
                                        break;
                                    }
                                }
                                while (true) {
                                    System.out.print("Введите второе число: ");
                                    String str2 = scanner.nextLine();
                                    if (!Validator.valIsNumber(str2)) {
                                        System.out.println("Ошибка: введите корректное число!");
                                    } else {
                                        val2 = new ComparableNumber(parseNumber(str2));
                                        break;
                                    }
                                }
                                int resNum = val1.compare(val2.getValue());
                                System.out.println(val1.getValue() + " " + resultCompare(resNum) + " " + val2.getValue());
                                break;
                            case 2:
                                System.out.print("Введите первую строку: ");
                                ComparableString str1 = new ComparableString(scanner.nextLine());

                                System.out.print("Введите вторую строку: ");
                                ComparableString str2 = new ComparableString(scanner.nextLine());

                                int resStr = str1.compare(str2.getStr());
                                System.out.println(str1.getStr() + " " + resultCompare(resStr) + " " + str2.getStr());
                                break;
                            case 0:
                                System.out.println("Работа программы завершена.");
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                                break;
                        }
                    } while (m2 != 0);
                    break;

                case "3":
                    scanner.nextLine();
                    System.out.println("Задача 2.2: Поиск максимума.");

                    List<GeneralizedBox<? extends Number>> numberBoxes = new ArrayList<>();
                    int m3;
                    do {
                        System.out.println("Введите номер действия: ");
                        System.out.println("1. Добавить коробку с числом");
                        System.out.println("2. Найти максимальное значение");
                        System.out.println("3. Показать все коробки");
                        System.out.println("0. Завершить поиск максимума");

                        m3 = scanner.nextInt();
                        scanner.nextLine();

                        switch (m3) {
                            case 1:
                                addNumberBox(numberBoxes);
                                break;
                            case 2:
                                try {
                                    double max = MaxFinder.findMax(numberBoxes);
                                    System.out.println("Максимальное значение: " + max);
                                } catch (Exception e) {
                                    System.out.println("Ошибка: " + e.getMessage());
                                }
                                break;
                            case 3:
                                showNumberBoxes(numberBoxes);
                                break;
                            case 0:
                                System.out.println("Работа программы завершена.");
                                break;
                            default:
                                System.out.println("Неверный выбор!");
                        }
                    } while (m3 != 0);
                    break;

                case "4":
                    scanner.nextLine();
                    System.out.println("Задача 3.1: Функция.");
                    int m4;
                    do {
                        System.out.println("Введите номер действия: ");
                        System.out.println("1.Применить функцию к строкам (длина).");
                        System.out.println("2.Применить функцию к числам (модуль).");
                        System.out.println("3.Применить функцию к массивам (максимум).");
                        System.out.println("0.Завершить работу программы.");

                        m4 = scanner.nextInt();
                        scanner.nextLine();
                        switch (m4) {
                            case 1:
                                List<String> input1 = new ArrayList<>();
                                inputString(input1);
                                StringFunction function1 = new StringFunction(input1);
                                System.out.println(function1);
                                break;
                            case 2:
                                List<Integer> input2 = new ArrayList<>();
                                inputIntList(input2);
                                NumberFunction function2 = new NumberFunction(input2);
                                System.out.println(function2);
                                break;
                            case 3:
                                List<int[]> input3 = new ArrayList<>();
                                inputIntMas(input3);
                                MasFunction function3 = new MasFunction(input3);
                                System.out.println(function3);
                                break;
                            case 0:
                                System.out.println("Работа программы завершена.");
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                                break;
                        }
                    } while (m4 != 0);
                    break;

                case "5":
                    scanner.nextLine();
                    System.out.println("Задача 3.2: Фильтр. ");
                    int m5;
                    do {
                        System.out.println("Введите номер действия: ");
                        System.out.println("1. Фильтр строк (длина >= 3)");
                        System.out.println("2. Фильтр чисел (не больше 0)");
                        System.out.println("3. Фильтр массивов (отрицательные)");
                        System.out.println("0. Завершить работу с фильтром");

                        m5 = scanner.nextInt();
                        scanner.nextLine();

                        switch (m5) {
                            case 1:
                                List<String> strings = new ArrayList<>();
                                inputString(strings);
                                System.out.println(new StringFilter(strings));
                                break;

                            case 2:
                                List<Integer> numbers = new ArrayList<>();
                                inputIntList(numbers);
                                System.out.println(new NumberFilter(numbers));
                                break;

                            case 3:
                                List<int[]> arrays = new ArrayList<>();
                                inputIntMas(arrays);
                                System.out.println(new MasFilter(arrays));
                                break;

                            case 0:
                                System.out.println("Работа программы завершена.");
                                break;
                            default:
                                System.out.println("Неверный выбор!");
                        }
                    } while (m5 != 0);
                    break;


                case "6":
                    scanner.nextLine();
                    System.out.println("Задача 3.3: Сокращение.");
                    int m6;
                    do {
                        System.out.println("Введите номер действия: ");
                        System.out.println("1. Сократить строки.");
                        System.out.println("2. Сократить числа.");
                        System.out.println("3. Сократить массивы.");
                        System.out.println("0. Завершить работу программы");

                        m6 = scanner.nextInt();
                        scanner.nextLine();
                        switch (m6) {
                            case 1:
                                List<String> input1 = new ArrayList<>();
                                inputString(input1);
                                StringReduction reduction1 = new StringReduction(input1);
                                System.out.println(reduction1);
                                break;
                            case 2:
                                List<Integer> input2 = new ArrayList<>();
                                inputIntList(input2);
                                NumberReduction reduction2 = new NumberReduction(input2);
                                System.out.println(reduction2);
                                break;
                            case 3:
                                List<int[]> input3 = new ArrayList<>();
                                inputIntMas(input3);
                                LengthStringReduction reduction3 = new LengthStringReduction(input3);
                                System.out.println(reduction3);
                                break;
                            case 0:
                                System.out.println("Работа программы завершена.");
                                break;
                            default:
                                System.out.println("Неверный номер действия!");
                                break;
                        }
                    } while (m6 != 0);
                    break;

                case "7":
                    scanner.nextLine();
                    System.out.println("Задача 3.4: Коллекционирование. ");
                    int m7;
                    do {
                        System.out.println("Введите номер действия: ");
                        System.out.println("1. Коллекционирование строк (подсчет вхождений)");
                        System.out.println("2. Коллекционирование чисел (разбиение на положительные/отрицательные/нули)");
                        System.out.println("3. Коллекционирование строк по длине");
                        System.out.println("0. Завершить работу программы");

                        m7 = scanner.nextInt();
                        scanner.nextLine();

                        switch (m7) {
                            case 1:
                                List<String> strings1 = new ArrayList<>();
                                inputString(strings1);
                                LengthStringCollecting masCollecting = new LengthStringCollecting(strings1);
                                System.out.println(masCollecting);
                                break;

                            case 2:
                                List<Integer> numbers = new ArrayList<>();
                                inputIntList(numbers);
                                NumberCollecting numberCollecting = new NumberCollecting(numbers);
                                System.out.println(numberCollecting);
                                break;

                            case 3:
                                List<String> strings2 = new ArrayList<>();
                                inputString(strings2);
                                StringCollecting stringCollecting = new StringCollecting(strings2);
                                System.out.println(stringCollecting);
                                break;

                            case 0:
                                System.out.println("Работа программы завершена.");
                                break;
                            default:
                                System.out.println("Неверный выбор!");
                        }
                    } while (m7 != 0);
                    break;

                case "0":
                    System.out.println("Выход из программы");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }

            System.out.println("\nНажмите 'Enter' чтобы снова выбрать номер задачи");
            scanner.nextLine();

        }
    }

    private static void setBox(GeneralizedBox<Integer> box) {

        int value;
        while (true) {
            System.out.print("Введите целое число, которое необходимо добавить в 'BOX': ");
            String str = scanner.nextLine();
            if (!Validator.valIsInt(str)) {
                System.out.println("Ошибка: введите корректное целое число!");
            } else {
                value = Integer.parseInt(str);
                break;
            }
        }
        box.setObj(value);
        System.out.println("Число " + value + " добавлено в коробку 'BOX'.");
    }

    private static void takeBox(GeneralizedBox<Integer> box) {
        Integer value = box.take();
        System.out.println("Из коробки извлекли значение: " + value);
    }

    private static Number parseNumber(String str) {
        try {
            if (str.contains(".")) {
                return Double.parseDouble(str);
            } else {
                return Integer.parseInt(str);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректное число: " + str);
        }
    }

    private static String resultCompare(int result) {
        switch (result) {
            case 1:
                return ">";
            case -1:
                return "<";
            case 0:
                return "=";
            default:
                throw new IllegalArgumentException("Некорректный результат сравнения: " + result);
        }
    }

    private static void inputString(List<String> input) {
        int count;
        while (true) {
            System.out.print("Введите количество строк: ");
            String c = scanner.nextLine();
            if (!Validator.valIsInt(c) || Integer.parseInt(c) < 0) {
                System.out.println("Ошибка: количество строк должно быть целым числом.");
            } else {
                count = Integer.parseInt(c);
                for (int i = 0; i < count; i++) {
                    System.out.print("Введите " + (i + 1) + " строку: ");
                    String str = scanner.nextLine();
                    input.add(str);
                }
                break;
            }
        }
    }


    private static void addNumberBox(List<GeneralizedBox<? extends Number>> boxes) {
        Number value;
        while (true) {
            System.out.print("Введите число для добавления в коробку: ");
            String str = scanner.nextLine();
            if (!Validator.valIsNumber(str)) {
                System.out.println("Ошибка: введите корректное число!");
            } else {
                value = parseNumber(str);
                break;
            }
        }

        GeneralizedBox<Number> box = new GeneralizedBox<>(value);
        boxes.add(box);
        System.out.println("Число " + value + " добавлено в коробку.");
    }

    private static void showNumberBoxes(List<GeneralizedBox<? extends Number>> boxes) {
        if (boxes.isEmpty()) {
            System.out.println("Список коробок пуст.");
            return;
        }

        System.out.println("Список коробок с числами:");
        for (int i = 0; i < boxes.size(); i++) {
            System.out.println((i + 1) + ". " + boxes.get(i));
        }
    }

    private static void inputIntList(List<Integer> input) {
        int count;
        while (true) {
            System.out.print("Введите количество чисел: ");
            String c = scanner.nextLine();
            if (!Validator.valIsInt(c) || Integer.parseInt(c) < 0) {
                System.out.println("Ошибка: количество должно быть целым положительным числом.");
            } else {
                count = Integer.parseInt(c);
                break;
            }
        }

        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Введите " + (i + 1) + " число: ");
                String numStr = scanner.nextLine();
                if (!Validator.valIsInt(numStr)) {
                    System.out.println("Ошибка: введите корректное целое число.");
                } else {
                    input.add(Integer.parseInt(numStr));
                    break;
                }
            }
        }
    }

    private static void inputIntMas(List<int[]> input) {
        System.out.println("Введите количество массивов: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Массив " + (i + 1) + ": ");
            int elementCount;
            while (true) {
                System.out.print("Введите количество элементов для массива " + (i + 1) + ": ");
                String countStr = scanner.nextLine();
                if (!Validator.valIsInt(countStr) || Integer.parseInt(countStr) < 0) {
                    System.out.println("Ошибка: количество элементов должно быть целым положительным числом.");
                } else {
                    elementCount = Integer.parseInt(countStr);
                    break;
                }
            }
            int[] array = new int[elementCount];
            for (int j = 0; j < elementCount; j++) {
                while (true) {
                    System.out.print("Введите " + (j + 1) + " элемент массива: ");
                    String elementStr = scanner.nextLine();
                    if (!Validator.valIsInt(elementStr)) {
                        System.out.println("Ошибка: введите корректное целое число.");
                    } else {
                        array[j] = Integer.parseInt(elementStr);
                        break;
                    }
                }
            }

            input.add(array);
            System.out.print("Массив " + (i + 1) + " добавлен: [");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j]);
                if (j < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
