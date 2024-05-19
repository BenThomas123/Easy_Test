import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T>{
    
    public class StackNode<V> {
        
        // next pointer
        private StackNode<V> next;

        // data variable
        private V data;

        /**
         * Constructor with data initialization.
         * @param data the passed data
         */
        public StackNode(V data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Default constructor.
         */
        public StackNode() {
            this.data = null;
            this.next = null;
        }

        /**
         * Returns the data stored in this node.
         * @return the data of this node.
         */
        public V getData() {
            return data;
        }

        /**
         * Sets the data for this node.
         * @param data the data to set
         */
        public void setData(V data) {
            this.data = data;
        }

        /**
         * Returns the next node.
         * @return the next node.
         */
        public StackNode<V> getNext() {
            return next;
        }

        /**
         * Sets the next node of this node.
         * @param next the node to set as next
         */
        public void setNext(StackNode<V> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof StackNode) {
                StackNode<V> node = (StackNode<V>) o;
                return node.getNext().equals(next)
                    && node.getData().equals(getData());
            }
            return false;
        }
    }

    public StackNode<T> top;
    public int size;

    public Stack(){
        top = null;
    }

    public Stack(T value) {
        top = new StackNode<T>(value);
    }


    public StackNode<T> pop() {
        StackNode<T> value = top;
        top = top.next;
        size--;
        return value;
    }

    public void push (T value) {
        StackNode<T> temp = new StackNode<T>(value);
        temp.next = top;
        top = temp;
        size++;
    }

    public void push (StackNode<T> node) {
        StackNode<T> temp = node;
        temp.next = top;
        top = temp;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear() {
        if (top != null) {
            top = null;
            size = 0;
        }
    }

    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }

        return top.getData();
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        StackNode<T> current = top;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private StackNode<T> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}
