package ca.ciccc;

import java.util.ArrayList;
import java.util.List;

public class BHPriorityQueue <K extends Comparable, V> implements VCPriorityQueue {

    private List<Entry<K, V>> queue;

    public BHPriorityQueue() {
        this.queue = new ArrayList<Entry<K, V>>();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Entry enqueue(Comparable key, Object value) throws IllegalArgumentException {
        Entry<K, V> entry = new Entry<K, V>((K)key, (V)value);
        queue.add(entry);
        return entry;
    }

    @Override
    public Entry<K, V> peek() {
        if (!isEmpty()) {
            return this.queue.get(this.size() - 1);
        }
        return null;
    }

    @Override
    public Entry<K, V> dequeueMin() {
        if (!isEmpty()) {
            return this.queue.get(this.size() - 1);
        }
        return null;
    }

    @Override
    public VCPriorityQueue merge(VCPriorityQueue other) {
        for (int i = 0; i < other.size(); i++) {
            Entry entry = other.dequeueMin();
            enqueue(entry.getKey(), entry.getValue());
        }
        return this;
    }
}
