package ca.ciccc;

import java.util.LinkedList;

public class DLPriorityQueue implements VCPriorityQueue<Integer, String>{
  private final LinkedList<Entry<Integer, String>> queue;

  public DLPriorityQueue(){
    this.queue = new LinkedList<>();
  }

  @Override
  public int size() {
    return queue.size();
  }

  @Override
  public boolean isEmpty() {
    return size()==0;
  }

  @Override
  public Entry<Integer, String> enqueue(Integer key, String value) throws IllegalArgumentException {
    Entry<Integer, String> newEntry = new Entry<>(key, value);

    for(int i=0; i<queue.size(); i++){
      int currPriority = queue.get(i).getKey();
      // if new Entry priority is higher than any existing entry
      if(key < currPriority){
        queue.add(i, newEntry);
        return newEntry;
      }
    }

    // if new Entry priority is lower than existing entries
    queue.addLast(newEntry);
    return newEntry;
  }

  @Override
  public Entry<Integer, String> peek() {
    return queue.peek();
  }

  @Override
  public Entry<Integer, String> dequeueMin() {
    return queue.poll();
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
