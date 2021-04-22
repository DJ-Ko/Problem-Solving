import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q9251 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int[][] dp = new int[str1.length+1][str2.length+1];
		
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}
				
			}
		}
		
//		for(int i=0; i<=str1.length; i++){
//			for(int j=0; j<=str2.length; j++){
//				System.out.print(dp[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		bw.write(String.valueOf(dp[str1.length][str2.length]));
		bw.flush();
		bw.close();
		br.close();
	}

}
