package TwoPointer.RemoveDuplicatesfromSortedListII_82_Steven;

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

public class RemoveDuplicatesfromSortedListII_82_Steven {
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode(-1, head);
    ListNode first = dummy;
    ListNode last = dummy.next;

    while (last != null) {
      int pivot = last.val;

      boolean flag = false;

      while (last.next != null && pivot == last.next.val) {
        last = last.next;
        flag = true;
      }

      if (flag) {
        first.next = last.next;
      } else {
        first = last;
      }

      last = last.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 1, 1, 2, 3 };

    ListNode head = new ListNode(1);
    ListNode root = head;

    for (int i = 1; i < nums.length; i++) {
      head.next = new ListNode(nums[i]);
      head = head.next;
    }

    ListNode cur = deleteDuplicates(root);

    while (cur != null) {
      System.out.println("value: " + cur.val);
      cur = cur.next;
    }

  }
}
