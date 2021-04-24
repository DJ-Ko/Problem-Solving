import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2589 {
	
	static int r,c;
	static char[][] map;
	static boolean[][] visit;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r+1][c+1];
		visit = new boolean[r+1][c+1];
		
		int max = 0;
		
		for(int i=0; i<r; i++){
//			char[] tmp = br.readLine().toCharArray();
			map[i] = br.readLine().toCharArray();
//			for(int j=0; j<c; j++){
//				map[i][j] = tmp[j];
////				if(map[i][j] == 'L'){
////					visit[i][j] = true;
////				}
//			}
		}
		
//		bfs(3,0);
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'L') {
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		
		bw.write(String.valueOf(max));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bfs(int sx,int sy){
		
		Queue<Position> q = new LinkedList<>();
		boolean[][] visit = new boolean[r + 1][c + 1];
		
		int max = 0;

		q.add(new Position(sx, sy, 0));
		visit[sx][sy] = true;

		while (!q.isEmpty()) {
			
			Position curPos = q.poll();
			max = curPos.time > max ? curPos.time : max;
//			print(visit);
			
			for (int i = 0; i < 4; i++) {
				int nx = curPos.x + dx[i];
				int ny = curPos.y + dy[i];

				if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if (visit[nx][ny] == false&& map[nx][ny] == 'L') {
						visit[nx][ny] = true;
						q.add(new Position(nx, ny, curPos.time+1));
					}
				}
			}
		}
		
		return max;
	}
	
	static void print(boolean[][] visit){
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				System.out.print(visit[i][j] +"\t");
			}
			System.out.println();
		}
		
		System.out.println("=====================");
	}

	static class Position {
		int x;
		int y;
		int time;
		public Position(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
