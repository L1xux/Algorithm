package LinkedList.DeletetheMiddleNodeofaLinkedList_2095_Steven;

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

public class DeletetheMiddleNodeofaLinkedList_2095_Steven {
  public static ListNode deleteMiddle(ListNode head) {
    if (head.next == null) {
      return null;
    }

    ListNode now = head;
    ListNode prev = now;
    ListNode fast = head;

    while (fast != null) {
      fast = fast.next;

      if (fast != null) {
        fast = fast.next;
      } else {
        break;
      }

      prev = now;
      now = now.next;
    }

    prev.next = now.next;
    return head;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 3, 4, 7, 1, 2, 6 };

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
    ListNode res = deleteMiddle(root);
    while (res != null) {
      System.out.println("Res: " + res.val);
      res = res.next;
    }
  }
}
