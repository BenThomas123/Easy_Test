/**
 * 
 * @author Benjamin Thomas
 * @version 1.0
 * @param <T>
 * 
 * This class implements a linked list in Easy test
 */

public class LinkedList<T> {

    /**
     * 
     * @param <V> allows for any type of data
     * 
     * this class is an inner class for nodes
     */
    public class ListNode<V> {

        // next pointer
        private ListNode<V> next;

        // data variable
        private V data;
    
        /**
         * Constructor with data initialization.
         * @param data the passed data
         */
        public ListNode(V data) {
            this.data = data;
            this.next = null;
        }
    
        /**
         * Default constructor.
         */
        public ListNode() {
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
        public ListNode<V> getNext() {
            return next;
        }
    
        /**
         * Sets the next node of this node.
         * @param next the node to set as next
         */
        public void setNext(ListNode<V> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof ListNode) {
                ListNode<V> node = (ListNode) o;
                return node.getNext().equals(next)
                    && node.getData().equals(getData());
            }
            return false;
        }
    }

    private ListNode<T> headNode;
    private ListNode<T> tailNode;
    private int size;

    /**
     * 
     * @constructor for linked list class
     */
    public LinkedList() {
        size = 0;
        this.headNode = null;
        this.tailNode = null;
    }

    /**
     * 
     * @param n the node to look for
     * @return the index of the node
     */
    public int index(ListNode<T> n) {
        int index = 0;

        ListNode<T> current = headNode;

        do {
            if (n.getData().equals(current.getData())) {
                return index;
            }
            index += 1;
            current = current.next;
        } while (current != null);

        return index;
    }

    /**
     * 
     * @param data the data of the new head
     * method adds a head to the node by value
     */
    public void addHead(T data) {
        size++;
        if (headNode == null) {
            headNode = new ListNode<T>(data);
            tailNode = headNode;
        } else {
            ListNode<T> temp = headNode;
            ListNode<T> newNode = new ListNode<T>(data);
            newNode.next = temp;
            headNode = newNode;
        }
    }

    /**
     * 
     * @param node add by nodes
     * this method adds a node to the head of the list
     */
    public void addHead(ListNode<T> node) {
        size++;
        if (headNode == null) {
            headNode = node;
            tailNode = headNode;
        } else {
            ListNode<T> temp = headNode;
            ListNode<T> newNode = node;
            newNode.next = temp;
            headNode = newNode;
        }
    }

    /**
     * 
     * @param data the data in the node
     * adds a value in a node to the lsit
     */
    public void addTail(T data) {
        size++;
        if (tailNode == null) {

            // set the head and tail 
            // node to the passed data
            headNode = new ListNode<T>(data);
            tailNode = headNode;

        } else {

            // add the data to the end of the list
            tailNode.next = new ListNode<T>(data);
            tailNode = tailNode.next;

        }
    }

    /**
     * 
     * @param node the node to add
     * adds a node to the list
     */
    public void addTail(ListNode<T> node) {
        size++;
        if (tailNode == null) {

            // set the head and tail 
            // node to the passed node
            headNode = node;
            tailNode = headNode;
        } else {

            // add the node after the tail node
            tailNode.next = node;

            //update
            tailNode = tailNode.next;

        }
    }

    /**
     * 
     * @param data the data to add to the list
     * this is the default add method
     * adds the passed data to the end of the list
     */
    public void add(T data) {
        size++;
        addTail(data);
    }

    /**
     * 
     * @param node the node to add
     * adds the passed node to the end of the list
     */
    public void add(ListNode<T> node) {
        size++;
        addTail(node);
    }

    /**
     * 
     * @param index the index of where to insert into the list
     * @param node the node you want to add
     * 
     * this method
     */
    public void add(int index, ListNode<T> node) {

        // initalize traversal node
        ListNode<T> current = headNode;

        // handle edge cases

        // front of the list
        if (index == 0) {
            addHead(node);
            size++;
            return;

        // end of the list
        } else if (size + 1 == index) {
            addTail(node);
            size++;
            return;
        }

        // throws an exception if a faulty index is given
        if (size < 0 || size <= index) {
            throw new IndexOutOfBoundsException("Must pass an index in range");
        }

        // the index to that we use during traversal
        int countingIndex = 0;
        do {

            // insert the node into the list
            if (countingIndex + 1 == index) {
                ListNode<T> newNode = node;
                ListNode<T> afterNode = node;
                newNode.next = afterNode;
                current.next = newNode;
            }

            // update
            countingIndex++;
            current = current.next;
        } while (current != null);

        // increment the size
        size += 1;
    }
    
    /**
     * 
     * @param index the index to insert into
     * @param value the value you are adding
     * 
     * adds a value to the linked list
     */
    public void add(int index, T value) {
        ListNode<T> current = headNode;
        ListNode<T> node = new ListNode<T>(value);

        // handle edge cases

        // front of the list
        if (index == 0) {
            addHead(node);
            size++;
            return;

        // end of the list
        } else if (size + 1 == index) {
            addTail(node);
            size++;
            return;
        }

        // the index to that we use during traversal
        int countingIndex = 0;
        do {

            // insert the node into the list
            if (countingIndex + 1 == index) {
                ListNode<T> newNode = node;
                ListNode<T> after = node;
                newNode.next = after;
                current.next = newNode;
            }

            // update
            countingIndex++;
            current = current.next;
        } while (current != null);

        // increment the size
        size += 1;
    }
}