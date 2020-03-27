package ca.ciccc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ALPriorityQueueTest {

    ALPriorityQueue queue;

    @Test
    public void size() {
        assertEquals(0, queue.size());
        queue.enqueue(3, "three");
        queue.enqueue(1, "one");
        queue.enqueue(2, "two");
        assertEquals(3, queue.size());
        queue.peek();
        assertEquals(3, queue.size());
        queue.dequeueMin();
        assertEquals(2, queue.size());
        queue.dequeueMin();
        assertEquals(1, queue.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(3, "three");
        assertFalse(queue.isEmpty());
        queue.dequeueMin();
        assertTrue(queue.isEmpty());
        queue.enqueue(1, "one");
        assertFalse(queue.isEmpty());
        queue.peek();
        assertFalse(queue.isEmpty());
        queue.dequeueMin();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueue() {
        Integer key = 1;
        String value = "one";
        Entry entry = queue.enqueue(key, value);
        assertEquals(key, entry.key);
        assertEquals(value, entry.value);
    }

    @Test
    public void peek() {
        queue.enqueue(3, "three");
        Entry expected = queue.enqueue(1, "one");
        queue.enqueue(2, "two");
        Entry result = queue.peek();
        assertEquals(expected.key, result.key);
        assertEquals(expected.value, result.value);
        result = queue.peek();
        assertEquals(expected.key, result.key);
        assertEquals(expected.value, result.value);
    }

    @Test
    public void dequeueMin() {
        queue.enqueue(3, "three");
        Entry expected = queue.enqueue(1, "one");
        Entry expected2 = queue.enqueue(2, "two");
        Entry result = queue.dequeueMin();
        assertEquals(expected.key, result.key);
        assertEquals(expected.value, result.value);
        result = queue.dequeueMin();
        expected = expected2;
        assertEquals(expected.key, result.key);
        assertEquals(expected.value, result.value);
    }

    @Test
    public void merge() {

    }
}