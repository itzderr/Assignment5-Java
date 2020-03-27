package ca.ciccc;

import java.util.List;

public class BHPriorityQueue<K extends Comparable, V >implements VCPriorityQueue<K, V> {
    private List<Entry<K, V>> queue;

    public BHPriorityQueue(){
        
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Entry<K, V> peek() {
        return null;
    }

    @Override
    public Entry<K, V> dequeueMin() {
        return null;
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        return null;
    }
}
