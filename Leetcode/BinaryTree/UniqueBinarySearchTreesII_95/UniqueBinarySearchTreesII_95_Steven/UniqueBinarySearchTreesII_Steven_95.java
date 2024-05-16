package BinaryTree.UniqueBinarySearchTreesII_95.UniqueBinarySearchTreesII_95_Steven;

import java.util.*;

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

public class UniqueBinarySearchTreesII_Steven_95 {
  public static List<TreeNode> help(int start, int end) {
    List<TreeNode> res = new ArrayList<>();

    if (start > end) {
      res.add(null);
      return res;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftTrees = help(start, i - 1);
      List<TreeNode> rightTrees = help(i + 1, end);

      for (TreeNode l : leftTrees) {
        for (TreeNode r : rightTrees) {
          TreeNode now = new TreeNode(i);

          now.left = l;
          now.right = r;

          res.add(now);
        }
      }
    }

    return res;
  }

  public static List<TreeNode> generateTrees(int n) {
    List<TreeNode> res = help(1, n);
    return res;
  }

  public static void main(String[] args) {
    generateTrees(3);
  }
}
