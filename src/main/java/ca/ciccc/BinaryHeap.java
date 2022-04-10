package ca.ciccc;
// reference
// [1] https://www.geeksforgeeks.org/priority-queue-using-binary-heap/

public class BinaryHeap{

  private static final int ARRAY_SIZE = 100;

  private final Entry<Integer, String>[] heap;
  private int size;

  public BinaryHeap(){
    this.heap = new Entry[ARRAY_SIZE];
    this.size = -1;
  }

  public Entry<Integer, String>[] getHeap(){
    return heap;
  }

  public int getSize() {
    return size;
  }

  public int parent(int i) {
    return (i - 1) / 2;
  }

  public int leftChild(int i) {
    return ((2 * i) + 1);
  }

  public int rightChild(int i) {
    return ((2 * i) + 2);
  }

  public void shiftUp(int i) {
    while (i > 0 && heap[parent(i)].getKey() > heap[i].getKey()) {
      swap(parent(i), i);
      i = parent(i);
    }
  }

  public void insert(Entry<Integer,String> e) {
    size = size + 1;
    heap[size] = e;
    shiftUp(size);
  }

  public void shiftDown(int i) {
    int maxIndex = i;

    int l = leftChild(i);
    if (l <= size && heap[l].getKey() < heap[maxIndex].getKey()) {
      maxIndex = l;
    }

    int r = rightChild(i);
    if (r <= size && heap[r].getKey() < heap[maxIndex].getKey()) {
      maxIndex = r;
    }

    if (i != maxIndex){
      swap(i, maxIndex);
      shiftDown(maxIndex);
    }
  }

  public Entry<Integer, String>  extractMax() {
    Entry<Integer, String> result = heap[0];

    heap[0] = heap[size];
    size = size - 1;

    shiftDown(0);
    return result;
  }

  public Entry<Integer, String> getMax() {
    return heap[0];
  }

  public void swap(int i, int j) {
    Entry<Integer, String> temp= heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }
}
