import java.io.*;
import java.util.*;


class Node {
    int row, col, move;

    Node(int row, int col, int move){
        this.row = row;
        this.col = col;
        this.move = move;
    }
}

public class Uijin_14940 {
    static int[] NR = new int[] {-1, 1, 0, 0};
    static int[] NC = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[H][W];

            Node start = new Node(0, 0, 0);

            for(int i = 0 ; i < H ; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0 ; j < W ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());                    
                
                    if(map[i][j] == 2) {
                        start = new Node(i, j, 0);
                    }
                }
            }

            int[][] res = new int[H][W];
            boolean[][] visited = new boolean[H][W];

            Queue<Node> q = new LinkedList<>();
            
            q.add(start);
            visited[start.row][start.col] = true;

            while(!q.isEmpty()){
                Node now = q.poll();
                
                int row = now.row;
                int col = now.col;
                int move = now.move;
                
                for(int i = 0 ; i < 4 ; i++){
                    int nextR = row + NR[i];
                    int nextC = col + NC[i];

                    if(nextR < 0 || nextR >= H || nextC < 0 || nextC >= W || visited[nextR][nextC] || map[nextR][nextC] != 1){
                        continue;
                    }

                    visited[nextR][nextC] = true;
                    res[nextR][nextC] = move+1;
                    q.add(new Node(nextR, nextC, move + 1));
                }
            }


            for(int i = 0 ; i < H ; i++) {
                for(int j = 0 ; j < W ; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        res[i][j] = -1;
                    }

                    bw.write(res[i][j] + " ");
                }
                bw.write("\n");
            }

            bw.flush();
        }
    }
}
