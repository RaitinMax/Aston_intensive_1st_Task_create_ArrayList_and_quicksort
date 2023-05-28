import org.junit.Test;

import static org.junit.Assert.*;

public class ArraListTests {

    //сравниваем ожидаемое и фактическое значение в Integer
    @Test
    public void testAddAndGet() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(9);

        assertEquals(Integer.valueOf(4), list.get(0));
        assertEquals(Integer.valueOf(7), list.get(1));
        assertEquals(Integer.valueOf(9), list.get(2));
        System.out.println("ok");
    }


    //сравниваем ожидаемое и фактическое значение в String
    @Test
    public void testInsert() {
        ArrayList<String> list = new ArrayList<>();
        //добавим 2 элемента в конец списка
        list.add("monkey");
        list.add("burj-khalifa");
        // добавим элемент по указанному списку сдвинув все остальные элементы в списке
        list.insert(1, "Omega");

        assertEquals("monkey", list.get(0));
        assertEquals("Omega", list.get(1));
        assertEquals("burj-khalifa", list.get(2));
        System.out.println("ok");
    }

    @Test
    public void testRemove() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(8);
// удаляем второй элемент в ArrayList'e
        list.remove(5);

        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(8), list.get(1));
        // теперь должно остаться два элемента в ArrayList'e
        assertEquals(2, list.size);
        System.out.println("ok");
    }

    @Test
    public void testClear() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        list.clear();

        assertEquals(0, list.size());
        System.out.println("ok");
    }

    @Test
    public void testSort() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(8);
        list.add(3);
        list.add(1);

        list.sort();

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
        assertEquals(Integer.valueOf(5), list.get(2));
        assertEquals(Integer.valueOf(8), list.get(3));
        assertEquals(Integer.valueOf(10), list.get(4));
        System.out.println("ok");
    }
}
