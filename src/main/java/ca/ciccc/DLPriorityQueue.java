package ca.ciccc;
import java.util.List;
public abstract class DLPriorityQueue<K extends Comparable, V>  implements VCPriorityQueue {
  private List<Entry<K, V>> entry;
  /**
   * Returns the number of items in the priority queue.
   * @return number of items
   */
  public DLPriorityQueue(List<Entry<K, V>> entry) {
    this.entry = entry;
  }
  @Override
  public int size(){
    return this.entry.size();
  }

  /**
   * Tests whether the priority queue is empty.
   * @return true if the priority queue is empty, false otherwise
   */
  @Override
  public boolean isEmty(){
    if(this.size() == 0) {
      return true;
    }
    return false;
  }

  /**
   * Inserts a key-value pair and returns the entry created.
   * @param key     the key of the new entry
   * @param value   the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  @Override
  public Entry<K,V> enqueue(Comparable key, Object value) throws IllegalArgumentException {
    try{
      Entry<K, V> entry2 = new Entry<K, V>((K)key, (V)value);
      entry.add(entry2);
      return entry2;
    }
    catch(IllegalArgumentException e) {
      throw e;
    }
  }

  /**
   * Returns (but does not remove) an entry with minimal key.
   * @return entry having a minimal key (or null if empty)
   */
  @Override
  Entry<K,V> peek();
    if (this.size() == 0) {
    return null;
  }
    else {
    this.entry.get(this.size() - 1);
  }
  /**
   * Removes and returns an entry with minimal key.
   * @return the removed entry (or null if empty)
   */
  @Override
  public Entry<K,V> dequeueMin() {
    if (this.size() == 0) {
      return null;
    }
    return this.entry.get(this.size() - 1);
  }


  /**
   * Merges another priority queue of the same type.
   * @return the merged priority queue
   * @param other
   */
  @Override
  public VCPriorityQueue<K, V> merge(VCPriorityQueue other) {
    for (int i = 0; i < other.size(); i++ ) {
      Entry entry = other.dequeueMin();
      enqueue(entry.getKey(), entry.getValue());
    }
    return this;
  }
}