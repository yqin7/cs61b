package bstmap;
import java.util.*;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;
    private int size = 0;
    private class Node {
        public final K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    public BSTMap() {
    }


    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }

    private boolean containsKey(Node node, K key) {
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return containsKey(node.right, key);
        } else if (cmp < 0) {
            return containsKey(node.left, key);
        }
        return true;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        } else if (cmp < 0) {
            return get(node.left, key);
        }
        return node.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size = size + 1;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value; // Update the value if the key already exists
        }
        return node;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    public V remove(K key) {
        return null;
    }

    public V remove(K key, V value) {
        return null;
    }


    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);  // Traverse left subtree
        System.out.println(node.key + " : " + node.value);  // Print the current node
        printInOrder(node.right); // Traverse right subtree
    }

//    public static void main(String[] args) {
//        BSTMap<String, Integer> bstMap = new BSTMap<>();
//
//        // 1. 添加元素
//        bstMap.put("D", 4);
//        bstMap.put("B", 2);
//        bstMap.put("A", 1);
//        bstMap.put("C", 3);
//        bstMap.put("F", 6);
//        bstMap.put("E", 5);
//        bstMap.put("G", 7);
//
//        // 2. 打印整个 BSTMap
//        System.out.println("Printing BSTMap in order:");
//        bstMap.printInOrder();
//
//        // 3. 使用 `get` 方法检查某些键
//        System.out.println("\nValue for D: " + bstMap.get("D")); // Should print 4
//        System.out.println("Value for A: " + bstMap.get("A")); // Should print 1
//
//        // 4. 使用 `containsKey` 方法检查某些键
//        System.out.println("\nContains key B: " + bstMap.containsKey("B")); // Should print true
//        System.out.println("Contains key Z: " + bstMap.containsKey("Z")); // Should print false
//    }



}
