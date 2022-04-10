package ca.ciccc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class BHPriorityQueueTest {

  @Test
  public void size() {
    BHPriorityQueue pq = new BHPriorityQueue();

    assertEquals(0, pq.size());
    pq.enqueue(0,"a");
    assertEquals(1, pq.size());
    pq.enqueue(1,"b");
    assertEquals(2, pq.size());
    pq.enqueue(2,"c");
    assertEquals(3, pq.size());
  }

  @Test
  public void isEmpty() {
    BHPriorityQueue pq = new BHPriorityQueue();

    assertTrue(pq.isEmpty());
    pq.enqueue(0,"a");
    assertFalse(pq.isEmpty());
    pq.dequeueMin();
    assertTrue(pq.isEmpty());
  }

    @Test
  public void peek() {
      BHPriorityQueue pq = new BHPriorityQueue();

      pq.enqueue(0,"a");
      pq.enqueue(1,"b");
      pq.enqueue(2,"c");
      pq.enqueue(5,"d");
      pq.enqueue(4,"e");
      pq.enqueue(3,"f");

      assertEquals("a", pq.peek().getValue());
      pq.dequeueMin();
      assertEquals("b", pq.peek().getValue());
      pq.dequeueMin();
      assertEquals("c", pq.peek().getValue());
      pq.dequeueMin();
      assertEquals("f", pq.peek().getValue());
      pq.dequeueMin();
      assertEquals("e", pq.peek().getValue());
      pq.dequeueMin();
      assertEquals("d", pq.peek().getValue());
      pq.dequeueMin();

  }

  @Test
  public void enqueue() {
    BHPriorityQueue pq = new BHPriorityQueue();

    pq.enqueue(10,"a");
    pq.enqueue(3,"b");
    pq.enqueue(6,"c");
    assertEquals("b", pq.dequeueMin().getValue());
    assertEquals("c", pq.dequeueMin().getValue());
    assertEquals("a", pq.dequeueMin().getValue());
  }

  @Test
  public void dequeueMin() {
    BHPriorityQueue pq = new BHPriorityQueue();

    pq.enqueue(0,"a");
    pq.enqueue(1,"b");
    pq.enqueue(2,"c");

    pq.dequeueMin();
    assertEquals("b", pq.peek().getValue());
    pq.dequeueMin();
    assertEquals("c", pq.peek().getValue());
    pq.dequeueMin();
    assertTrue(pq.isEmpty());
  }

  @Test
  public void merge() {
    BHPriorityQueue pq1 = new BHPriorityQueue();
    BHPriorityQueue pq2 = new BHPriorityQueue();

    pq1.enqueue(0,"a");
    pq1.enqueue(1,"b");
    pq1.enqueue(2,"c");
    pq2.enqueue(1,"d");
    pq2.enqueue(3,"e");
    pq2.enqueue(4,"f");

    pq1.merge(pq2);

    assertEquals(6, pq1.size());
    assertEquals("a", pq1.peek().getValue());
    System.out.println(pq1.dequeueMin().getValue());
    assertEquals("b",  pq1.peek().getValue());
    System.out.println(pq1.dequeueMin().getValue());
    assertEquals("d",  pq1.peek().getValue());
    System.out.println(pq1.dequeueMin().getValue());
    assertEquals("c",  pq1.peek().getValue());
    System.out.println(pq1.dequeueMin().getValue());
    assertEquals("e",  pq1.peek().getValue());
    System.out.println(pq1.dequeueMin().getValue());
    assertEquals("f",  pq1.peek().getValue());
  }
}
