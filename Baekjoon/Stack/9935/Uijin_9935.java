import java.io.*;
import java.util.*;

public class Uijin_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] s = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int sSize = s.length;
        int bombLen = bomb.length;
        
        for(int i = 0 ; i < sSize ; i++){
            stack.add(s[i]);

            if (stack.size() >= bombLen) {
                boolean isMatch = true;

                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bomb[j]) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()){
            bw.write("FRULA\n");
            bw.flush();
            return;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        bw.write(result.toString() + "\n");
        bw.flush();

    }
}