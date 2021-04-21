import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q9613 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] nums; 
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			nums = new int[len];
			
			for (int j = 0; j < len; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			for (int j = 0; j < len-1; j++) {
				for (int k = j + 1; k < len; k++) {
					sum += getGCD(nums[j], nums[k]);
				}
			}
			bw.write(String.valueOf(sum));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int getGCD(int a, int b){
		if(a < b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while(true){
			int m = a%b;

			if (m == 0) {
				return b;
			} else if (m == 1) {
				return 1;
			}
			
			a = b;
			b = m;
		}
//		if(b == 0){
//			return a;
//		}
//		return getGCD(b, a%b);
	}

}
