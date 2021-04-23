import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q2487 {
	
	static int n;
	static int[] nums;
	static boolean[] sameCycle;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		nums = new int[n+1];
		sameCycle = new boolean[n+1];
		
		for(int i=1; i<=n; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 1;
		for(int i=1; i<=n; i++){
			if(sameCycle[i]==true){
				continue;
			}
			ans = lcm(ans, countCycle(i));
		}
		bw.write(String.valueOf(ans));
		bw.newLine();
		
		
		bw.close();
		br.close();
	}

	public static int countCycle(int start) {
		int cnt = 1;
		int next = nums[start];

		while (true) {
			if (next == start) {
				return cnt;
			}
			sameCycle[next] = true;
			next = nums[next];
			cnt++;
		}
	}
	
	public static int gcd(int a, int b){
		while(b!=0){
			int r = a%b;
			a = b;
			b = r;
		}
		
		return a;
	}
	public static int lcm(int a, int b){
		return a/gcd(a,b)*b;
	}
}
