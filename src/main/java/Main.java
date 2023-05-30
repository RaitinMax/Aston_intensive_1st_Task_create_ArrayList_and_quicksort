import java.util.*;

public class Main {
    public static void main(String[] args) {
        /** Создание экземпляра ArrayList*/
        ArrayList<Integer> myArrayList = new ArrayList<>();

        /** Добавление элементов*/
        myArrayList.add(10);
        myArrayList.add(5);
        myArrayList.add(8);
        /** Вывод элемента по индексу*/
        System.out.println(myArrayList.get(1));

        /** Добавление элемента по индексу*/
        myArrayList.insert(1, 15);

        /** Удаление элемента*/
        myArrayList.remove(10);

        /** Сортировка списка*/
        myArrayList.sort();

        /** Очистка коллекции*/
        myArrayList.clear();

    }
}
