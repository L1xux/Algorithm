import java.io.*;
import java.util.*;

public class Uijin_1935 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        char[] s = br.readLine().toCharArray();
        Map<Character, Double> oper = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            oper.put((char)((int)'A' + i), Double.valueOf(br.readLine()));
        }

        Stack<Double> stack = new Stack<>();
            
        for(int i = 0 ; i < s.length ; i++){
            if(s[i]-'A' >= 0 && s[i]-'A' <= 25){ 
                stack.add(oper.get(s[i]));
            }  else {
                double right = stack.pop();
                double left = stack.pop();

                double candi = 0;
                
                switch (s[i]) {
                    case '+' -> candi = left + right;
                    case '-' -> candi = left - right;
                    case '*' -> candi = left * right;
                    case '/' -> candi = left / right;
                    default -> throw new AssertionError();
                }
                stack.add(candi);
            }
        }

        bw.write(String.format("%.2f", stack.pop()) + "\n");
        
        br.close();
        bw.flush();
        
    }
}