package Heap.FindMedianfromDataStream_295_Steven;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianfromDataStream_295_Steven {
  PriorityQueue<Integer> minQ = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<Integer> maxQ = new PriorityQueue<>();
  boolean even = true;

  public FindMedianfromDataStream_295_Steven() {
  }

  public void addNum(int num) {
    return;
  }

  public double findMedian() {
    return 0;
  }

  public static void main(String[] args) {
    char[] commands = new char[] { 'a', 'a', 'f', 'a', 'f', 'a', 'f' };
    int size = commands.length;

    FindMedianfromDataStream_295_Steven medianFinder = new FindMedianfromDataStream_295_Steven();

    Queue<Integer> queue = new LinkedList<>();
    queue.add(3);
    queue.add(1);
    queue.add(2);
    queue.add(3);

    for (int i = 0; i < size; i++) {
      if (commands[i] == 'f') {
        System.out.println(medianFinder.findMedian());
      } else if (commands[i] == 'a') {
        int val = queue.poll();
        medianFinder.addNum(val);
      }
    }
  }

}
