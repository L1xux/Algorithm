package Quick.KthLargestElementinanArray_215.KthLargestElementinanArray_215_Steven;

import java.util.ArrayList;
import java.util.List;

/**
 * KthLargestElementinanArray_215_Steven
 */
public class KthLargestElementinanArray_215_Steven {

  public static int findKthLargest(int[] nums, int k) {
    int size = nums.length;
    List<Integer> src = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      src.add(nums[i]);
    }

    while (!src.isEmpty()) {
      int pivot = src.get(0);

      List<Integer> left = new ArrayList<Integer>();
      List<Integer> right = new ArrayList<Integer>();
      int equal = 0;

      int srcSize = src.size();
      for (int i = 0; i < srcSize; i++) {
        int cur = src.get(i);
        if (cur < pivot) {
          left.add(cur);
        } else if (cur == pivot) {
          equal++;
        } else {
          right.add(cur);
        }
      }

      if (right.size() >= k) {
        src = right;
      } else if (right.size() + equal >= k) {
        return pivot;
      } else {
        k -= (right.size() + equal);
        src = left;
      }

    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { -1, 2, 0 };
    int k = 2;

    int res = findKthLargest(nums, k);

    System.out.println("Res: " + res);
  }

}