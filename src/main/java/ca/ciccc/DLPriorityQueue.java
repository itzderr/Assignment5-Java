package ca.ciccc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DLPriorityQueue<K extends Comparable, V > implements VCPriorityQueue<K, V> {

        private List<Entry<K, V>> queue;

        public DLPriorityQueue(){

          // queue = Collections.synchronizedList(new LinkedList<>());

        }


class Dll{
    Node head, tail = null;

    class Node {
        K key;
        V value;
        Node prev;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public void addNode(K key, V value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head = tail = newNode;
            head.prev = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        tail.next = null;

    }
}
Dll dll = new Dll();



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
            Entry<K, V> newEntry = new Entry<>(key, value);
            dll.addNode(key, value);
            return newEntry;
        }


        /**
        --
         */
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
            queue.addAll(((DLPriorityQueue<K,V>)other).queue);
            return this;
        }
    }

