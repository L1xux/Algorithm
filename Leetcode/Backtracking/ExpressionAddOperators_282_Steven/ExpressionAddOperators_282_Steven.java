package Backtracking.ExpressionAddOperators_282_Steven;

import java.util.*;

public class ExpressionAddOperators_282_Steven {
  private static char[] operators = new char[] { '.', '+', '-', '*' };

  public static int getCal(char type, int first, int second, int mul, int prevInt) {
    int res = 0;
    switch (type) {
      case '+':
        res = first + second;
        break;
      case '-':
        res = first - second;
        break;
      case '*':
        res = (first + mul) + prevInt * second;
        break;
    }

    return res;
  }

  public static int getMul(char type, int first, int second) {
    switch (type) {
      case '+':
        return -second;
      case '-':
        return second;
      case '*':
        return -(first * second - first);
    }

    return -1;
  }

  public static void solve(char[] nums, int numIdx, int cal, String candidate, List<String> ans, int target, int mul,
      int prevInt) {
    if (numIdx >= nums.length) {
      System.out.println("cal is " + cal + " candidate is " + candidate);
      if (cal == target) {
        ans.add(candidate.substring(0, candidate.length()));
      }
      return;
    }

    for (int i = 0; i < 4; i++) {
      char operator = operators[i];
      int nowDigit = nums[numIdx] - '0';
      int concatenated = cal * 10 + nowDigit;

      int nextCal = getCal(operator, cal, nowDigit, mul, prevInt);

      String expression = candidate + operator + nowDigit;
      System.out.println("nextcal is " + nextCal + " expression is " + expression);

      int nextMul = getMul(operator, cal, nowDigit);

      // solve(nums, 2, '*', firstDigit * secondDigit, firstDigit + "*" + secondDigit,
      // ans, target);
      if (operator == '.') {
        solve(nums, numIdx + 1, concatenated, "" + concatenated, ans, target, 0, concatenated);
      } else {
        solve(nums, numIdx + 1, nextCal, expression, ans, target, nextMul, nowDigit);
      }
    }
  }

  public static List<String> addOperators(String num, int target) {
    List<String> ans = new ArrayList<>();
    char[] nums = num.toCharArray();

    solve(nums, 0, 0, "", ans, target, 0, 0);
    // solve(nums, 2, '.', Integer.parseInt(firstDigit + "" + secondDigit),
    // firstDigit + "" + secondDigit, ans, target);
    // solve(nums, 2, '+', firstDigit + secondDigit, firstDigit + "+" + secondDigit,
    // ans, target);
    // solve(nums, 2, '-', firstDigit - secondDigit, firstDigit + "-" + secondDigit,
    // ans, target);
    // solve(nums, 2, '*', firstDigit * secondDigit, firstDigit + "*" + secondDigit,
    // ans, target);

    return ans;
  }

  public static void main(String[] args) {
    List<String> res = addOperators("232", 8);

    Iterator<String> resIte = res.iterator();
    while (resIte.hasNext()) {
      System.out.println("res: " + resIte.next());
    }

  }
}
