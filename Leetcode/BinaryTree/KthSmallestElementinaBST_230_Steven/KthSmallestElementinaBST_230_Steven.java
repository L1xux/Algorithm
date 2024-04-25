package BinaryTree.KthSmallestElementinaBST_230_Steven;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public boolean insertNunberIntoATree(TreeNode tree, int num) {
    if (tree == null) {
      return true;
    }

    else if (num < tree.val) {
      if (insertNunberIntoATree(tree.left, num)) {
        tree.left = new TreeNode(num);
      }
    } else {
      if (insertNunberIntoATree(tree.right, num)) {
        tree.right = new TreeNode(num);
      }
    }

    return false;
  }
}

public class KthSmallestElementinaBST_230_Steven {
  private static int res = -1;

  public static int help(TreeNode cur, int k, int step) {
    if (cur == null) {
      return step;
    }

    int curVal = cur.val;

    step = help(cur.left, k, step);
    step++;
    if (step == k) {
      res = curVal;
      return step;
    }
    step = help(cur.right, k, step);

    return step;
  }

  public static int kthSmallest(TreeNode root, int k) {
    help(root, k, 0);
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 3, 1, 4, 2 };
    int k = 2;

    TreeNode root = new TreeNode(nums[0]);

    for (int i = 1; i < nums.length; i++) {
      root.insertNunberIntoATree(root, nums[i]);
    }

    System.out.println("Res: " + kthSmallest(root, k));

  }
}
