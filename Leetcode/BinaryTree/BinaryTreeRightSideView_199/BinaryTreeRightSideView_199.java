package BinaryTree.BinaryTreeRightSideView_199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class BinaryTreeRightSideView_199 {
  public static void help(List<Integer> res, TreeNode cur, Map<Integer, Integer> levels, int level) {
    if (cur == null) {
      return;
    }

    int isLevelAssigned = levels.getOrDefault(level, -1);

    if (isLevelAssigned == -1) {
      levels.put(level, 1);
      res.add(cur.val);
    }

    help(res, cur.right, levels, level + 1);
    help(res, cur.left, levels, level + 1);
  }

  public static List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Map<Integer, Integer> levels = new HashMap<>();

    List<Integer> res = new ArrayList<>();
    res.add(root.val);

    help(res, root.right, levels, 1);
    help(res, root.left, levels, 1);

    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);

    List<Integer> res = rightSideView(root);
    for (Integer num : res) {
      System.out.println(num);
    }

  }
}
