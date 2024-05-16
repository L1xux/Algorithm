package Stack.VerifyPreorderSequenceinBinarySearchTree_255.VerifyPreorderSequenceinBinarySearchTree_255_Steven;

public class VerifyPreorderSequenceinBinarySearchTree_255_Steven {
  public static boolean verifyPreorder(int[] po) {
    int low = Integer.MIN_VALUE;

    int i = -1;
    for (int p : po) {
      if (p < low) {
        return false;
      }

      while (i >= 0 && po[i] < p) {
        low = po[i--];
      }

      po[++i] = p;
    }

    return true;
  }

  public static void main(String[] args) {
    int[] p = new int[] { 5, 2, 1, 3, 6 };
    boolean res = verifyPreorder(p);

    System.out.println("Res: " + res);
  }
}
