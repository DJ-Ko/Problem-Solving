import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q10972 {

	static int[] nums;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int lpart = -1, rpart = -1;
		
		// 오른쪽부터 탐색해서 오른차순이 되는 부분을 찾음
		for (int i = n - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				lpart = i - 1;
				rpart = i;
				break;
			}
		}
		
		// 오름차순이 되는 부분이 없다면 모든 순열이 완전 내림차순이라는 뜻이므로 다음 순열이 존재하지 않아 -1 출력
		if (lpart == -1 && rpart == -1) {
			System.out.println(-1);
			return;
		}
		
		solve(lpart,rpart);
		sort(rpart, n);
		
		for(int i=0; i<nums.length; i++){
			bw.write(nums[i]+" ");
		}
		
		bw.newLine();
		bw.flush();
		bw.close();
		
	}

	public static void solve(int lpart, int rpart) {
		//뒤에서부터 오름차순이 되는 부분을 기준으로 왼쪽(작은수)와 오른쪽 영역(큰수부터 순열 끝)
		//오른쪽 영역의 뒤부터 차례대로 왼쪽 수(작은수)를 비교하는데 더 큰수를 찾아서 바꿔줌
		for (int i = n - 1; i >= rpart; i--) {
			if (nums[lpart] < nums[i]) {
				int tmp = nums[lpart];
				nums[lpart] = nums[i];
				nums[i] = tmp;
				break;
			}
		}
	}
	
	public static void sort(int start, int end){
		//오른쪽 영역을 오름 차순으로 정렬함
		for(int i=start; i < end; i++){
			int min = i;
			for(int j = i+1; j<end; j++){
				if(nums[min]>nums[j]){
					min = j;
				}
			}
			int tmp = nums[min];
			nums[min] = nums[i];
			nums[i] = tmp;
		}
	}

}
