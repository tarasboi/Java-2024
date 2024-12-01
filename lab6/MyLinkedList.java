import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size;

    // Внутрішній клас для вузлів однозв'язного списку
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    // Конструктор 1: порожній список
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Конструктор 2: список із одного об’єкта
    public MyLinkedList(T item) {
        this();
        add(item);
    }

    // Конструктор 3: список із стандартної колекції
    public MyLinkedList(Collection<T> collection) {
        this();
        for (T item : collection) {
            add(item);
        }
    }

    // Додає елемент у кінець списку
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Отримати елемент за індексом
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Видалити елемент за індексом
    public T remove(int index) {
        checkIndex(index);
        if (index == 0) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }

    // Перевіряє розмір списку
    public int size() {
        return size;
    }

    // Очищає список
    public void clear() {
        head = null;
        size = 0;
    }

    // Перевірка наявності елемента у списку
    public boolean contains(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Перевіряє, чи індекс в межах списку
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Реалізація ітератора
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Метод для відображення елементів списку
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(current.next != null ? ", " : "");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Виконавчий метод
    public static void main(String[] args) {
        // Створення списку за допомогою різних конструкторів
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>(42);
        MyLinkedList<Integer> list3 = new MyLinkedList<>(java.util.List.of(1, 2, 3, 4, 5));

        // Додавання елементів
        list1.add(10);
        list1.add(20);
        list1.add(30);

        // Виведення списків
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);

        // Використання методів
        System.out.println("List1 size: " + list1.size());
        System.out.println("List1 contains 20: " + list1.contains(20));
        System.out.println("List3 element at index 2: " + list3.get(2));
        System.out.println("List1 remove index 1: " + list1.remove(1));
        System.out.println("List1 after removal: " + list1);

        // Очищення списку
        list3.clear();
        System.out.println("List3 after clear: " + list3);
    }
}
