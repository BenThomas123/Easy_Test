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

        // previous pointer
        private ListNode<V> previous;

        // data variable
        private V data;
    
        /**
         * Constructor with data initialization.
         * @param data the passed data
         */
        public ListNode(V data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    
        /**
         * Default constructor.
         */
        public ListNode() {
            this.data = null;
            this.next = null;
            this.previous = null;
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
    
        /**
         * Returns the previous node.
         * @return the previous node.
         */
        public ListNode<V> getPrevious() {
            return previous;
        }
    
        /**
         * Sets the previous node of this node.
         * @param previous the node to set as previous
         */
        public void setPrevious(ListNode<V> previous) {
            this.previous = previous;
        }
    }

    ListNode<T> headNode;
    ListNode<T> tailNode;
}