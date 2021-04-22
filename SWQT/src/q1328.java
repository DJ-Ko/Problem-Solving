import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q1328 {
	
	static int N,L,R;
	static long[][][] dp;
	static final int _MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		dp = new long[101][101][101];
		
		dp[1][1][1] = 1;
		dp[2][1][2] = dp[2][2][1] = 1;
		
		for (int i = 3; i <= N; i++) {
			for (int l = 1; l <= L; l++) {
				for (int r = 1; r <= R; r++) {
					dp[i][l][r] = (dp[i - 1][l - 1][r] + dp[i - 1][l][r - 1] + dp[i - 1][l][r] * (i - 2)) % _MOD;
				}
			}
		}
		
		bw.write(String.valueOf(dp[N][L][R] % _MOD));
		bw.flush();
		bw.close();
		br.close();
	}

}
