import java.io.*;
import java.util.*;

public class Uijin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] l = new int[3];
            
            l[0] = Integer.parseInt(st.nextToken());
            l[1] = Integer.parseInt(st.nextToken());
            l[2] = Integer.parseInt(st.nextToken());

            if(l[0] == 0 && l[1] == 0 && l[2] == 0){
                break;
            }
            
            Arrays.sort(l);

            if(l[2] >= l[0] + l[1]){
                bw.write("Invalid\n");
            } else if(l[0] == l[1] && l[1] == l[2]) {
                bw.write("Equilateral\n");
            } else if(l[0] == l[1] || l[1] == l[2] || l[0] == l[2]){
                bw.write("Isosceles\n");
            } else {
                bw.write("Scalene\n");
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
