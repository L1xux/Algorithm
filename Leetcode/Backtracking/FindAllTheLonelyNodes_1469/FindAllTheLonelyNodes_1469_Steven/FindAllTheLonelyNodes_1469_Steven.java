package Backtracking.FindAllTheLonelyNodes_1469.FindAllTheLonelyNodes_1469_Steven;

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

public class FindAllTheLonelyNodes_1469_Steven {

  public static void help(TreeNode now, List<Integer> res) {
    if (now == null || (now.left == null && now.right == null)) {
      return;
    }

    if (now.left != null && now.right == null) {
      res.add(now.left.val);
    } else if (now.left == null && now.right != null) {
      res.add(now.right.val);
    }

    help(now.left, res);
    help(now.right, res);
  }

  public static List<Integer> getLonelyNodes(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    help(root, res);
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode();
    root.val = 1;
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
  }
}
