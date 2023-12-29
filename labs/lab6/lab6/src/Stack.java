import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] data;
    private int size;

    public Stack(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            int newCapacity = data.length + 1;
            data = Arrays.copyOf(data, newCapacity);
        }
        data[size] = element;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            return "Невозможно удалить элемент так как стек пустой";
        }
        T element = getElementAtTop();
        size--;
        data[size] = null;
        return "Элемент \"" + element + "\" был удален";
    }

    public String peek() {
        if (isEmpty()) {
            return "В стеке нет элементов";
        }
        return "Верхний элемент стека: " + getElementAtTop();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private T getElementAtTop() {
        return (T) data[size - 1];
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(10);

        stack.push("OG");
        stack.push("GOAT");
        stack.push("Friday");
        System.out.println(Arrays.toString(stack.data));

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println("Количество элементов : " + stack.size);
    }
}
