import java.io.*;

public class Uijin_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String in = br.readLine();
            char[] cs = in.toLowerCase().toCharArray();
            int[] cnt = new int[27];

            int max = 0;

            for(int i = 0 ; i < cs.length ; i++) {
                int now = cs[i]-'a';
                cnt[now]++;
            
                max = Math.max(max, cnt[now]);
            }

            int maxIdx = 0;
            int mul = 0;

            for(int i = 0 ; i < cnt.length ; i++) {
                if(cnt[i] == max) {
                    maxIdx = i;
                    mul++;
                }
            }

            if(mul >= 2){
                bw.write("?\n");
            } else {
                bw.write(((char) ('A' + maxIdx)) + "\n");
            }
 
            bw.flush();
        }
    }
}