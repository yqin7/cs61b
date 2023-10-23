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
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }






}
