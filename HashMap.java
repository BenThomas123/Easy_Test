import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class HashMap<T> {

    public class EntryNode<K, V> {
        private K key;
        private V value;
        private EntryNode<K, V> next;

        public EntryNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public EntryNode() {
            this.key = null;
            this.value = null;
            this.next = null;
        }

        // Accessors (Getters)
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public EntryNode<K, V> getNext() {
            return next;
        }

        // Mutators (Setters)
        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(EntryNode<K, V> nextEntry) {
            this.next = nextEntry;
        }
    }

    private EntryNode<T, T>[] table;
    private int capacity = 16; // Default capacity
    private int size = 0;
    private final float loadFactorThreshold = 0.75f;

    @SuppressWarnings("unchecked")
    public HashMap() {
        table = new EntryNode[capacity];
    }

    private int hash(T key) {
        return key == null ? 0 : Math.abs(key.hashCode() % capacity);
    }

    public void put(T key, T value) {
        if (getLoadFactor() > loadFactorThreshold) {
            resize();
        }

        int hash = hash(key);
        EntryNode<T, T> newNode = new EntryNode<>(key, value);

        if (table[hash] == null) {
            table[hash] = newNode;
        } else {
            EntryNode<T, T> current = table[hash];
            while (current.getNext() != null && !current.getKey().equals(key)) {
                current = current.getNext();
            }
            if (current.getKey().equals(key)) {
                current.setValue(value);
            } else {
                current.setNext(newNode);
            }
        }
        size++;
    }

    public T get(T key) {
        int hash = hash(key);
        EntryNode<T, T> current = table[hash];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public T remove(T key) {
        int hash = hash(key);
        EntryNode<T, T> current = table[hash];
        EntryNode<T, T> previous = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    table[hash] = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return current.getValue();
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

    public boolean containsKey(T key) {
        return get(key) != null;
    }

    public boolean containsValue(T value) {
        for (EntryNode<T, T> entryNode : table) {
            while (entryNode != null) {
                if (entryNode.getValue().equals(value)) {
                    return true;
                }
                entryNode = entryNode.getNext();
            }
        }
        return false;
    }

    public void clear() {
        table = new EntryNode[capacity];
        size = 0;
    }

    public Set<T> keySet() {
        Set<T> keys = new HashSet<>();
        for (EntryNode<T, T> entryNode : table) {
            while (entryNode != null) {
                keys.add(entryNode.getKey());
                entryNode = entryNode.getNext();
            }
        }
        return keys;
    }

    public List<T> valueList() {
        List<T> values = new ArrayList<>();
        for (EntryNode<T, T> entryNode : table) {
            while (entryNode != null) {
                values.add(entryNode.getValue());
                entryNode = entryNode.getNext();
            }
        }
        return values;
    }

    public Object[] keys() {
        Object[] keys = new Object[size];
        int index = 0;

        for (EntryNode<T, T> entryNode : table) {
            while (entryNode != null) {
                keys[index] = entryNode.getKey();
                index++;
                entryNode = entryNode.getNext();
            }
        }

        return keys;
    }

    public Object[] values() {
        Object[] values = new Object[size];
        int index = 0;

        for (EntryNode<T, T> entryNode : table) {
            while (entryNode != null) {
                values[index] = entryNode.getValue();
                index++;
                entryNode = entryNode.getNext();
            }
        }

        return values;
    }

    public float getLoadFactor() {
        return (float) size / capacity;
    }

    private void resize() {
        capacity *= 2;
        @SuppressWarnings("unchecked")
        EntryNode<T, T>[] newTable = new EntryNode[capacity];
        for (EntryNode<T, T> entryNode : table) {
            while (entryNode != null) {
                int hash = hash(entryNode.getKey());
                if (newTable[hash] == null) {
                    newTable[hash] = new EntryNode<>(entryNode.getKey(), entryNode.getValue());
                } else {
                    EntryNode<T, T> current = newTable[hash];
                    while (current.getNext() != null) {
                        current = current.getNext();
                    }
                    current.setNext(new EntryNode<>(entryNode.getKey(), entryNode.getValue()));
                }
                entryNode = entryNode.getNext();
            }
        }
        table = newTable;
    }

    public Set<EntryNode<T, T>> entrySet() {
        Set<EntryNode<T, T>> entrySet = new HashSet<>();
        for (EntryNode<T, T> entryNode : table) {
            while (entryNode != null) {
                entrySet.add(entryNode);
                entryNode = entryNode.getNext();
            }
        }
        return entrySet;
    }

    public void forEach(BiConsumer<T, T> action) {
        for (EntryNode<T, T> entryNode : table) {
            while (entryNode != null) {
                action.accept(entryNode.getKey(), entryNode.getValue());
                entryNode = entryNode.getNext();
            }
        }
    }
}