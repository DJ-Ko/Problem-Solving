import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11404 {
	static final int _MAX = 1000000000;
	static int n,m;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		dist = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		for(int i=1; i<=n; i++){
			Arrays.fill(map[i], _MAX);
			map[i][i] = 0;
		}
		
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if (map[a][b] > w)
				map[a][b] = w;
		}
		
		for (int i = 1; i <= n; i++)
			Arrays.fill(dist[i], _MAX);
		
		for(int i=1; i<=n; i++){
			dijkstra(i);
		}
		
		
		for (int i = 1; i <= n; i++) {
			for(int j=1; j<=n; j++){
				bw.write(dist[i][j]+" ");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dijkstra(int start){
		dist[start][start] = 0;
		
		for(int i = 1; i<n; i++){
			int min = _MAX;
			int index = -1;
			
			for (int j = 1; j <= n; j++) {
				if (visit[start][j] == false && min > dist[start][j]) {
					index = j;
					min = dist[start][j];
				}
			}
			if(index == -1){
				continue;
			}
			for (int j = 1; j <= n; j++) {
				if (visit[start][j] == false && map[index][j] != 0 && dist[start][index] != _MAX
						&& dist[start][index] + map[index][j] < dist[start][j]) {
					dist[start][j] = dist[start][index] + map[index][j];
				}
			}
			visit[start][index] = true; 
		}
	}

}


/***
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1000000000;
	static int n,m;
	static int[][] distance;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		distance = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(distance[i], INF);
			distance[i][i] = 0;
		}
		
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
//			if (distance[a][b] > w)
//				distance[a][b] = w;
			  distance[a][b] = Math.min(distance[a][b], w);    
		}
		
		floydWarshall();
		
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (distance[i][j] >= INF) {
					bw.write("0 ");
				} else {
					bw.write(distance[i][j] + " ");
				}
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void floydWarshall() {
		for (int c = 1; c <= n; c++) {
			for (int from = 1; from <= n; from++) {
				for (int to = 1; to <= n; to++) {
					distance[from][to] = Math.min(distance[from][c] + distance[c][to], distance[from][to]);
				}
			}
		}
	}

}
*/