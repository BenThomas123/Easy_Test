/**
 * 
 * @author Benjamin Thomas
 * @version 1.0
 * 
 * This class implements a linked list in Easy test
 */

public class LinkedList {

    /**
     * 
     * @param <T> allows for any type of data
     * 
     * this class is an inner class for nodes
     */
    public class ListNode<T> {

        // next pointer
        private ListNode<T> next;

        // previous pointer
        private ListNode<T> previous;

        // data variable
        private T data;
    
        /**
         * Constructor with data initialization.
         * @param data the passed data
         */
        public ListNode(T data) {
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
        public T getData() {
            return data;
        }
    
        /**
         * Sets the data for this node.
         * @param data the data to set
         */
        public void setData(T data) {
            this.data = data;
        }
    
        /**
         * Returns the next node.
         * @return the next node.
         */
        public ListNode<T> getNext() {
            return next;
        }
    
        /**
         * Sets the next node of this node.
         * @param next the node to set as next
         */
        public void setNext(ListNode<T> next) {
            this.next = next;
        }
    
        /**
         * Returns the previous node.
         * @return the previous node.
         */
        public ListNode<T> getPrevious() {
            return previous;
        }
    
        /**
         * Sets the previous node of this node.
         * @param previous the node to set as previous
         */
        public void setPrevious(ListNode<T> previous) {
            this.previous = previous;
        }
    }
}