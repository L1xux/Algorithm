import java.io.*;
import java.util.*;

public class Uijin_14658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] stars = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken()); // x 좌표
            stars[i][1] = Integer.parseInt(st.nextToken()); // y 좌표
        }
        
        int maxSaved = 0;
        
        for (int i = 0; i < K; i++) {
            int trampolineX = stars[i][0];
            int trampolineY = stars[i][1];
            
            if (trampolineX + L > N) {
                trampolineX = N - L;
            }
            if (trampolineY + L > M) {
                trampolineY = M - L;
            }
            
            int count = 0;
            for (int j = 0; j < K; j++) {
                int starX = stars[j][0];
                int starY = stars[j][1];
                
                if (starX >= trampolineX && starX <= trampolineX + L &&
                    starY >= trampolineY && starY <= trampolineY + L) {
                    count++;
                }
            }
            
            maxSaved = Math.max(maxSaved, count);
        }
        
        System.out.println(K - maxSaved);
    }
}