package ca.ciccc;

import java.util.List;
import java.util.LinkedList;

public class DLPriorityQueue <K extends Comparable, V> implements VCPriorityQueue {

    private List<Entry<K, V>> queue;

    public DLPriorityQueue() {
        this.queue = new LinkedList<Entry<K, V>>();
    }

    public DLPriorityQueue(List<Entry<K, V>> queue) {
        this.queue = queue;
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
    public Entry<K, V> enqueue(Comparable key, Object value) throws IllegalArgumentException {
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
    public Entry dequeueMin() {
        if (!isEmpty()) {
            return this.queue.get(this.size() - 1);
        }
        return null;
    }

    @Override
    public VCPriorityQueue merge(VCPriorityQueue other) {
        for (int i = 0; i < other.size(); i++ ) {
            Entry entry = other.dequeueMin();
            enqueue(entry.getKey(), entry.getValue());
        }
        return this;
    }
}
