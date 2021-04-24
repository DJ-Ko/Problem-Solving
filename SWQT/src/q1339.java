import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1339 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n+1];
		int[] alpha = new int[26];
		
		for(int i=0; i<n; i++){
			words[i] = br.readLine();
		}
		
		for(int i=0; i<n; i++){
			int pow = (int) Math.pow(10, words[i].length()-1);
			for (int j = 0; j < words[i].length(); j++) {
				alpha[words[i].charAt(j) - 65] += pow;
				pow /= 10;
			}
		}
		
		Arrays.sort(alpha);
		int weight = 9;
		int sum = 0;

		for (int i = alpha.length - 1; i >= 0; i--) {
			if (alpha[i] == 0) {
				break;
			}
			sum += (alpha[i] * weight);
			weight--;
		}
		
		bw.write(String.valueOf(sum));
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
	}
}
