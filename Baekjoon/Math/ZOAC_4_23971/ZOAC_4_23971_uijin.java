
import java.io.*;
import java.util.*;

public class ZOAC_4_23971_uijin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            float h = Float.parseFloat(st.nextToken());
            float w = Float.parseFloat(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int hr = (int) Math.ceil(h / (n + 1));
            int wr = (int) Math.ceil(w / (m + 1));
            
            bw.write((hr*wr) + "\n");
            bw.flush();
        }
    }
}