package ca.ciccc;

public class BHPriorityQueue implements VCPriorityQueue<Integer, String>{

  private BinaryHeap queue;

  public BHPriorityQueue() {
    this.queue = new BinaryHeap();
  }

  @Override
  public int size() {
    return queue.getSize()+1;
  }

  @Override
  public boolean isEmpty() {
    return size()==0;
  }

  @Override
  public Entry<Integer, String> enqueue(Integer key, String value) throws IllegalArgumentException {
    Entry<Integer, String> newEntry = new Entry<>(key, value);
    queue.insert(newEntry);
    return newEntry;
  }

  @Override
  public Entry<Integer, String> peek() {
    return queue.getMax();
  }

  @Override
  public Entry<Integer, String> dequeueMin() {
    return queue.extractMax();
  }

  @Override
  public VCPriorityQueue<Integer, String> merge(VCPriorityQueue<Integer, String> other) {
    while(!other.isEmpty()){
      Entry<Integer, String> currEntry = other.dequeueMin();
      enqueue(currEntry.key, currEntry.value);
    }
    return this;
  }
}
