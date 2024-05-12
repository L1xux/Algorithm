package LinkedList.ReverseLinkedListII_92_Steven;

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

public class ReverseLinkedListII_92_Steven {

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == right) {
      return head;
    }

    int cnt = 1;

    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode leftmost = dummy;

    while (cnt < left) {
      leftmost = leftmost.next;
      head = head.next;

      cnt++;
    }

    ListNode last = head;

    ListNode prev = head;
    ListNode now = head.next;

    ListNode rightmost = now.next;

    while (cnt < right) {
      ListNode next = now.next;
      now.next = prev;
      prev = now;
      now = next;

      rightmost = next;

      cnt++;
    }

    leftmost.next = prev;
    last.next = rightmost;

    return dummy.next;
  }

  public static void main(String[] args) {
    int left = 1;
    int right = 2;

    ListNode head = new ListNode(1);
    ListNode cur = head;

    for (int i = 2; i <= 5; i++) {
      cur.next = new ListNode(i);
      cur = cur.next;
    }

    ListNode res = reverseBetween(head, left, right);
    while (res != null) {
      System.out.println("Num: " + res.val);
      res = res.next;
    }

  }
}
