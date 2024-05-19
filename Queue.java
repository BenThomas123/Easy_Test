public class Queue<T> {
    
    public class QueueNode<V> {
        
        // next pointer
        private QueueNode<V> next;

        // data variable
        private V data;

        /**
         * Constructor with data initialization.
         * @param data the passed data
         */
        public QueueNode(V data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Default constructor.
         */
        public QueueNode() {
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
        public QueueNode<V> getNext() {
            return next;
        }

        /**
         * Sets the next node of this node.
         * @param next the node to set as next
         */
        public void setNext(QueueNode<V> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof QueueNode) {
                QueueNode<V> node = (QueueNode<V>) o;
                return node.getNext().equals(next)
                    && node.getData().equals(getData());
            }
            return false;
        }
    }

    private QueueNode<T> headNode;
    private QueueNode<T> tailNode;
    private int size;

    public Queue() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    public Queue(QueueNode<T> node) {
        this.headNode = node;
        this.tailNode = node;
        this.size = 1;
    }

    public void enqueue(QueueNode<T> node){
        if (tailNode != null) {
            tailNode.setNext(node);
        }
        tailNode = node;
        if (headNode == null) {
            headNode = node;
        }
        size++;
    }

    public void enqueue(T value){
        QueueNode<T> node = new QueueNode<T>(value);
        enqueue(node);
    }

    public T dequeue() {
        if (headNode == null) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = headNode.getData();
        headNode = headNode.getNext();
        if (headNode == null) {
            tailNode = null;
        }
        size--;
        return value;
    }

    public T peek() {
        if (headNode == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return headNode.getData();
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        headNode = null;
        tailNode = null;
        size = 0;
    }
}