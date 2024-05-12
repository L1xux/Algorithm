package BinaryTree.MaximumSumBSTinBinaryTree_1373_Steven;

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
}

public class MaximumSumBSTinBinaryTree_1373_Steven {
  static int res = 0;

  static final int MAX_VALUE = 987654321;
  static final int MIN_VALUE = -987654321;

  public static int[] solve(TreeNode now) {
    int[] ret = new int[4];

    if (now == null) {
      ret[0] = MAX_VALUE;
      ret[1] = MIN_VALUE;
      ret[2] = 0;
      ret[3] = 1;

      return ret;
    }

    int nowVal = now.val;

    if (now.left == null && now.right == null) {
      res = Math.max(res, nowVal);
      ret[0] = ret[1] = ret[2] = nowVal;

      return ret;
    }

    TreeNode left = now.left;
    TreeNode right = now.right;

    int[] leftValue = solve(left);
    int[] rightValue = solve(right);

    if (leftValue[3] == -1 || rightValue[3] == -1) {
      return ret;
    }

    int leftVal = leftValue[2];
    int rightVal = rightValue[2];

    if ((leftValue[1] >= nowVal) || (left != null && left.val >= nowVal)
        || (rightValue[0] <= nowVal) || (right != null && right.val <= nowVal)) {
      ret[3] = -1;
      return ret;
    }

    int total = leftVal + rightVal + nowVal;

    int mini = Math.min(leftValue[0], rightValue[0]);
    int minimum = Math.min(nowVal, mini);

    int max = Math.max(leftValue[1], rightValue[1]);
    int maximum = Math.max(nowVal, max);

    ret[0] = minimum;
    ret[1] = maximum;
    ret[2] = total;
    ret[3] = 1;

    res = Math.max(res, total);

    return ret;
  }

  public static int maxSumBST(TreeNode root) {
    res = 0;
    solve(root);
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(3);

    int result = maxSumBST(root);
    System.out.println("Result: " + result);

  }
}

// res: 20

// TreeNode root = new TreeNode(1);
// root.left = new TreeNode(4);
// root.left.left = new TreeNode(2);
// root.left.right = new TreeNode(4);
// root.right = new TreeNode(3);
// root.right.left = new TreeNode(2);
// root.right.right = new TreeNode(5);
// root.right.right.left = new TreeNode(4);
// root.right.right.right = new TreeNode(6);

// res: 2

// TreeNode root = new TreeNode(4);
// root.left = new TreeNode(3);
// root.left.left = new TreeNode(1);
// root.left.right = new TreeNode(2);

// 7

// TreeNode root = new TreeNode(5);
// root.left = new TreeNode(4);
// root.left.left = new TreeNode(3);
// root.right = new TreeNode(8);
// root.right.left = new TreeNode(6);
// root.right.right = new TreeNode(3);