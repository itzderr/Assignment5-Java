package ca.ciccc;

import java.util.ArrayList;

public class ALPriorityQueue implements VCPriorityQueue<Integer, String>{
  private final ArrayList<Entry<Integer, String>> queue;

  public ALPriorityQueue(){
    this.queue = new ArrayList<>();
  }

  public ArrayList<Entry<Integer, String>> getQueue() {
    return queue;
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
  public Entry<Integer, String> enqueue(Integer key, String value)
      throws IllegalArgumentException {
    Entry<Integer,String> newEntry = new Entry<>(key, value);
    queue.add(queue.size(), newEntry);
    return newEntry;
  }

  @Override
  public Entry<Integer,String> peek() {
    Entry<Integer, String> maxPriorityEntry = queue.get(0);
    for(int i=1; i<size(); i++){
      if(queue.get(i).getKey() < maxPriorityEntry.getKey()){
        maxPriorityEntry = queue.get(i);
      }
    }
    return maxPriorityEntry;
  }

  @Override
  public Entry<Integer,String> dequeueMin() {
    Entry<Integer, String> maxPriorityEntry = queue.get(0);
    int index = 0;
    for(int i=1; i<size(); i++){
      if(queue.get(i).getKey() < maxPriorityEntry.getKey()){
        maxPriorityEntry = queue.get(i);
        index = i;
      }
    }
    return queue.remove(index);
  }

  @Override
  public VCPriorityQueue<Integer, String> merge(VCPriorityQueue<Integer, String> other) {
    while(!other.isEmpty()){
      queue.add(other.dequeueMin());
    }
    return this;
  }
}
