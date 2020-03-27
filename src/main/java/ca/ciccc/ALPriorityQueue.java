package ca.ciccc;

import java.util.ArrayList;
import java.util.List;

public class ALPriorityQueue<K extends Comparable, V> implements VCPriorityQueue<K, V>{
    private List<Entry<K, V>> queue;

    public ALPriorityQueue(){
        queue = new ArrayList<>();
    }



    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
        Entry<K, V> newEntry = new Entry<>(key, value);
        queue.add(newEntry);
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        if (isEmpty()){
            return null;
        }
        Entry<K, V> min = queue.get(0);
        for (Entry<K, V>  entry: queue){
            if (entry.getKey().compareTo(min.getKey()) < 0){
                min = entry;
            }
        }
        return min;
    }

    @Override
    public Entry<K, V> dequeueMin() {
        if (isEmpty()){
            return null;
        }
        int minindex = 0;
        for (int i = 1; i < queue.size(); i ++){
            if (queue.get(i).getKey().compareTo(queue.get(minindex).getKey())< 0)
                minindex = i;
        }
        return queue.remove(minindex);
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        queue.addAll(((ALPriorityQueue<K,V>)other).queue);
        return this;
    }
}

