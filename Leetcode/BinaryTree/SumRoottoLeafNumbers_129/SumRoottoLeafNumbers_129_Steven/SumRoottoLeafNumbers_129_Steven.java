package BinaryTree.SumRoottoLeafNumbers_129_Steven;

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

    else if (num > tree.val) {
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

public class SumRoottoLeafNumbers_129_Steven {

  public static int help(TreeNode curr, String candi) {
    if (curr == null) {
      return 0;
    }

    int res = 0;
    StringBuilder sb = new StringBuilder();

    sb.append(candi);
    sb.append(curr.val);

    if (curr.left == null && curr.right == null) {
      return Integer.parseInt(sb.toString());
    }

    res += help(curr.left, sb.toString());
    res += help(curr.right, sb.toString());

    return res;
  }

  public static int sumNumbers(TreeNode root) {
    int res = help(root, "");
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 4, 9, 0, 5, 1 };

    TreeNode root = new TreeNode(nums[0]);

    for (int i = 1; i < nums.length; i++) {
      root.insertNunberIntoATree(root, nums[i]);
    }

    int res = sumNumbers(root);
    System.out.println("Res: " + res);
  }
}
