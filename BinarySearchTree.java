import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    // Insert a node into the BST
    public void insert(T data) {
        root = insertRec(root, data);
        size++;
    }

    private Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Search for a node in the BST
    public boolean search(T data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node<T> root, T data) {
        if (root == null) {
            return false;
        }

        if (data.compareTo(root.data) == 0) {
            return true;
        }

        return data.compareTo(root.data) < 0
                ? searchRec(root.left, data)
                : searchRec(root.right, data);
    }

    // Delete a node from the BST
    public void delete(T data) {
        root = deleteRec(root, data);
    }

    private Node<T> deleteRec(Node<T> root, T data) {
        if (root == null) {
            return null;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node to be deleted found

            // Node with only one child or no child
            if (root.left == null) {
                size--;
                return root.right;
            } else if (root.right == null) {
                size--;
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private T minValue(Node<T> root) {
        T minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    private T maxValue(Node<T> root) {
        T maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    // In-order traversal
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node<T> root, List<T> result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.add(root.data);
            inOrderRec(root.right, result);
        }
    }

    // Clear the BST
    public void clear() {
        root = null;
        size = 0;
    }

    // Get the size of the BST
    public int size() {
        return size;
    }
}
