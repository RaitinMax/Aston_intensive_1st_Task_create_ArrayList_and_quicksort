import java.util.Arrays;

public class ArrayList<T> {
    public int size;
    private Object[] data;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size] = element;
        size++;
    }

    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == data.length) {
            increaseCapacity();
        }

        // Сдвигаем элементы справа от индекса
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    public void remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            removeAt(index);
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Сдвигаем элементы слева от индекса
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        data[size] = null; // Очищаем последний элемент
    }

    public void clear() {
        Arrays.fill(data, null);
        size = 0;
    }

    public void sort() {
        quicksort(0, size - 1);
    }

    private void quicksort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quicksort(low, pivotIndex - 1);
            quicksort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (((Comparable<T>) get(j)).compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        T temp = get(i);
        data[i] = data[j];
        data[j] = temp;
    }

    private void increaseCapacity() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    public int size() {
        return size;
    }
}
