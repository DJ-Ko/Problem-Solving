import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q11725 {
	
	static ArrayList<ArrayList<Integer>> tree;
	static int[] parents;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		parents = new int[n+1];
		
		for(int i=0; i<=n+1; i++){
			tree.add(new ArrayList<>());
		}
		
		for(int i=1; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		bfs(1);
		
		for(int i=2; i<=n; i++){
			bw.write(String.valueOf(parents[i]));
			bw.newLine();
		}
		
		bw.close();
		br.close();
	}
	
	static void bfs(int start){
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		parents[start] = 1;
		
		while (!q.isEmpty()) {
			int parent = q.poll();

			for (int child : tree.get(parent)) {
				if (parents[child] == 0) {
					parents[child] = parent;
					q.add(child);
				}
			}
		}
	}
}
