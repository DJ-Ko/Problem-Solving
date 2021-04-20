import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q12865 {
	
	static int[][] dp;
	static int w,n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		dp = new int[n + 1][w + 1];
		
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if(weight[i] > j){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = Math.max(value[i] + dp[i - 1][j - weight[i]], dp[i - 1][j]);
				}
			}
		}
		
		System.out.println(dp[n][w]);
		

	}

}
