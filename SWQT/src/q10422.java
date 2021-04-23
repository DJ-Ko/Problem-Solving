import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q10422 {
	
	static long[] dp;
	static int n, max = 5000;
	static final long _MOD = 1000000007L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());

		dp = new long[max + 1];
		dp[0] = dp[2] = 1;

		for (int i = 2; i <= 2500; i++) {
			for (int j = 0; j <= i - 1; j++) {
				dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
				dp[i * 2] %= 1000000007L;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < n; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(String.valueOf(dp[num])+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
