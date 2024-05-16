package TwoPointer.MergekSortedLists_23.MergekSortedLists_23_Steven;

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

public class MergekSortedLists_23_Steven {
  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length <= 0) {
      return null;
    }

    boolean flag = false;
    ListNode res = new ListNode();

    ListNode cur = res;
    ListNode prev = cur;

    while (!flag) {
      int lowest = Integer.MAX_VALUE;
      int lowestNodIdx = -1;
      flag = true;

      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null && lists[i].val < lowest) {
          lowest = lists[i].val;
          lowestNodIdx = i;

          flag = false;
        }
      }

      if (lowestNodIdx != -1) {
        cur.val = lists[lowestNodIdx].val;
        cur.next = new ListNode();

        prev = cur;
        cur = cur.next;

        lists[lowestNodIdx] = lists[lowestNodIdx].next;
      }
    }

    if (cur == res) {
      res = null;
    }
    prev.next = null;

    return res;
  }

  public static void main(String[] args) {
    ListNode[] lists = new ListNode[3];

    lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
    lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
    lists[2] = new ListNode(2, new ListNode(6));

    ListNode res = mergeKLists(lists);
    while (res != null) {
      System.out.println("elem " + res.val);
      res = res.next;
    }

  }
}
