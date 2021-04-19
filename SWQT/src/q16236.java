import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16236 {
	
	static int[][] map;
//	static int[][] visit;
//	static int idx = 1;
	static int[][] dist;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int sharkX = 0, sharkY = 0, size = 2, eCnt = 0;
	static int ans = 0, n;
	static int minX;
	static int minY;
	static int minDist;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		dist = new int[n][n];
//		visit = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
//					visit[i][j] = idx++;
				}
			}
		}
		
		while(true){
			dist = new int[n][n];
			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
			minDist = Integer.MAX_VALUE;
			
			bfs(sharkX, sharkY);
			
			if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE){
				eCnt++;
				map[minX][minY] = 0;
				sharkX = minX;
				sharkY = minY;
//				visit[minX][minY] = idx++;
//				print();
				ans += dist[sharkX][sharkY];
				
				if(eCnt == size){
					size++;
					eCnt = 0;
				}
			}else{
				break;
			}
		}
		
		System.out.println(ans);
//		bw.write(ans);
		
		bw.flush();
		bw.close();
		br.close();
	}
//	public static void print(){
//		for(int i=0; i<n; i++){
//			for(int j=0; j<n; j++){
//				System.out.print(visit[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println("=================================");
//	}
	
	public static void bfs(int x, int y){
		Queue<Pos> q = new LinkedList<>();
		
		q.add(new Pos(x, y));
		
		while(!q.isEmpty()){
			Pos cur = q.poll();
			
			for(int i=0; i<4; i++){
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if(map[nx][ny] <= size && dist[nx][ny] == 0){
						dist[nx][ny] = dist[cur.x][cur.y]+1;
						
						if(map[nx][ny] < size && map[nx][ny] != 0){
							if(minDist > dist[nx][ny]){
								minDist = dist[nx][ny];
								minX = nx;
								minY = ny;
							}else if(minDist == dist[nx][ny]){
								if(minX == nx){
									if(minY > ny){
										minY = ny;
									}
								}else if(minX > nx){
									minX = nx;
									minY = ny;
								}
							}
						}
						q.add(new Pos(nx,ny));
					}
				}
			}
		}
	}
	
	

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
