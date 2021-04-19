import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q10819 {
	static int[] nums;
	static int[] makeArr;
	static int n, max = Integer.MIN_VALUE;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		makeArr = new int[n];
		visit = new boolean[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		solve(0);
		
		System.out.println(max);

	}
	
	public static void solve(int idx){
		if(idx == n){
			int sum = 0;
			for(int i=0; i<n-1; i++){
				sum+=Math.abs(makeArr[i]-makeArr[i+1]);
			}
			max = max < sum ? sum : max;
			return;
		}
		for(int i=0; i<n; i++){
			if(visit[i] == true){
				continue;
			}
			visit[i] = true;
			makeArr[idx] = nums[i];
			solve(idx+1);
			visit[i] = false;
		}
	}

	
}
