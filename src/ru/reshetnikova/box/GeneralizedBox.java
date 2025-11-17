package ru.reshetnikova.box;

public class GeneralizedBox<T> {
    //Поля
    private T obj;

    //Свойства
    //Посмотреть объект в коробке
    public T getObj() {
        return obj;
    }

    //Положить объект в коробку
    public void setObj(T obj) {
        busyBox();
        this.obj = obj;
    }

    //Взять объект из коробки
    public T take() {
        freeBox();
        T getObj = obj;
        obj = null;
        return getObj;
    }

    //Конструкторы
    //По умолчанию
    public GeneralizedBox() {
        this.obj = null;
    }

    //С параметрами
    public GeneralizedBox(T obj) {
        this.obj = obj;
    }

    //Копирования
    public GeneralizedBox(GeneralizedBox<T> generalizedBox) {
        if (generalizedBox == null) {
            throw new IllegalArgumentException("Коробка для копирования не может быть null");
        }
        this.obj = generalizedBox.obj;
    }

    //Заполнена ли коробка?
    public boolean isEmpty() {
        return obj == null;
    }

    @Override
    public String toString() {
        String result = "Содержимое коробки: ";
        if (isEmpty()) {
            result += "пусто";
        } else {
            result += obj ;
        }
        return result;
    }

    private void busyBox() {
        if (!isEmpty()) {
            throw new IllegalStateException("Коробка уже занята!");
        }
    }

    private void freeBox() {
        if (isEmpty()) {
            throw new IllegalStateException("Коробка пустая!");
        }
    }
}