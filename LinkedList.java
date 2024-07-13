import javax.print.attribute.standard.RequestingUserName;

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
     * @param node the node passed
     * the constructor for just one node
     */
    public LinkedList(ListNode<T> node) {
        size = 1;
        this.headNode = node;
        this.tailNode = headNode;
    }

    /**
     * Returns the index of the specified node within the linked list.
     *
     * @param n the node to look for
     * @return the index of the node if it exists in the list, or -1 if the node is not found.
     */
    public int indexOf(ListNode<T> n) {
        int index = 0; // Initialize an index counter to 0.

        ListNode<T> current = headNode; // Start from the head of the list.

        do {
            // Check if the data of the current node matches the data of the node n.
            if (n.getData().equals(current.getData())) {
                return index; // Return the current index if a match is found.
            }
            index += 1; // Increment the index counter.
            current = current.next; // Move to the next node in the list.
        } while (current != null); // Continue until the end of the list is reached.

        return -1; // Return -1 if no match was found (the node n is not in the list).
    }

    /**
     * Retrieves the node at a specified index in the linked list.
     *
     * @param index the index of the node to retrieve
     * @return the node at the specified index or null if the index is out of bounds.
     */
    public T get(int index) {
        ListNode<T> current = headNode; // Start from the head of the list.

        do {
            // Check if the current node is at the desired index.
            if (indexOf(current) == index) {
                return current.getData(); // Return the current node if it is at the specified index.
            }
            current = current.next; // Move to the next node.
        } while (current != null); // Continue until the end of the list is reached.

        return null; // Return null if the index is out of bounds (no node found at the specified index).
    }

    /**
     * 
     * @param node the node to search for
     * @return if the node was found
     * 
     * searches for the node
     */
    public boolean contains(ListNode<T> node) {
        return indexOf(node) != -1;
    }

    /**
     * 
     * @param data the data you to search for
     * @return if the data was found
     * 
     * searches for the data
     */
    public boolean contains(T data) {
        return indexOf(new ListNode<T>(data)) != -1;
    }

    /**
     * 
     * @return if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 
     * clears the linked lis
     */
    public void clear() {
        headNode = null;
        tailNode = null;
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

    public boolean remove(ListNode<T> nodeToRemove) {
        if (headNode == null) { // If the list is empty
            return false;
        }
        if (nodeToRemove.equals(headNode)) { // If the node to remove is the head
            headNode = headNode.getNext(); // Move head to the next node
            if (headNode == null) { // If the list becomes empty
                tailNode = null;
            }
            size--; // Decrement size
            return true;
        }
    
        ListNode<T> current = headNode;
        while (current.getNext() != null) { // Traverse the list to find the node
            if (current.getNext().equals(nodeToRemove)) {
                if (nodeToRemove.equals(tailNode)) { // If the node to remove is the tail
                    tailNode = current; // Update tail
                }
                current.setNext(current.getNext().getNext()); // Bypass the node to remove
                size--; // Decrement size
                return true;
            }
            current = current.getNext();
        }
        return false; // Return false if the node was not found
    }

    public boolean remove(T data) {
        ListNode<T> nodeToRemove = new ListNode<T>(data);
        if (headNode == null) { // If the list is empty
            return false;
        }
        if (nodeToRemove.equals(headNode)) { // If the node to remove is the head
            headNode = headNode.getNext(); // Move head to the next node
            if (headNode == null) { // If the list becomes empty
                tailNode = null;
            }
            size--; // Decrement size
            return true;
        }
    
        ListNode<T> current = headNode;
        while (current.getNext() != null) { // Traverse the list to find the node
            if (current.getNext().equals(nodeToRemove)) {
                if (nodeToRemove.equals(tailNode)) { // If the node to remove is the tail
                    tailNode = current; // Update tail
                }
                current.setNext(current.getNext().getNext()); // Bypass the node to remove
                size--; // Decrement size
                return true;
            }
            current = current.getNext();
        }
        return false; // Return false if the node was not found
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ListNode<T> removedNode = null;
        if (index == 0) {
            removedNode = headNode;
            headNode = headNode.getNext();
            if (size == 1) {
                tailNode = null;
            }
        } else {
            ListNode<T> current = headNode;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removedNode = current.getNext();
            current.setNext(removedNode.getNext());
            if (removedNode.getNext() == null) {
                tailNode = current;
            }
        }
        size--;
        return removedNode.getData();
    }
    
    /**
     * 
     * this reverses the linked list
     */
    public void reverse() {

        // If the list is empty or has only one node, no need to reverse
        if (headNode == null || headNode.getNext() == null) {
            return;
        }
    
        // Initialize three pointers for the reversal process
        ListNode<T> previous = null;
        ListNode<T> current = headNode;
        ListNode<T> next = null;
    
        // Update the tail node to be the current head before the reversal
        tailNode = headNode;
    
        // Traverse through the list and reverse the links
        while (current != null) {
            next = current.getNext(); // Temporarily store the next node
            current.setNext(previous); // Reverse the current node's pointer
            previous = current; // Move the previous pointer one step forward
            current = next; // Move to the next node in the original list
        }
    
        // After the loop, previous will be pointing to the new head of the reversed list
        headNode = previous;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListNode<T> current = headNode;
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

    public int getSize() {
        return size;
    }

}