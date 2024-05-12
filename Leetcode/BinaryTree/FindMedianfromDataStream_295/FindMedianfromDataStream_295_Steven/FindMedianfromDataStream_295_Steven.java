package BinaryTree.FindMedianfromDataStream_295_Steven;

import java.util.LinkedList;
import java.util.Queue;

class Node {
  double val;
  int leftCnt = 0, rightCnt = 0;
  Node left, right;

  public Node() {
    this.val = 0;
    this.leftCnt = 0;
    this.rightCnt = 0;
    this.left = null;
    this.right = null;
  }

  public Node(double val) {
    this.val = val;
    this.leftCnt = 0;
    this.rightCnt = 0;
    this.left = null;
    this.right = null;
  }
}

public class FindMedianfromDataStream_295_Steven {
  Node root;

  public FindMedianfromDataStream_295_Steven() {
    this.root = null;
  }

  public void addNum(int num) {
    if (root == null) {
      root = new Node(num);
    } else {
      insertNum(root, num);
    }
  }

  public void insertNum(Node cur, double num) {
    double curNum = cur.val;
    if (num < curNum) {
      cur.leftCnt++;
      if (cur.left == null) {
        cur.left = new Node(num);
      } else {
        insertNum(cur.left, num);
      }
    } else {
      cur.rightCnt++;
      if (cur.right == null) {
        cur.right = new Node(num);
      } else {
        insertNum(cur.right, num);
      }
    }
  }

  public double getMediumValue(int target) {
    int idx = 0;
    Node node = root;

    while (node != null) {
      if (node.leftCnt + idx == target) {
        return node.val;
      } else if (idx + node.leftCnt > target) {
        node = node.left;
      }

      else {
        idx += node.leftCnt + 1;
        node = node.right;
      }
    }
    return -1;
  }

  public double findMedian() {
    int size = root.leftCnt + root.rightCnt + 1;
    int target1 = size / 2;
    int target2 = (size - 1) / 2;

    if (size % 2 != 0) {
      return getMediumValue(target1);
    }

    double first = getMediumValue(target2);
    double last = getMediumValue(target1);

    return (first + last) / 2;
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
