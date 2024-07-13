import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private class TreeNode<K, V> {
        private K key;
        private V value;
        private TreeNode<K, V> left;
        private TreeNode<K, V> right;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
        
        public K getKey() {
            return this.key;
        }

        public void setKey (K key) {
            this.key = key;
        }

        public V getValue () {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public TreeNode<K, V> getLeftNode () {
            return this.left;
        }

        public void getLeftNode (TreeNode<K, V> leftNode) {
           this.left = leftNode;
        }

        public TreeNode<K, V> getRightNode () {
            return this.right;
        }

        public void getRightNode (TreeNode<K, V> rightNode) {
           this.right = rightNode;
        }
    }

    private TreeNode<K, V> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    // Insert a key-value pair into the BST
    public void put(K key, V value) {
        root = insertRec(root, key, value);
        size++;
    }

    private TreeNode<K, V> insertRec(TreeNode<K, V> root, K key, V value) {
        if (root == null) {
            root = new TreeNode<>(key, value);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key, value);
        } else {
            root.value = value;
        }

        return root;
    }

    // Search for a value by key in the BST
    public V get(K key) {
        return searchRec(root, key);
    }

    private V searchRec(TreeNode<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.key) == 0) {
            return root.value;
        }

        return key.compareTo(root.key) < 0 ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // In-order traversal
    public List<V> inOrderTraversal() {
        List<V> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(TreeNode<K, V> root, List<V> result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.add(root.value);
            inOrderRec(root.right, result);
        }
    }

    // Get the size of the BST
    public int size() {
        return size;
    }

    // Clear the BST
    public void clear() {
        root = null;
        size = 0;
    }

    // Delete a key-value pair from the BST
    public void delete(K key) {
        root = deleteRec(root, key);
    }

    private TreeNode<K, V> deleteRec(TreeNode<K, V> root, K key) {
        if (root == null) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = findMinKey(root.right);
            root.value = findMinValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private K findMinKey(TreeNode<K, V> root) {
        K minKey = root.key;
        while (root.left != null) {
            root = root.left;
            minKey = root.key;
        }
        return minKey;
    }

    private V findMinValue(TreeNode<K, V> root) {
        V minValue = root.value;
        while (root.left != null) {
            root = root.left;
            minValue = root.value;
        }
        return minValue;
    }
}
