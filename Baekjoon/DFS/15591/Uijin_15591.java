import java.io.*;
import java.util.*;


class Node {
    int now, usado;

    Node(int now, int usado){
        this.now = now;
        this.usado = usado;
    }
}

public class Uijin_15591 {    
    static int res = 0;

    public static int updateMinUsado(int now, int usado, int k, boolean[] visited, Map<Integer, List<Node>> graph)  {
        List<Node> nodes = graph.getOrDefault(now, null);
    
        if(nodes == null){
            return usado;
        }

        for(int i = 0 ; i < nodes.size() ; i++){
            int next = nodes.get(i).now;
            int nodUsado = nodes.get(i).usado;

            int nextUsado = Math.min(nodUsado, usado);

            if(!visited[next] && nextUsado >= k){
                visited[next] = true;
                res++;
                
                updateMinUsado(next, nextUsado, k, visited, graph);
            }
        }

        return usado;
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            
            Map<Integer, List<Node>> graph = new HashMap<>();
            for(int i = 0 ; i < N-1 ; i++){
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int dst = Integer.parseInt(st.nextToken());
                int usado = Integer.parseInt(st.nextToken());

                Node nod = new Node(dst, usado);
                List<Node> now = graph.getOrDefault(start, new ArrayList<>());

                now.add(nod);
                graph.put(start, now);

                nod = new Node(start, usado);
                now = graph.getOrDefault(dst, new ArrayList<>());

                now.add(nod);
                graph.put(dst, now);
            }

            for(int i = 0 ; i < Q ; i++){
                st = new StringTokenizer(br.readLine());

                int usado = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());

                boolean[] visited = new boolean[N+1];
                visited[start] = true;
                
                res = 0;

                updateMinUsado(start, Integer.MAX_VALUE, usado, visited, graph);            
                bw.write(res +"\n");
            }

            bw.flush();
        }
    }
}
