import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import static java.util.Objects.hash;

public class HashTable<K, V> {
    private int size = 0;


    class Entry{
        private K key;
        private Product value;
        public Entry(K key, Product value){
            this.key = key;
            this.value = (Product) value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(Product value){
            this.value = (Product) value;
        }
    }
    LinkedList<Entry>[] table;

    public HashTable(){
        table = new LinkedList[10];
        //Arrays.fill(table, null);
    }

    public void put(K key, V value){
        int index = hash(key) % 10;
        if (table[index] == null){
            table[index] = new LinkedList<>();
        }
        for (Entry entry : table[index]){
            if (entry.getKey().equals(key)){
                entry.setValue((Product) value);
                return;
            }
        }
        table[index].add(new Entry(key, (Product) value));
        System.out.println(Arrays.toString(table));
        this.size++;
    }

    public String get(K key) {
        int index = hash(key) % 10;
        LinkedList<Entry> list = table[index];
        int i = 0;
        while (list != null && i < list.size()) {
            if (list.get(i).getKey().equals(key)) {
                String n = "Наименование: " + list.get(i).value.getName() +
                        " | Описание: " + list.get(i).value.getDescription() +
                        " | Цена: " + list.get(i).value.getPrice() + "р." +
                        " | Количество на складе: " + list.get(i).value.getQuantity();
                return n;
            }
        i++;
        }
        return null;
    }

    public void remove(K key){
        if (get(key) != null){
            int index = hash(key) % 10;
            LinkedList<Entry> list = table[index];
            int i = 0;
            while (i < list.size() && list.get(i) != null){
                if (list.get(i).getKey().equals(key))
                    list.remove(i);
            i++;
            }
            this.size--;
        }
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }
}
