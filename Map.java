import java.util.*;
public class Map<K, V> {

    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    private Entry<K, V> head;
    private int size;

    public Map() {
        head = null;
        size = 0;
    }

    // Put method with value parameter
    public void put(K key, V value) {
        Entry<K, V> current = head;
        while (current != null) {
            if ((key == null && current.getKey() == null) || (key != null && key.equals(current.getKey()))) {
                current.setValue(value);
                return;
            }
            current = current.getNext();
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.setNext(head);
        head = newEntry;
        size++;
    }

    // Put method without value parameter, defaults value to null
    public void put(K key) {
        put(key, null);
    }

    public V get(K key) {
        Entry<K, V> current = head;
        while (current != null) {
            if ((key == null && current.getKey() == null) || (key != null && key.equals(current.getKey()))) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public K getByValue(V value) {
        Entry<K, V> current = head;
        while (current != null) {
            if ((value == null && current.getValue() == null) || (value != null && value.equals(current.getValue()))) {
                return current.getKey();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean containsKey(K key) {
        Entry<K, V> current = head;
        while (current != null) {
            if ((key == null && current.getKey() == null) || (key != null && key.equals(current.getKey()))) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean containsValue(V value) {
        Entry<K, V> current = head;
        while (current != null) {
            if ((value == null && current.getValue() == null) || (value != null && value.equals(current.getValue()))) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public V remove(K key) {
        Entry<K, V> current = head;
        Entry<K, V> previous = null;

        while (current != null) {
            if ((key == null && current.getKey() == null) || (key != null && key.equals(current.getKey()))) {
                V value = current.getValue();
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return value;
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public ArrayList<K> getKeys() {
        ArrayList<K> keys = new ArrayList<>();
        Entry<K, V> current = head;
        while (current != null) {
            keys.add(current.getKey());
            current = current.getNext();
        }
        return keys;
    }

    public ArrayList<V> getValues() {
        ArrayList<V> values = new ArrayList<>();
        Entry<K, V> current = head;
        while (current != null) {
            values.add(current.getValue());
            current = current.getNext();
        }
        return values;
    }

    public void clear() {
        head = null;
        size = 0;
    }
}
