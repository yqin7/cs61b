package hashmap;

import edu.princeton.cs.algs4.SET;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {
    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private HashSet<K> keys;
    // You should probably define some more!
    private int size;
    private double loadFactor;
    private double maxLoad;

    /** Constructors */
    public MyHashMap() {
        this(16, 0.75);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, 0.75);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        buckets = new Collection[initialSize];
        this.maxLoad = maxLoad;
        this.size = 0;
        this.keys = new HashSet<>();
        initializeBuckets(buckets);
    }

    private void initializeBuckets(Collection<Node>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = createBucket();
        }
    }



    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        Node newNode =  new Node(key, value);
        return newNode;
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        return null;
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!

    @Override
    public void clear() {
        initializeBuckets(buckets);
        keys = new HashSet<>();
        loadFactor = 0;
        size = 0;
    }

    private Node getNode(K key) {
        int keyHashCode = key.hashCode();
        int bucketIndex = Math.floorMod(keyHashCode, buckets.length);
            for (Node node : buckets[bucketIndex]) {
                if (node.key.equals(key)) {
                    return node;
                }
            }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        Node node= getNode(key);
        return !(node == null);
    }

    @Override
    public V get(K key) {
        if (containsKey(key)) {
            return getNode(key).value;
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        putHelper(key, value, buckets.length, this);
        if (loadFactor >= maxLoad) {
            resize(buckets.length * 2);
        }
    }

    private void resize(int length) {
        Collection[] newBuckets = new Collection[length];
        initializeBuckets(newBuckets);
        for (K key : keys) {
            int keyHashCode = key.hashCode();
            int bucketIndex = Math.floorMod(keyHashCode, newBuckets.length);
            newBuckets[bucketIndex].add(createNode(key, get(key)));
        }
        loadFactor = size / newBuckets.length;
        buckets = newBuckets;
    }

    private void putHelper(K key, V value, int bucketsLength, MyHashMap<K, V> hashMap) {
        Node node = hashMap.getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            int keyHashCode = key.hashCode();
            int bucketIndex = Math.floorMod(keyHashCode, bucketsLength);
            hashMap.buckets[bucketIndex].add(createNode(key, value));
            hashMap.keys.add(key);
            hashMap.size += 1;
            hashMap.loadFactor = (double) hashMap.size / bucketsLength;
        }
    }


    @Override
    public Set<K> keySet() {
        return keys;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

}
