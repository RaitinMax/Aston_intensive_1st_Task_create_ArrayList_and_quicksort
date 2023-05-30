import java.util.Arrays;

public class ArrayList<T> //дженерик (<T>) для обеспечения параметризации типа элементов, которые могут храниться в списке
{
    public int size;// хранит текущее количество элементов в списке. В реализации ArrayList она указывает на количество фактически добавленных элементов в массив данных.*/
    //Обычный ArrayList хранит объекты класса Object, поэтому необходимо создать поле Object*/
    private Object[] data; //массив для хранения элементов
    private static final int DEFAULT_CAPACITY = 10;/** Начальная емкость списка по умолчанию*/


    public ArrayList() {
        // Создаем массив для хранения элементов списка (массив с начальной емкостью)
        data = new Object[DEFAULT_CAPACITY];
        // Изначально размер списка равен 0
        size = 0;
    }

    /**метод add(...) для добавления элемента в конец коллекции
    //Когда вызывается метод add(T element), элемент element добавляется в конец массива data.
    // Если текущий размер списка (size) равен емкости массива data.length, то это означает, что массив заполнен, и его емкость нужно увеличить.
    // В этом случае вызывается метод increaseCapacity(), который увеличивает емкость массива data в два раза, создает новый массив с увеличенной емкостью и копирует все элементы из старого массива в новый.
    // Затем элемент element добавляется в конец нового массива.
    //В результате, метод add(T element) позволяет динамически расширять список и добавлять новые элементы в конец коллекции без необходимости заботиться о управлении памятью или размере массива.*/
    public void add(T element) {
        // Если массив полностью заполнен, увеличиваем его размер
        if (size == data.length) {
            increaseCapacity();
        }
        // Добавляем элемент в конец списка
        data[size] = element;
        // Увеличиваем размер списка на 1
        size++;
    }

    /** метод insert(...) используется для вставки элемента element по указанному индексу index в список.*/
    public void insert(int index, T element) {
        // Проверяем, что индекс находится в допустимом диапазоне
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == data.length) {
            // Если массив полностью заполнен, увеличиваем его размер
            increaseCapacity();
        }

        /** Сдвигаем элементы справа от индекса (data - исходный массив, index - индекс, начиная с которого будут копированы элементы data - массив-значение, в который будут скопированы элементы, index+1 - индекс, начиная с которого будут размещены скорпированные элементы, size-index количество элементов которые нужно скопировать
        //Таким образом, строка System.arraycopy(.....) сдвигает элементы массива на одну позицию вправо, создавая свободное место для вставки нового элемента.*/
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /** public T get(int index) используется для получения элемента списка по указанному индексу index.
    //метод позволяет получить элемент списка по его индексу для дальнейшего использования или просто чтения значений элементов списка.*/
    public T get(int index) {
        // Проверка на корректность индекса
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Возвращаем элемент по указанному индексу
        return (T) data[index];
    }

    /** remove(...)используется для удаления первого вхождения элемента element из списка.
    // remove(...) удаляет элемент по значению*/
    public void remove(T element) {
        // Находим индекс элемента
        int index = indexOf(element);
        if (index != -1)// если элемент не найден, то
        {
            // Удаляем элемент по индексу
            removeAt(index);
        }
    }

    /**removeAt (...) удаляет элемент из списка по указанному индексу index.
    // Он принимает индекс в качестве параметра и проверяет его на допустимость (должен быть в пределах от 0 до размера списка минус 1).
    // Если индекс допустим, метод сдвигает элементы слева от указанного индекса вправо на одну позицию, чтобы заполнить пустую ячейку.
    // Затем размер списка уменьшается на 1*/
    public void removeAt(int index) {
        // Проверка на корректность индекса
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Сдвигаем элементы слева от индекса
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;  // Уменьшаем размер списка
        data[size] = null; // Очищаем последний элемент
    }


    /** clear() используется для удаления всех элементов из списка и обнуления его размера.*/
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;// Заполняем массив значениями null, тем самым удаляя все ссылки на объекты

        }
        size = 0; // Обнуляем размер списка
    }

    /**sort() используется для сортировки элементов списка в порядке возрастания (по умолчанию).
    // Он применяет алгоритм быстрой сортировки (quicksort) для упорядочивания элементов.*/
    public void sort() {
        quicksort(0, size - 1); // Вызываем метод быстрой сортировки
        //В данном случае, low устанавливается равным 0, что является индексом самого левого элемента в массиве данных, а high устанавливается равным size - 1, где size - это текущий размер списка
    }

    /**quicksort(int low, int high) является внутренним рекурсивным методом, который реализует алгоритм быстрой сортировки*/
    private void quicksort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high); // Получаем индекс опорного элемента
            quicksort(low, pivotIndex - 1); // Рекурсивная сортировка для левой части
            quicksort(pivotIndex + 1, high); // Рекурсивная сортировка для правой части
        }
    }

    /**partition(..) используется в алгоритме быстрой сортировки для выполнения разделения списка на две части на основе опорного элемента (пивота).
    //Основное назначение метода partition(...) заключается в том, чтобы разделить список на две части, так чтобы все элементы, находящиеся слева от пивота, были меньше или равны пивоту, а все элементы, находящиеся справа от пивота, были больше пивота.*/
    private int partition(int low, int high) {
        T pivot = get(high); // Опорный элемент (выбираем последний элемент в списке)
        int i = low - 1; //Инициализируем индекс i со значением (low - 1), который будет использоваться для отслеживания текущей позиции для вставки элементов меньших или равных пивоту.

        for (int j = low; j < high; j++)//Происходит итерация по элементам списка от индекса low до high-1.
        // В каждой итерации мы проверяем, нужно ли переместить текущий элемент в левую часть списка.
        {
            if (((Comparable<T>) get(j)).compareTo(pivot) <= 0)//сравниваем текущий элемент списка с пивотом (если результат измерения <=нуля то значит результат измерения меньше или равен пивоту),
            // используя метод compareTo() интерфейса Comparable.
            // Если текущий элемент меньше или равен пивоту, то выполняем действия внутри условия.
            {
                i++;
                swap(i, j);//Если текущий элемент меньше или равен пивоту, то вызываем метод swap(i, j), который меняет местами элементы с позициями i и j.
                // Это позволяет переместить элементы меньше или равные пивоту в левую часть списка.
            }
        }

        swap(i + 1, high); //  После выполнения цикла, все элементы, меньшие или равные пивоту, будут находиться слева от позиции i.
        // Чтобы поместить пивот в правильную позицию, вызываем метод swap(i + 1, high), который меняет местами пивот и элемент с позицией high
        return i + 1; // Возвращаем индекс пивота, который указывает на его новую позицию после разделения списка.
        // Этот индекс будет использоваться для дальнейшего рекурсивного вызова алгоритма быстрой сортировки на подсписках слева и справа от пивота.
    }

    /**метод swap(...) используется для обмена местами двух элементов списка по указанным индексам i и j.*/
    private void swap(int i, int j) {
        T temp = get(i); //  В данной строке сохраняем значение элемента с позицией i во временной переменной temp.
        // Это необходимо, чтобы не потерять значение элемента при его перемещении.
        data[i] = data[j];//Присваиваем элементу с позицией i значение элемента с позицией j.
        // Теперь элемент с позицией i содержит значение элемента, ранее находившегося на позиции j.
        data[j] = temp;//Присваиваем элементу с позицией j сохраненное ранее значение из временной переменной temp.
        // Теперь элемент с позицией j содержит значение элемента, ранее находившегося на позиции i.
    }

    /** используется для увеличения емкости (capacity) внутреннего массива данных, когда количество элементов приближается к пределу текущей емкости.*/
    private void increaseCapacity() {
        int newCapacity = data.length * 2; // Увеличиваем емкость в два раза
        Object[] newData = new Object[newCapacity];// Создаем новый массив с увеличенной емкостью
        for (int i = 0; i < size; i++) {
            newData[i] = data[i]; //в цикле, мы проходим по исходному массиву data и копируем каждый элемент в новый массив newData.
        }
        data = newData;
    }

    /** indexOf(...) используется для поиска индекса первого вхождения указанного элемента в списке.*/
    private int indexOf(T element) {
        for (int i = 0; i < size; i++) { // Поиск индекса элемента
            if (data[i].equals(element)) {//Для каждого элемента в списке вызывается метод equals(), чтобы проверить, равен ли он указанному элементу
                //Если найдено совпадение элементов, возвращается текущий индекс, на котором было найдено совпадение
                return i; // Возвращаем индекс элемента, если он найден
            }
        }
        return -1; // Индекс не найден
    }

    /** для возвращения текущего размера ArrayList'a*/
    public int size() {
        return size;
    }
}
