import java.io.*;
import java.util.*;


class Node {
    int row, col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Uijin_14466 {    
    static int[] NR = new int[]{-1, 1, 0, 0};
    static int[] NC = new int[]{0, 0, -1, 1};
    static int res = 0;

    public static void bfs(Node start, Node dst, int N, boolean[][][][] road) {
        boolean[][] map = new boolean[N+1][N+1];

        Queue<Node> q = new LinkedList<>();
        q.add(start);

        map[start.row][start.col] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.row == dst.row && now.col == dst.col) {
                return;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nextR = now.row + NR[i];
                int nextC = now.col + NC[i];

                if(nextR < 1 
                    || nextR > N 
                    || nextC < 1
                    || nextC > N 
                    || road[now.row][now.col][nextR][nextC] || map[nextR][nextC]) {
                        continue;
                }

                map[nextR][nextC] = true;
                q.add(new Node(nextR, nextC));
            }
        }

        res++;
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            
            boolean[][][][] road = new boolean[N+1][N+1][N+1][N+1];
            
            for(int i = 0 ; i < R ; i++){
                st = new StringTokenizer(br.readLine());
                
                int startR = Integer.parseInt(st.nextToken());
                int startC = Integer.parseInt(st.nextToken());
                int dstR = Integer.parseInt(st.nextToken());
                int dstC = Integer.parseInt(st.nextToken());

                road[startR][startC][dstR][dstC] = true;
                road[dstR][dstC][startR][startC] = true;
            }

            List<Node> cows = new ArrayList<>();
            for(int i = 0 ; i < K ; i++) {
                st = new StringTokenizer(br.readLine());

                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());

                cows.add(new Node(row, col));
            }

            int cowSize = cows.size();

            for(int i = 0 ; i < cowSize ; i++) {
                for(int j = i+1 ; j < cowSize ; j++) {
                    bfs(cows.get(i), cows.get(j), N, road);
                }
            }

            bw.write(res + "\n");
            bw.flush();
        }
    }
}