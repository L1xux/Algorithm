package LinkedList.OddEvenLinkedList_328_Steven;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class OddEvenLinkedList_328_Steven {
  public static ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode root = head;
    ListNode even = head.next;

    ListNode now = head;
    ListNode prev = now;
    int size = 1;

    while (now.next != null) {
      ListNode next = now.next;
      now.next = next.next;

      prev = now;
      now = next;

      size++;
    }

    if (size % 2 == 0) {
      prev.next = even;
    } else {
      now.next = even;
    }

    return root;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };

    int size = nums.length;
    ListNode root = new ListNode();
    ListNode cur = root;
    ListNode prev = cur;

    for (int i = 0; i < size; i++) {
      cur.val = nums[i];
      cur.next = new ListNode();
      prev = cur;
      cur = cur.next;
    }

    prev.next = null;
    ListNode res = oddEvenList(root);
    while (res != null) {
      System.out.println("Res: " + res.val);
      res = res.next;
    }

  }
}
