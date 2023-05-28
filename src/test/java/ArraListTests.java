import org.junit.Test;
import static org.junit.Assert.*;

 public class ArraListTests {

    @Test
    public void testAddAndGet() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(8);

        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(5), list.get(1));
        assertEquals(Integer.valueOf(8), list.get(2));
    }

    @Test
    public void testInsert() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.insert(1, "orange");

        assertEquals("apple", list.get(0));
        assertEquals("orange", list.get(1));
        assertEquals("banana", list.get(2));
    }

    @Test
    public void testRemove() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(8);

        list.remove(Integer.valueOf(5));

        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(8), list.get(1));
        assertEquals(2, list.size); // Исправлено на поле size
    }

    @Test
    public void testClear() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        list.clear();

        assertEquals(0, list.size());
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
    }
}
