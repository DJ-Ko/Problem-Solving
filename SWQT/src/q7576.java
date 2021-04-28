import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q7576 {
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m+1][n+1];
		visit = new boolean[m+1][n+1];
		
		for(int i=0; i<m; i++){
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = bfs();
		
		bw.write(String.valueOf(ans));
		bw.newLine();
		
		bw.close();
		br.close();
	}
	
	static int bfs(){
		
		Queue<Pos> q =new LinkedList<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					q.add(new Pos(i, j, 0));
					visit[i][j] = true;
				}else if(map[i][j] == -1){
					visit[i][j] = true;
				}
			}
		}
		
		int ans = 0;
		
		while(!q.isEmpty()){
			Pos cur = q.poll();
			
			int cx = cur.x;
			int cy = cur.y;
			int ctime = cur.time;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if (visit[nx][ny] == false && map[nx][ny] == 0) {
						visit[nx][ny] = true;
						ans = ctime + 1 > ans ? ctime + 1 : ans;
						q.add(new Pos(nx, ny, ctime + 1));
					}
				}
			}
		}
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(visit[i][j] == false){
					return -1;
				}
			}
		}
		
		return ans;
	}
	
	static class Pos {
		int x, y, time;

		public Pos(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
